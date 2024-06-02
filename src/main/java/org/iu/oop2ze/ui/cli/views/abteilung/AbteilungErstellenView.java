package org.iu.oop2ze.ui.cli.views.abteilung;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;

import java.util.Arrays;

import static org.iu.oop2ze.ui.cli.helpers.MenuHelper.boolToHumanReadable;

/**
 * Klasse, welche eine Abteilung erstellt
 *
 * @author Julius Beier, Nico Nimschofsky
 * @see CliComponent
 */
public class AbteilungErstellenView extends CliComponent {
    @LazyInject
    private IAbteilungService abteilungService;

    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @Override
    public void exec() {
        Abteilung neueAbteilung = null;

        String name = null;
        Boolean isHr = false;
        Mitarbeiter leitenderMitarbeiter = null;
        Mitarbeiter lastLeitenderMitarbeiter = null;

        do {
            EingabeHelper.clearConsole();

            System.out.println("Abteilung - Erstellen");

            var namePrompt = PromptHelper.erstellInputPrompt("Name der Abteilung%s: ", name == null ? "" : name);
            name = EingabeHelper.stringEingabe(namePrompt, name);

            var isHrPrompt = PromptHelper.erstellInputPrompt("Human Resource-fähig%s: ", boolToHumanReadable(isHr));
            isHr = EingabeHelper.menuEinzelEingabe(isHrPrompt, Arrays.asList(true, false), MenuHelper::boolToHumanReadable);

            if (isHr == null)
                isHr = false;

            if (!isHr)
                leitenderMitarbeiter = AbteilungHelper.gibLeitenderMitarbeiter(leitenderMitarbeiter, lastLeitenderMitarbeiter, mitarbeiterService);
            else
                // Kann in diesem Falle nur der Systemadministrator sein
                leitenderMitarbeiter = UserHelper.getAngemeldeterMitarbeiter();

            if (leitenderMitarbeiter != null)
                lastLeitenderMitarbeiter = leitenderMitarbeiter;

            if (leitenderMitarbeiter == null)
                continue;

            neueAbteilung = abteilungService.erstelleAbteilung(name, isHr, leitenderMitarbeiter);
            if (neueAbteilung == null)
                EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
        } while (neueAbteilung == null);
    }
}

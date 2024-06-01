package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;

/**
 * Klasse, welche einen Mitarbeiter erstellen lässt
 *
 * @author Julius Beier
 * @see CliComponent
 */
public class MitarbeiterErstellenView extends CliComponent {
    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @LazyInject
    private IAbteilungService abteilungService;

    @Override
    public void exec() {
        Mitarbeiter neuerMitarbeiter = null;

        String name = null;
        String vorname = null;
        String personalnummer = null;
        Abteilung abteilung = null;
        Abteilung lastAbteilung = null;

        do {
            EingabeHelper.clearConsole();

            System.out.println("Mitarbeiter - Erstellen");

            var namePrompt = PromptHelper.erstellInputPrompt("Name des Mitarbeiters%s: ", name == null ? "" : name);
            name = EingabeHelper.stringEingabe(namePrompt, name);

            var vornamePrompt = PromptHelper.erstellInputPrompt("Vorname des Mitarbeiters%s: ", vorname == null ? "" : vorname);
            vorname = EingabeHelper.stringEingabe(vornamePrompt, vorname);

            var personalnummerPrompt = PromptHelper.erstellInputPrompt("Personalnummer des Mitarbeiters%s: ", personalnummer == null ? "" : personalnummer);
            personalnummer = EingabeHelper.stringEingabe(personalnummerPrompt, personalnummer);

            var abteilungPrompt = PromptHelper.erstellInputPrompt("Abteilung des Mitarbeiters%s", abteilung == null ? "" : abteilung.getName());
            abteilung = EingabeHelper.menuEinzelEingabe(abteilungPrompt, abteilungService.findeAlle(), Abteilung::getName);

            if (abteilung != null)
                lastAbteilung = abteilung;

            if (abteilung == null && lastAbteilung != null)
                abteilung = lastAbteilung;

            neuerMitarbeiter = mitarbeiterService.erstelleMitarbeiter(name, vorname, personalnummer, abteilung);
            if (neuerMitarbeiter == null)
                EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
        } while (neuerMitarbeiter == null);
    }
}

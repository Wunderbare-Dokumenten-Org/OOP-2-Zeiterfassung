package org.iu.oop2ze.ui.cli.views.abteilung;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;

/**
 * Klasse, welche eine Abteilung bearbeitet
 *
 * @author Julius Beier, Nico Nimschofsky
 * @see CliComponent
 */
public class AbteilungBearbeitenView extends CliComponent {
    @LazyInject
    private IAbteilungService abteilungService;

    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @Setter
    private Abteilung ausgewaehlteAbteilung;

    @Override
    public void exec() {
        if (ausgewaehlteAbteilung == null)
            throw new IllegalStateException();

        Abteilung bearbeiteteAbteilung = null;

        String name = ausgewaehlteAbteilung.getName();
        Mitarbeiter leitenderMitarbeiter = ausgewaehlteAbteilung.getLeitenderMitarbeiter();
        Mitarbeiter lastLeitenderMitarbeiter = leitenderMitarbeiter;

        do {
            EingabeHelper.clearConsole();

            System.out.println("Abteilung - Bearbeiten");

            var namePrompt = PromptHelper.erstellInputPrompt("Name der Abteilung%s: ", name);
            name = EingabeHelper.stringEingabe(namePrompt, name);

            if (!ausgewaehlteAbteilung.getIsHr()) {
                leitenderMitarbeiter = AbteilungHelper.gibLeitenderMitarbeiter(leitenderMitarbeiter, lastLeitenderMitarbeiter, mitarbeiterService);

                if (leitenderMitarbeiter != null)
                    lastLeitenderMitarbeiter = leitenderMitarbeiter;
            }

            bearbeiteteAbteilung = abteilungService.bearbeiteAbteilung(ausgewaehlteAbteilung, name, leitenderMitarbeiter);
            if (bearbeiteteAbteilung == null)
                EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
        } while (bearbeiteteAbteilung == null);
        ausgewaehlteAbteilung = null;
    }
}

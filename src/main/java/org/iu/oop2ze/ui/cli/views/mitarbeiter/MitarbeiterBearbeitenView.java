package org.iu.oop2ze.ui.cli.views.mitarbeiter;

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
 * Klasse, welche einen Mitarbeiter bearbeiten lässt
 *
 * @author Julius Beier
 * @see CliComponent
 */
public class MitarbeiterBearbeitenView extends CliComponent {
    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @LazyInject
    private IAbteilungService abteilungService;

    @Setter
    private Mitarbeiter ausgewaehlterMitarbeiter;

    @Override
    public void exec() {
        if (ausgewaehlterMitarbeiter == null)
            throw new IllegalStateException();

        Mitarbeiter bearbeiteterMitarbeiter = null;

        String name = ausgewaehlterMitarbeiter.getName();
        String vorname = ausgewaehlterMitarbeiter.getVorname();
        Abteilung abteilung = ausgewaehlterMitarbeiter.getAbteilung();
        Abteilung letzteAbteilung = ausgewaehlterMitarbeiter.getAbteilung();

        do {
            EingabeHelper.clearConsole();

            System.out.println("Mitarbeiter - Bearbeiten");

            var namePrompt = PromptHelper.erstellInputPrompt("Name des Mitarbeiters%s: ", name);
            name = EingabeHelper.stringEingabe(namePrompt, name);

            var vornamePrompt = PromptHelper.erstellInputPrompt("Vorname des Mitarbeiters%s: ", vorname);
            vorname = EingabeHelper.stringEingabe(vornamePrompt, vorname);

            abteilung = MitarbeiterHelper.getAbteilung(abteilung, letzteAbteilung, abteilungService);

            if (abteilung != null)
                letzteAbteilung = abteilung;

            bearbeiteterMitarbeiter = mitarbeiterService.bearbeiteMitarbeiter(ausgewaehlterMitarbeiter, name, vorname, abteilung);
            if (bearbeiteterMitarbeiter == null)
                EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
        } while (bearbeiteterMitarbeiter == null);
        ausgewaehlterMitarbeiter = null;
    }
}

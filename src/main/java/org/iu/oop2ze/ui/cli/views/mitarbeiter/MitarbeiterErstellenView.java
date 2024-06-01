package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;

public class MitarbeiterErstellenView extends CliComponent {
    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @LazyInject
    private IAbteilungService abteilungService;

    @Override
    public void exec() {
        Mitarbeiter neuerMitarbeiter = null;

        do {
            EingabeHelper.clearConsole();

            System.out.println("Mitarbeiter - Erstellen");

            var name = EingabeHelper.stringEingabe("Name des Mitarbeiters: ", null);
            var vorname = EingabeHelper.stringEingabe("Vorname des Mitarbeiters: ", null);
            var personalnummer = EingabeHelper.stringEingabe("Personalnummer des Mitarbeiters: ", null);
            var abteilung = EingabeHelper.menuEinzelEingabe("Abteilung des Mitarbeiters", abteilungService.findeAlle(), Abteilung::getName);

            neuerMitarbeiter = mitarbeiterService.erstelleMitarbeiter(name, vorname, personalnummer, abteilung);
        } while (neuerMitarbeiter == null);
    }
}

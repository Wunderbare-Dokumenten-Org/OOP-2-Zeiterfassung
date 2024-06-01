package org.iu.oop2ze.ui.cli.views.abteilung;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;

import java.util.Arrays;

public class AbteilungErstellenView extends CliComponent {
    @LazyInject
    private IAbteilungService abteilungService;

    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @Override
    public void exec() {
        Abteilung neueAbteilung = null;

        do {
            EingabeHelper.clearConsole();

            System.out.println("Abteilung - Erstellen");

            var name = EingabeHelper.stringEingabe("Name des Mitarbeiters: ", null);

            var isHr = EingabeHelper.menuEinzelEingabe("Human Resource-fähig", Arrays.asList(true, false), null);

            var leitenderMitarbeiter = EingabeHelper.menuEinzelEingabe("Leitender Mitarbeiters", mitarbeiterService.findeAlleMitarbeiter(), (Mitarbeiter m) -> {
                return "%s, %s".formatted(m.getName(), m.getVorname());
            });

            neueAbteilung = abteilungService.erstelleAbteilung(name, isHr, leitenderMitarbeiter);
        } while (neueAbteilung == null);
        EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
    }
}

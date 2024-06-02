package org.iu.oop2ze.ui.cli.views.zeitstempel;

import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.services.interfaces.IZeitstempelService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;

import java.util.Arrays;

public class ZeitstempelErstellenView extends CliComponent {
    @LazyInject
    private IZeitstempelService zeitstempelService;

    @Override
    public void exec() {
        Antrag antrag = null;

        do {
            EingabeHelper.clearConsole();

            System.out.println("Zeitstempel - Erstellen");

            var result = EingabeHelper.menuEinzelEingabe("Wählen sie eine Option", Arrays.asList(AntragType.ARBEIT_BEGIN, AntragType.ARBEIT_ENDE), null);

            if (result != null) {
                if (result == AntragType.ARBEIT_BEGIN)
                    antrag = zeitstempelService.erstelleBeginZeitstempel(UserHelper.getAngemeldeterMitarbeiter());
                else
                    antrag = zeitstempelService.erstelleEndeZeitstempel(UserHelper.getAngemeldeterMitarbeiter());
                if (antrag == null)
                    EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
            }
        } while (antrag == null);
    }
}

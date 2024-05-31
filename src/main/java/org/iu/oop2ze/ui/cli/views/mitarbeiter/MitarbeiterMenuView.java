package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.menues.mitarbeiter.MitarbeiterMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class MitarbeiterMenuView extends CliComponent {
    @Lazy
    @Autowired
    private MitarbeiterAuflistenView mitarbeiterAuflistenView;

    private Boolean running = true;

    @Override
    public void exec() {
        do {
            var menu = MenuHelper.gibUserMenu(MitarbeiterMenu.ADMIN, MitarbeiterMenu.HR, MitarbeiterMenu.MITARBEITER);
            var result = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion aus", menu);

            switch (result) {
                case AUFLISTEN -> mitarbeiterAuflistenView.exec();
                case ERSTELLEN -> {
                }
                case ANZEIGEN, BEARBEITEN, LOESCHEN -> {

                }
                case ZURUECK -> running = false;
                case null -> running = false;
                default -> throw new IllegalStateException();
            }
        } while (running);

        running = true;
    }
}

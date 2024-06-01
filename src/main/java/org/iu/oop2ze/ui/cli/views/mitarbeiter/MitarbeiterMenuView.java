package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.menues.mitarbeiter.MitarbeiterMenu;

/**
 * Klasse, welche das Mitarbeitermenü anzeigt
 *
 * @author Julius Beier
 * @see CliComponent
 * @see org.iu.oop2ze.ui.cli.menues.mitarbeiter.MitarbeiterMenuOptions
 */
public class MitarbeiterMenuView extends CliComponent {
    @LazyInject
    private MitarbeiterAuflistenView mitarbeiterAuflistenView;

    @LazyInject
    private MitarbeiterErstellenView mitarbeiterView;

    @Override
    public void exec() {
        var running = true;
        do {
            var menu = MenuHelper.gibUserMenu(MitarbeiterMenu.ADMIN, MitarbeiterMenu.HR, MitarbeiterMenu.MITARBEITER);
            var result = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion aus", menu, null);

            switch (result) {
                case AUFLISTEN -> mitarbeiterAuflistenView.exec();
                case ERSTELLEN -> mitarbeiterView.exec();
                case ZURUECK -> running = false;
                case null -> running = false;
            }
        } while (running);
    }
}

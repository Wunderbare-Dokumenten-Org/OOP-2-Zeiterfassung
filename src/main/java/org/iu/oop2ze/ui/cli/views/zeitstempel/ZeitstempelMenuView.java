package org.iu.oop2ze.ui.cli.views.zeitstempel;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.menues.zeitstempel.ZeitstempelMenu;

/**
 * Klasse, welche ein Menü für Zeitstempelanträge anzeigt
 *
 * @author Leon Dieringer
 * @see CliComponent
 */
public class ZeitstempelMenuView extends CliComponent {
    @LazyInject
    private ZeitstempelAuflistenView auflistenView;

    @LazyInject
    private ZeitstempelErstellenView erstellenView;

    @LazyInject
    private ZeitstempelMenu menues;

    public void exec() {
        var running = true;

        do {
            var menu = MenuHelper.gibUserMenu(menues);
            var result = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion aus", menu, null);

            switch (result) {
                case AUFLISTEN -> {
                    auflistenView.setZeitspanne(false);
                    auflistenView.exec();
                }
                case AUFLISTEN_ZEITSPANNE -> {
                    auflistenView.setZeitspanne(true);
                    auflistenView.exec();
                }
                case ERSTELLEN -> erstellenView.exec();
                case ZURUECK -> running = false;
                case null -> running = false;
            }
        } while (running);
    }
}

package org.iu.oop2ze.ui.cli.views;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;
import org.iu.oop2ze.ui.cli.menues.home.HomeMenu;
import org.iu.oop2ze.ui.cli.views.abteilung.AbteilungMenuView;
import org.iu.oop2ze.ui.cli.views.mitarbeiter.MitarbeiterMenuView;

/**
 * Klasse, welche das Home Menü anzeigt
 *
 * @author Julius Beier
 * @see CliComponent
 */
public class HomeView extends CliComponent {
    @LazyInject
    private LoginView loginView;

    @LazyInject
    private MitarbeiterMenuView mitarbeiterMenuView;

    @LazyInject
    private AbteilungMenuView abteilungMenuView;

    @LazyInject
    private HomeMenu homeMenu;

    @Override
    public void exec() {
        var running = true;

        do {
            EingabeHelper.clearConsole();

            if (!UserHelper.isAngemeldet())
                loginView.exec();

            var menu = MenuHelper.gibUserMenu(homeMenu.getAdmin(), homeMenu.getHr(), homeMenu.getMitarbeiter());
            var result = EingabeHelper.menuEinzelEingabe("Willkommen beim Zeiterfassungssystem", menu, null);

            switch (result) {
                case ANTRAEGE, ARBEITSZEITEN -> {
                }
                case ABTEILUNGEN -> abteilungMenuView.exec();
                case MITARBEITER -> mitarbeiterMenuView.exec();
                case LOGOUT -> UserHelper.logout();
                case BEENDEN -> running = false;
                case null -> running = false;
            }
        } while (running);
    }
}

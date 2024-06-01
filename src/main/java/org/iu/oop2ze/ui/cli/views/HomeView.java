package org.iu.oop2ze.ui.cli.views;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;
import org.iu.oop2ze.ui.cli.menues.home.HomeMenu;
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

    @Override
    public void exec() {
        var running = true;

        do {
            EingabeHelper.clearConsole();

            if (!UserHelper.isAngemeldet())
                loginView.exec();

            var menu = MenuHelper.gibUserMenu(HomeMenu.ADMIN, HomeMenu.HR, HomeMenu.MITARBEITER);
            var result = EingabeHelper.menuEinzelEingabe("Willkommen beim Zeiterfassungssystem", menu, null);

            switch (result) {
                case ANTRAEGE, ARBEITSZEITEN, ABTEILUNGEN -> {
                }
                case MITARBEITER -> mitarbeiterMenuView.exec();
                case LOGOUT -> UserHelper.logout();
                case BEENDEN -> running = false;
                case null -> running = false;
            }
        } while (running);
    }
}

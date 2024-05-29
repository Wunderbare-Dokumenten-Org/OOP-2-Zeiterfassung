package org.iu.oop2ze.ui.cli.views;

import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;
import org.iu.oop2ze.ui.cli.menues.home.HomeMenu;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeView extends CliComponent {
    @Autowired
    private LoginView login;

    private Boolean running = true;

    @Override
    public void exec() {
        do {
            EingabeHelper.clearConsole();

            if (!UserHelper.isAngemeldet())
                login.exec();

            var menu = MenuHelper.gibUserMenu(HomeMenu.ADMIN, HomeMenu.HR, HomeMenu.MITARBEITER);
            var result = EingabeHelper.menuEinzelEingabe("Willkommen beim Zeiterfassungssystem", menu);

            switch (result) {
                case ANTRAEGE -> {
                }
                case ARBEITSZEITEN, MITARBEITER, ABTEILUNGEN -> {
                }
                case LOGOUT -> UserHelper.logout();
                case BEENDEN -> running = false;
                case null -> running = false;
                default -> throw new IllegalStateException();
            }
        } while (running);
    }
}

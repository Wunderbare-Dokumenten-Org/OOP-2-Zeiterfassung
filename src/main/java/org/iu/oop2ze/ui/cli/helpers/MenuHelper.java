package org.iu.oop2ze.ui.cli.helpers;

import org.iu.oop2ze.ui.cli.menues.home.HomeMenu;
import org.iu.oop2ze.ui.cli.menues.home.HomeMenuOptions;

import java.util.List;

public class MenuHelper {
    public static List<HomeMenuOptions> findeHomeMenu() {
        var user = UserHelper.getAngemeldeterMitarbeiter();
        var abteilung = user.getAbteilung();

        if (abteilung == null && user.getIsSysAdmin()) {
            return HomeMenu.ADMIN;
        } else if (abteilung != null) {
            if (abteilung.getIsHr()) {
                return HomeMenu.HR;
            } else {
                return HomeMenu.MITARBEITER;
            }
        }

        throw new IllegalStateException();
    }
}

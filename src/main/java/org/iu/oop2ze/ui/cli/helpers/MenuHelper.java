package org.iu.oop2ze.ui.cli.helpers;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MenuHelper {
    public static <T> List<T> gibUserMenu(
            @NotNull final List<T> adminMenu,
            @NotNull final List<T> hrMenu,
            @NotNull final List<T> mitarbeiterMenu
    ) {
        var user = UserHelper.getAngemeldeterMitarbeiter();
        var abteilung = user.getAbteilung();

        if (abteilung == null && user.getIsSysAdmin()) {
            return adminMenu;
        } else if (abteilung != null) {
            if (abteilung.getIsHr()) {
                return hrMenu;
            } else {
                return mitarbeiterMenu;
            }
        }

        throw new IllegalStateException();
    }
}

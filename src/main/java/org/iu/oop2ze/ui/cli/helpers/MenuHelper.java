package org.iu.oop2ze.ui.cli.helpers;

import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * Klasse, welche statische Hilfsfunktionen für Menüs bereitstellt
 *
 * @author Julius Beier
 */
public class MenuHelper {
    /**
     * Funktion, welche das, dem angemeldeten Mitarbeiter, entsprechende Menü zurückgibt
     *
     * @param adminMenu       Das Menü, welches ein Admin sieht
     * @param hrMenu          Das Menü, welches ein Hr Mitarbeiter sieht
     * @param mitarbeiterMenu Das Menü, welches ein Mitarbeiter sieht
     * @param <T>             Type, der Menüs
     * @return Das Menü, welches der angemeldete Mitarbeiter sieht
     * @author Julius Beier
     * @see org.iu.oop2ze.ui.cli.menues.home.HomeMenu
     * @see org.iu.oop2ze.ui.cli.menues.global.ActionMenu
     * @see org.iu.oop2ze.ui.cli.menues.mitarbeiter.MitarbeiterMenu
     */
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

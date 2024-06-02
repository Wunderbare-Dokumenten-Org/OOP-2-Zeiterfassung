package org.iu.oop2ze.ui.cli.helpers;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;
import org.iu.oop2ze.ui.cli.menues.abstracts.MenuViewMenuOptions;
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
     * @see org.iu.oop2ze.ui.cli.menues.mitarbeiter.MitarbeiterMenu
     */
    public static <T> List<T> gibUserMenu(
            @NotNull BaseMenu<T> menu
    ) {
        var user = UserHelper.getAngemeldeterMitarbeiter();
        var abteilung = user.getAbteilung();

        if (abteilung == null && user.getIsSysAdmin()) {
            return menu.getAdmin();
        } else if (abteilung != null) {
            if (abteilung.getIsHr()) {
                return menu.getHr();
            } else {
                return menu.getMitarbeiter();
            }
        }

        throw new IllegalStateException();
    }

    public static void runMenu(CliComponent auflistenView, CliComponent erstellenView, BaseMenu<MenuViewMenuOptions> menues) {
        var running = true;

        do {
            var menu = MenuHelper.gibUserMenu(menues);
            var result = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion aus", menu, null);

            switch (result) {
                case AUFLISTEN -> auflistenView.exec();
                case ERSTELLEN -> erstellenView.exec();
                case ZURUECK -> running = false;
                case null -> running = false;
            }
        } while (running);
    }
}

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
     * @param menu Die Menüklasse, welche die Menüoptionen für den Mitarbeiter beinhaltet
     * @param <T>  Type, der Menüs
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

    /**
     * Funktion, welche ein Menü, mit den MenuViewMenuOptions ausführt
     *
     * @param auflistenView Die View Instanz, welche die Auflist-Funktionalität beinhaltet
     * @param erstellenView Die View Instanz, welche die Erstell-Funktionalität beinhaltet
     * @param menues        Die Nutzer Menüoptionen
     * @author Julius Beier
     */
    public static void runMenu(CliComponent auflistenView, CliComponent erstellenView, BaseMenu<MenuViewMenuOptions> menues) {
        var running = true;

        do {
            var menu = MenuHelper.gibUserMenu(menues);
            var result = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion aus", menu, null);

            switch (result) {
                case AUFLISTEN -> auflistenView.exec();
                case AUFLISTEN_ZEITSPANNE -> {
                }
                case ERSTELLEN -> erstellenView.exec();
                case ZURUECK -> running = false;
                case null -> running = false;
            }
        } while (running);
    }

    public static String boolToHumanReadable(boolean bool) {
        return bool ? "Ja" : "Nein";
    }

}

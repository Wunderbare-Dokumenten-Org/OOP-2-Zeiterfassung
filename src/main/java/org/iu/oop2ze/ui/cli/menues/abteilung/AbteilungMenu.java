package org.iu.oop2ze.ui.cli.menues.abteilung;

import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;
import org.iu.oop2ze.ui.cli.menues.abstracts.MenuViewMenuOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Klasse, welche das Abteilungsmenü, der Nutzer beschreibt
 *
 * @author Julius Beier
 */
public class AbteilungMenu extends BaseMenu<MenuViewMenuOptions> {
    public AbteilungMenu() {
        this.admin = Arrays.asList(
                MenuViewMenuOptions.AUFLISTEN,
                MenuViewMenuOptions.ERSTELLEN,
                MenuViewMenuOptions.ZURUECK
        );

        this.hr = List.of(MenuViewMenuOptions.AUFLISTEN, MenuViewMenuOptions.ZURUECK);

        this.mitarbeiter = new ArrayList<>();
    }
}

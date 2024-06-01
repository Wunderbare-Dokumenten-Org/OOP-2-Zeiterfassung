package org.iu.oop2ze.ui.cli.menues.abteilung;

import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;
import org.iu.oop2ze.ui.cli.menues.abstracts.MenuViewMenuOptions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse, welche das Mitarbeitermenü, der Nutzer beschreibt
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

        this.hr = new ArrayList<>();

        this.mitarbeiter = new ArrayList<>();
    }
}

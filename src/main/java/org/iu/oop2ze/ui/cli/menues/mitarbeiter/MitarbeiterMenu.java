package org.iu.oop2ze.ui.cli.menues.mitarbeiter;

import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;
import org.iu.oop2ze.ui.cli.menues.abstracts.MenuViewMenuOptions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse, welche das Mitarbeitermenü, der Nutzer beschreibt
 *
 * @author Julius Beier
 */
public class MitarbeiterMenu extends BaseMenu<MenuViewMenuOptions> {
    public MitarbeiterMenu() {
        this.admin = Arrays.asList(
                MenuViewMenuOptions.AUFLISTEN,
                MenuViewMenuOptions.ERSTELLEN,
                MenuViewMenuOptions.ZURUECK
        );

        this.hr = Arrays.asList(
                MenuViewMenuOptions.AUFLISTEN,
                MenuViewMenuOptions.ERSTELLEN,
                MenuViewMenuOptions.ZURUECK
        );

        this.mitarbeiter = new ArrayList<>();
    }
}

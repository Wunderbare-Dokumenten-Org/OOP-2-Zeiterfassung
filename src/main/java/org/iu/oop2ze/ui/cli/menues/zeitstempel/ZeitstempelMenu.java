package org.iu.oop2ze.ui.cli.menues.zeitstempel;

import org.iu.oop2ze.ui.cli.menues.abstracts.AntragViewMenuOptions;
import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;
import org.iu.oop2ze.ui.cli.menues.abstracts.MenuViewMenuOptions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse, welche das Zeitstempel, der Nutzer beschreibt
 *
 * @author Leon Dieringer
 */

public class ZeitstempelMenu extends BaseMenu<MenuViewMenuOptions> {
    public ZeitstempelMenu() {
        this.mitarbeiter = Arrays.asList(
                MenuViewMenuOptions.AUFLISTEN,
                MenuViewMenuOptions.AUFLISTEN_ZEITSPANNE,
                MenuViewMenuOptions.ERSTELLEN,
                MenuViewMenuOptions.ZURUECK
        );
        this.hr = Arrays.asList(
                MenuViewMenuOptions.AUFLISTEN,
                MenuViewMenuOptions.AUFLISTEN_ZEITSPANNE,
                MenuViewMenuOptions.ZURUECK
        );
        this.admin = new ArrayList<>();
    }
}


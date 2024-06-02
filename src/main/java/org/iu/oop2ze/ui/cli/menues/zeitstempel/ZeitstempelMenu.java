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

public class ZeitstempelMenu extends BaseMenu<AntragViewMenuOptions> {
    public ZeitstempelMenu() {
        this.mitarbeiter = Arrays.asList(
                AntragViewMenuOptions.AUFLISTEN,
                AntragViewMenuOptions.AUFLISTEN_ZEITSPANNE,
                AntragViewMenuOptions.ERSTELLEN,
                AntragViewMenuOptions.ZURUECK
        );
        this.hr = Arrays.asList(
                AntragViewMenuOptions.AUFLISTEN,
                AntragViewMenuOptions.AUFLISTEN_ZEITSPANNE,
                AntragViewMenuOptions.ZURUECK
        );
        this.admin = new ArrayList<>();
    }
}


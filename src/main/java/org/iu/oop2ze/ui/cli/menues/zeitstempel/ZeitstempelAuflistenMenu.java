package org.iu.oop2ze.ui.cli.menues.zeitstempel;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.menues.abstracts.ActionMenuOptions;
import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse, welche einen Zeitstempel auswählen lässt
 * und Aktionen mit diesem ausführt
 *
 * @author Leon Dieringer
 * @see CliComponent
 */
public class ZeitstempelAuflistenMenu extends BaseMenu<ActionMenuOptions> {
    public ZeitstempelAuflistenMenu() {
        this.mitarbeiter = Arrays.asList(
                ActionMenuOptions.ANZEIGEN
        );
        this.hr = Arrays.asList(
                ActionMenuOptions.ANZEIGEN,
                ActionMenuOptions.BEARBEITEN
        );
        this.admin = new ArrayList<>();
    }
}

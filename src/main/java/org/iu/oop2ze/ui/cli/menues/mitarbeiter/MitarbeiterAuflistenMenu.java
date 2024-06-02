package org.iu.oop2ze.ui.cli.menues.mitarbeiter;

import org.iu.oop2ze.ui.cli.menues.abstracts.ActionMenuOptions;
import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse, welche die Menüs für die MitarbeiterAuflistenView definiert
 *
 * @author Julius Beier
 */
public class MitarbeiterAuflistenMenu extends BaseMenu<ActionMenuOptions> {
    public MitarbeiterAuflistenMenu() {
        this.admin = Arrays.asList(
                ActionMenuOptions.ANZEIGEN,
                ActionMenuOptions.BEARBEITEN,
                ActionMenuOptions.LOESCHEN
        );

        this.hr = Arrays.asList(
                ActionMenuOptions.ANZEIGEN,
                ActionMenuOptions.BEARBEITEN,
                ActionMenuOptions.LOESCHEN
        );

        this.mitarbeiter = new ArrayList<>();
    }
}

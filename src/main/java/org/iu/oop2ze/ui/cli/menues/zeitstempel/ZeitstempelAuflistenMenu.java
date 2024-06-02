package org.iu.oop2ze.ui.cli.menues.zeitstempel;

import org.iu.oop2ze.ui.cli.menues.abstracts.ActionMenuOptions;
import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeitstempelAuflistenMenu extends BaseMenu<ActionMenuOptions> {
    public ZeitstempelAuflistenMenu() {
        this.mitarbeiter = Arrays.asList(
                ActionMenuOptions.ANZEIGEN,
                ActionMenuOptions.BEARBEITEN,
                ActionMenuOptions.LOESCHEN
        );

        this.hr = Arrays.asList(
                ActionMenuOptions.ANZEIGEN,
                ActionMenuOptions.BEARBEITEN,
                ActionMenuOptions.LOESCHEN
        );

        this.admin = new ArrayList<>();
    }
}

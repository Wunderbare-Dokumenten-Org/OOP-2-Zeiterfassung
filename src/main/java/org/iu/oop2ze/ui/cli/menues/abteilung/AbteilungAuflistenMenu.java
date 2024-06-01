package org.iu.oop2ze.ui.cli.menues.abteilung;

import org.iu.oop2ze.ui.cli.menues.abstracts.ActionMenuOptions;
import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class AbteilungAuflistenMenu extends BaseMenu<ActionMenuOptions> {
    public AbteilungAuflistenMenu() {
        this.admin = Arrays.asList(
                ActionMenuOptions.ANZEIGEN,
                ActionMenuOptions.BEARBEITEN,
                ActionMenuOptions.LOESCHEN
        );

        this.hr = new ArrayList<>();

        this.mitarbeiter = new ArrayList<>();
    }
}

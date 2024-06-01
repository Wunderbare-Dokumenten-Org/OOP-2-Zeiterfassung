package org.iu.oop2ze.ui.cli.menues.global;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Klasse, welche die Aktionsmenüs, der Nutzer beschreibt
 *
 * @author Julius Beier
 * @see org.iu.oop2ze.ui.cli.views.mitarbeiter.MitarbeiterAuflistenView
 * @see ActionMenuOptions
 */
public class ActionMenu {
    public static final List<ActionMenuOptions> ADMIN = Arrays.asList(
            ActionMenuOptions.ANZEIGEN,
            ActionMenuOptions.BEARBEITEN,
            ActionMenuOptions.LOESCHEN
    );
    public static final List<ActionMenuOptions> HR = Arrays.asList(
            ActionMenuOptions.ANZEIGEN,
            ActionMenuOptions.BEARBEITEN,
            ActionMenuOptions.LOESCHEN
    );
    public static final List<ActionMenuOptions> MITARBEITER = new ArrayList<>();
}

package org.iu.oop2ze.ui.cli.menues.mitarbeiter;

import java.util.Arrays;
import java.util.List;

/**
 * Klasse, welche die MitarbeiterAuflistenView Menüs, der Nutzer beschreibt
 *
 * @author Julius Beier
 * @see org.iu.oop2ze.ui.cli.views.mitarbeiter.MitarbeiterAuflistenView
 * @see MitarbeiterMenuOptions
 */
public class MitarbeiterMenu {
    public static final List<MitarbeiterMenuOptions> ADMIN = Arrays.asList(
            MitarbeiterMenuOptions.AUFLISTEN,
            MitarbeiterMenuOptions.ERSTELLEN,
            MitarbeiterMenuOptions.ZURUECK
    );

    public static final List<MitarbeiterMenuOptions> HR = Arrays.asList(
            MitarbeiterMenuOptions.AUFLISTEN,
            MitarbeiterMenuOptions.ERSTELLEN,
            MitarbeiterMenuOptions.ZURUECK
    );

    public static final List<MitarbeiterMenuOptions> MITARBEITER = List.of();
}

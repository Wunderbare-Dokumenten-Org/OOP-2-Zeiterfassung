package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.menues.mitarbeiter.MitarbeiterMenu;

/**
 * Klasse, welche ein Menü für Mitarbeiter anzeigt
 *
 * @author Julius Beier
 * @see CliComponent
 */
public class MitarbeiterMenuView extends CliComponent {
    @LazyInject
    private MitarbeiterAuflistenView auflistenView;

    @LazyInject
    private MitarbeiterErstellenView erstellenView;

    @LazyInject
    private MitarbeiterMenu menues;

    public void exec() {
        MenuHelper.runMenu(auflistenView, erstellenView, menues);
    }
}

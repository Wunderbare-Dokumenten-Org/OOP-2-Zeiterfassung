package org.iu.oop2ze.ui.cli.views.abteilung;

import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.menues.abteilung.AbteilungMenu;

public class AbteilungMenuView extends CliComponent {
    @LazyInject
    private AbteilungAuflistenView auflistenView;

    @LazyInject
    private AbteilungErstellenView erstellenView;

    @LazyInject
    private AbteilungMenu menues;

    public void exec() {
        MenuHelper.runMenu(auflistenView, erstellenView, menues);
    }
}

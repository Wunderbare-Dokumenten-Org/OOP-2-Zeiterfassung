package org.iu.oop2ze.ui.cli.views.zeitstempel;

import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;
import org.iu.oop2ze.ui.cli.menues.abstracts.ActionMenuOptions;
import org.iu.oop2ze.ui.cli.menues.abstracts.AntragViewMenuOptions;
import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;
import org.iu.oop2ze.ui.cli.menues.mitarbeiter.MitarbeiterAuflistenMenu;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

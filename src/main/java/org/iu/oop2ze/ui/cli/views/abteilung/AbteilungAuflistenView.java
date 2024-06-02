package org.iu.oop2ze.ui.cli.views.abteilung;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.menues.abstracts.ActionMenuOptions;
import org.iu.oop2ze.ui.cli.menues.abteilung.AbteilungAuflistenMenu;

import java.util.List;

/**
 * Klasse, welche einen Mitarbeiter auswählen lässt
 * und Aktionen mit diesem Mitarbeiter ausführt
 *
 * @author Julius Beier
 * @see CliComponent
 * @see ActionMenuOptions
 */
public class AbteilungAuflistenView extends CliComponent {
    @LazyInject
    private IAbteilungService abteilungService;

    @LazyInject
    private AbteilungAnzeigenView abteilungAnzeigeView;

    @LazyInject
    private AbteilungBearbeitenView abteilungBearbeiteView;

    @LazyInject
    private AbteilungAuflistenMenu abteilungAuflistenMenu;

    @Override
    public void exec() {
        List<Abteilung> abteilungen = abteilungService.findeAlle();

        EingabeHelper.clearConsole();

        var ausgewaehlteAbteilung = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Abteilung aus", abteilungen, (Abteilung a) -> {
            return "%s".formatted(a.getName());
        });

        if (ausgewaehlteAbteilung != null) {
            var menu = MenuHelper.gibUserMenu(abteilungAuflistenMenu);

            var actionResult = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion", menu, null);

            if (actionResult == null)
                return;

            switch (actionResult) {
                case ANZEIGEN -> {
                    abteilungAnzeigeView.setAusgewaehlteAbteilung(ausgewaehlteAbteilung);
                    abteilungAnzeigeView.exec();
                }
                case BEARBEITEN -> {
                    abteilungBearbeiteView.setAusgewaehlteAbteilung(ausgewaehlteAbteilung);
                    abteilungBearbeiteView.exec();
                }
                case LOESCHEN -> abteilungService.loescheAbteilung(ausgewaehlteAbteilung);
            }
        }
    }
}

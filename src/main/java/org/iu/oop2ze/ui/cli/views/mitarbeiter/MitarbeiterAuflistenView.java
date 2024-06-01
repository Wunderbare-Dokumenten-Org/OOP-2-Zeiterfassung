package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;
import org.iu.oop2ze.ui.cli.menues.mitarbeiter.MitarbeiterAuflistenMenu;

import java.util.List;

/**
 * Klasse, welche einen Mitarbeiter auswählen lässt
 * und Aktionen mit diesem Mitarbeiter ausführt
 *
 * @author Julius Beier
 * @see CliComponent
 */
public class MitarbeiterAuflistenView extends CliComponent {
    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @LazyInject
    private MitarbeiterAnzeigenView mitarbeiterAnzeigeView;

    @LazyInject
    private MitarbeiterBearbeitenView mitarbeiterBearbeiteView;

    @LazyInject
    private MitarbeiterAuflistenMenu mitarbeiterAuflistenMenu;

    @Override
    public void exec() {
        List<Mitarbeiter> mitarbeiter;

        var user = UserHelper.getAngemeldeterMitarbeiter();

        if (user.getIsSysAdmin()) {
            mitarbeiter = mitarbeiterService.findeAlleMitarbeiter();
        } else if (user.getAbteilung().getIsHr()) {
            mitarbeiter = mitarbeiterService.findeAlleMitarbeiterFuerAbteilung(user.getAbteilung());
        } else {
            throw new IllegalStateException("Normale Mitarbeiter haben keinen Zugriff auf die Mitarbeiter Verwaltung");
        }

        var ausgewaehlterMitarbeiter = EingabeHelper.menuEinzelEingabe("Wählen Sie einen Mitarbeiter aus", mitarbeiter, (Mitarbeiter m) -> {
            return "%s, %s".formatted(m.getName(), m.getVorname());
        });

        if (ausgewaehlterMitarbeiter != null) {
            var menu = MenuHelper.gibUserMenu(mitarbeiterAuflistenMenu.getAdmin(),
                    mitarbeiterAuflistenMenu.getHr(), mitarbeiterAuflistenMenu.getMitarbeiter());
            var actionResult = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion", menu, null);

            if (actionResult == null)
                return;

            switch (actionResult) {
                case ANZEIGEN -> {
                    mitarbeiterAnzeigeView.setAusgewaehlterMitarbeiter(ausgewaehlterMitarbeiter);
                    mitarbeiterAnzeigeView.exec();
                }
                case BEARBEITEN -> {
                    mitarbeiterBearbeiteView.setAusgewaehlterMitarbeiter(ausgewaehlterMitarbeiter);
                    mitarbeiterBearbeiteView.exec();
                }
                case LOESCHEN -> mitarbeiterService.loescheMitarbeiter(ausgewaehlterMitarbeiter);
            }
        }
    }
}

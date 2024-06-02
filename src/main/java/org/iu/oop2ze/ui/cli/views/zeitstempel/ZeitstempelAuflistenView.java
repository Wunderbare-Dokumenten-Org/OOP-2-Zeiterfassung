package org.iu.oop2ze.ui.cli.views.zeitstempel;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.services.ZeitstempelService;
import org.iu.oop2ze.core.services.interfaces.IZeitstempelService;
import org.iu.oop2ze.ui.cli.views.zeitstempel.ZeitstempelAnzeigenView;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;

import java.util.Date;
import java.util.List;

/**
 * Klasse, welche einen Zeitstempel auswählen lässt
 * und Aktionen mit diesem Zeitstempel ausführt
 *
 * @author Leon Dieringer
 * @see CliComponent
 */
public class ZeitstempelAuflistenView extends CliComponent {
    @LazyInject
    private IZeitstempelService zeitstempelService;

    @LazyInject
    private ZeitstempelAnzeigenView zeitstempelAnzeigenView;

    @LazyInject
    private ZeitstempelBearbeitenView zeitstempelBearbeitenView;

    @LazyInject
    private ZeitstempelAuflistenMenu zeitstempelAuflistenMenu;

@Setter
private Boolean zeitspanne;

    @Override
    public void exec() {
        if (zeitspanne = null)
            throw new IllegalStateException();

        List<Antrag> zeitstempel;

        Date begin;
        Date end;

        if (zeitspanne) {

        }

        var user = UserHelper.getAngemeldeterMitarbeiter();

        if (user.getAbteilung().getIsHr()) {
            zeitstempel = zeitstempelService.findeAlleZeitstempel(user.getZeitstempel());
        } else {
            throw new IllegalStateException("Normale Mitarbeiter haben keinen Zugriff auf die Mitarbeiter Verwaltung");
        }

        var ausgewaehlterMitarbeiter = EingabeHelper.menuEinzelEingabe("Wählen Sie einen Mitarbeiter aus", mitarbeiter, (Mitarbeiter m) -> {
            return "%s, %s".formatted(m.getName(), m.getVorname());
        });

        if (ausgewaehlterMitarbeiter != null) {
            var menu = MenuHelper.gibUserMenu(mitarbeiterAuflistenMenu);
            var actionResult = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion", menu, null);

            if (actionResult == null)
                return;

            switch (actionResult) {
                case ANZEIGEN -> {
                    zeitstempelAnzeigeView.setAusgewaehlterZeitstempel(ausgewaehlterZeitstempel);
                    zeitstempelAnzeigeView.exec();
                }
                case BEARBEITEN -> {
                    zeitstempelBearbeiteView.setAusgewaehlterZeitstempel(ausgewaehlterZeitstempel);
                    zeitstempelBearbeiteView.exec();
                }
                case LOESCHEN -> ZeitstempelService.loescheZeitstempel(ausgewaehlterZeistempel);
            }
        }
    }
}

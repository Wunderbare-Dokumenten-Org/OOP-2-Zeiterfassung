package org.iu.oop2ze.ui.cli.views.zeitstempel;

import lombok.Getter;
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

@Setter
@Getter
public class ZeitstempelAuflistenView extends CliComponent {
    @LazyInject
    private IZeitstempelService zeitstempelService;

    @LazyInject
    private ZeitstempelAnzeigenView zeitstempelAnzeigeView;

    @LazyInject
    private ZeitstempelBearbeitenView zeitstempelBearbeitenView;

    @LazyInject
    private ZeitstempelAuflistenMenu zeitstempelAuflistenMenu;

@Setter
private Boolean zeitspanne;

    @Override
    public void exec() {
        if (zeitspanne == null)
            throw new IllegalStateException();

        List<Antrag> zeitstempel;

        Date begin;
        Date end;

        if (zeitspanne) {
            begin = EingabeHelper.dateEingabe("Beginn der Zeitspanne");
            end = EingabeHelper.dateEingabe("Ende der Zeitspanne");
        }

        var user = UserHelper.getAngemeldeterMitarbeiter();

        if (user.getAbteilung().getIsHr()) {
            if (zeitspanne)
                zeitstempel = zeitstempelService.findeAlleZeitstempelFuerBearbeiterZwischen(user, begin, end);
            else
                zeitstempel = zeitstempelService.findeAlleZeitstempelFuerBearbeiter(user);
        } else {
            if (zeitspanne)
            zeitstempel = zeitstempelService.findeAlleZeitstempelFuerStellerZwischen(user, begin, end);
        else
            zeitstempel = zeitstempelService.findeAlleZeitstempelFuerSteller(user);
        }

        var ausgewaehlterZeitstempel = EingabeHelper.menuEinzelEingabe("Wählen Sie einen Zeitstempelantrag aus", zeitstempel, (Antrag a) -> {
            return "%s, %s".formatted(a.getType(), a.getStellenderMitarbeiter().getName());
        });

        if (ausgewaehlterZeitstempel != null) {
            var menu = MenuHelper.gibUserMenu(zeitstempelAuflistenMenu);
            var actionResult = EingabeHelper.menuEinzelEingabe("Wählen Sie eine Aktion", menu, null);

            if (actionResult == null)
                return;

            switch (actionResult) {
                case ANZEIGEN -> {
                    zeitstempelAnzeigeView.setAusgewaehlterZeitstempel(ausgewaehlterZeitstempel);
                    zeitstempelAnzeigeView.exec();
                }
                case BEARBEITEN -> {
                    zeitstempelBearbeitenView.setAusgewaehlterZeitstempel(ausgewaehlterZeitstempel);
                    zeitstempelBearbeitenView.exec();
                }
            }
        }
    }
}

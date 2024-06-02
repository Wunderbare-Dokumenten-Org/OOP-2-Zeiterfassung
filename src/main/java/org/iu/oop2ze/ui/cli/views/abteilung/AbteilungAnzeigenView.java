package org.iu.oop2ze.ui.cli.views.abteilung;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;

/**
 * Klasse, welche Abteilungen Anzeigt
 *
 * @author Julius Beier, Nico Nimschofsky
 * @see CliComponent
 */
public class AbteilungAnzeigenView extends CliComponent {
    @Setter
    private Abteilung ausgewaehlteAbteilung;

    @Override
    public void exec() {
        if (ausgewaehlteAbteilung == null)
            throw new IllegalStateException();

        EingabeHelper.clearConsole();

        var leitenderMitarbeiter = ausgewaehlteAbteilung.getLeitenderMitarbeiter();
        var leitenderMitarbeiterString =
                "%s".formatted(leitenderMitarbeiter == null ? "Kein Leitender Mitarbeiter" :
                        "%s, %s".formatted(leitenderMitarbeiter.getName(), leitenderMitarbeiter.getVorname()));

        var abteilungAnzeige = new StringBuilder()
                .append("Abteilung - Anzeige\n")
                .append("\tName: %s\n".formatted(ausgewaehlteAbteilung.getName()))
                .append("\tIst HR: %s\n".formatted(MenuHelper.boolToHumanReadable(ausgewaehlteAbteilung.getIsHr())))
                .append("\tLeitender Mitarbeiter: %s\n".formatted(leitenderMitarbeiterString))
                .append("\tErstellt: %s\n".formatted(ausgewaehlteAbteilung.getErstellt()))
                .append("\tBearbeitet: %s\n".formatted(ausgewaehlteAbteilung.getBearbeitet()));

        System.out.println(abteilungAnzeige);
        ausgewaehlteAbteilung = null;
        EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
    }
}

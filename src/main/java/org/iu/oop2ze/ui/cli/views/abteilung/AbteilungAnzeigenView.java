package org.iu.oop2ze.ui.cli.views.abteilung;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;

public class AbteilungAnzeigenView extends CliComponent {
    @Setter
    private Abteilung ausgewaehlteAbteilung;

    @Override
    public void exec() {
        if (ausgewaehlteAbteilung == null)
            throw new IllegalStateException();

        EingabeHelper.clearConsole();

        var leitenderMitarbeiter = ausgewaehlteAbteilung.getLeitenderMitarbeiter();

        var abteilungAnzeige = new StringBuilder()
                .append("Abteilung - Anzeige\n")
                .append("\tName: %s\n".formatted(ausgewaehlteAbteilung.getName()))
                .append("\tIst HR: %s\n".formatted(ausgewaehlteAbteilung.getIsHr()))
                .append("\tLeitender Mitarbeiter: %s, %s\n".formatted(leitenderMitarbeiter.getName(), leitenderMitarbeiter.getVorname()))
                .append("\tErstellt: %s\n".formatted(ausgewaehlteAbteilung.getErstellt()))
                .append("\tBearbeitet: %s\n".formatted(ausgewaehlteAbteilung.getBearbeitet()));

        System.out.println(abteilungAnzeige);
        ausgewaehlteAbteilung = null;
        EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
    }
}

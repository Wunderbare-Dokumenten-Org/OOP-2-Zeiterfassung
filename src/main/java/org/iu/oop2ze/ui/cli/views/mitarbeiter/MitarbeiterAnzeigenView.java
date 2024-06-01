package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;

import java.util.Scanner;

public class MitarbeiterAnzeigenView extends CliComponent {
    @Setter
    private Mitarbeiter ausgewaehlterMitarbeiter;

    @Override
    public void exec() {
        if (ausgewaehlterMitarbeiter == null)
            throw new IllegalStateException();

        EingabeHelper.clearConsole();

        var mitarbeiterAnzeige = new StringBuilder()
                .append("Mitarbeiter - Anzeige\n")
                .append("\tName: %s, %s\n".formatted(ausgewaehlterMitarbeiter.getName(), ausgewaehlterMitarbeiter.getVorname()))
                .append("\tPersonalnummer: %s\n".formatted(ausgewaehlterMitarbeiter.getPersonalnummer()))
                .append("\tEmail: %s\n".formatted(ausgewaehlterMitarbeiter.getEmail()))
                .append("\tErstellt: %s\n".formatted(ausgewaehlterMitarbeiter.getErstellt()))
                .append("\tBearbeitet: %s\n".formatted(ausgewaehlterMitarbeiter.getBearbeitet()))
                .append("Zum verlassen der Ansicht: <ENTER>");

        System.out.println(mitarbeiterAnzeige);
        ausgewaehlterMitarbeiter = null;
        new Scanner(System.in).nextLine();
    }
}

package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;

/**
 * Klasse, welche einen Mitarbeiter in der Konsole ausgibt
 *
 * @author Julius Beier
 * @see CliComponent
 */
public class MitarbeiterAnzeigenView extends CliComponent {
    @Setter
    private Mitarbeiter ausgewaehlterMitarbeiter;

    @Override
    public void exec() {
        if (ausgewaehlterMitarbeiter == null)
            throw new IllegalStateException();

        EingabeHelper.clearConsole();

        var abteilung = ausgewaehlterMitarbeiter.getAbteilung();

        var mitarbeiterAnzeige = new StringBuilder()
                .append("Mitarbeiter - Anzeige\n")
                .append("\tName: %s, %s\n".formatted(ausgewaehlterMitarbeiter.getName(), ausgewaehlterMitarbeiter.getVorname()))
                .append("\tPersonalnummer: %s\n".formatted(ausgewaehlterMitarbeiter.getPersonalnummer()))
                .append("\tEmail: %s\n".formatted(ausgewaehlterMitarbeiter.getEmail()))
                .append("\tZugeordnete Abteilung: %s\n".formatted(abteilung == null ? "Nicht zugeordnet" : abteilung.getName()))
                .append("\tErstellt: %s\n".formatted(ausgewaehlterMitarbeiter.getErstellt()))
                .append("\tBearbeitet: %s\n".formatted(ausgewaehlterMitarbeiter.getBearbeitet()));

        System.out.println(mitarbeiterAnzeige);
        ausgewaehlterMitarbeiter = null;
        EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
    }
}

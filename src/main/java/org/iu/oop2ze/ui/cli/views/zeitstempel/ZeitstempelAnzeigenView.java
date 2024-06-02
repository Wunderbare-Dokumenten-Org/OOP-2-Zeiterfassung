package org.iu.oop2ze.ui.cli.views.zeitstempel;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;

/**
 * Klasse, welche einen Zeitstempel in der Konsole ausgibt
 *
 * @author Leon Dieringer
 * @see CliComponent
 */
public class ZeitstempelAnzeigenView extends CliComponent {
    @Setter
    private Antrag ausgewaehlterZeitstempelAntrag;

    @Override
    public void exec() {
        if (ausgewaehlterZeitstempelAntrag == null)
            throw new IllegalStateException();

        EingabeHelper.clearConsole();

        var zeitstempelAnzeige = new StringBuilder()
                .append("Antrag - Anzeige\n")
                .append("\tErstellt: %s\n".formatted(ausgewaehlterZeitstempelAntrag.getErstellt()))
                .append("\tBearbeitet: %s\n".formatted(ausgewaehlterZeitstempelAntrag.getBearbeitet()))
                .append("\tGenehmigt: %s\n".formatted(MenuHelper.boolToHumanReadable(ausgewaehlterZeitstempelAntrag.getGenehmigt())))
                .append("\tAntragsteller: %s\n".formatted(ausgewaehlterZeitstempelAntrag.getStellenderMitarbeiter().getName()))
                .append("\tAntragbearbeiter: %s\n".formatted(ausgewaehlterZeitstempelAntrag.getBearbeitenderMitarbeiter().getName()))
                .append("\tTyp: %s\n".formatted(ausgewaehlterZeitstempelAntrag.getType()));

        System.out.println(zeitstempelAnzeige);
        ausgewaehlterZeitstempelAntrag = null;
        EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
    }
}

package org.iu.oop2ze.ui.cli.views.zeitstempel;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;
import org.iu.oop2ze.core.services.interfaces.IZeitstempelService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.MenuHelper;

import java.util.Arrays;

/**
 * Klasse, welche einen Zeitstempel bearbeiten lässt
 *
 * @author Leon Dieringer
 * @see CliComponent
 */
public class ZeitstempelBearbeitenView extends CliComponent {
    @LazyInject
    private IZeitstempelService zeitstempelService;

    @Setter
    private Antrag ausgewaehlterZeitstempel;

    @Override
    public void exec() {
        if (ausgewaehlterZeitstempel == null)
            throw new IllegalStateException();

        Antrag bearbeiteterAntrag = null;

        StatusType status = null;
        Boolean genehmigt = null;

        do {
            EingabeHelper.clearConsole();

            System.out.println("Zeitstempel - Bearbeiten");

            var zeitstempelAnzeige = new StringBuilder()
                    .append("\tErstellt: %s\n".formatted(ausgewaehlterZeitstempel.getErstellt()))
                    .append("\tBearbeitet: %s\n".formatted(ausgewaehlterZeitstempel.getBearbeitet()))
                    .append("\tGenehmigt: %s\n".formatted(MenuHelper.boolToHumanReadable(ausgewaehlterZeitstempel.getGenehmigt())))
                    .append("\tAntragsteller: %s\n".formatted(ausgewaehlterZeitstempel.getStellenderMitarbeiter().getName()))
                    .append("\tAntragbearbeiter: %s\n".formatted(ausgewaehlterZeitstempel.getBearbeitenderMitarbeiter().getName()))
                    .append("\tTyp: %s\n".formatted(ausgewaehlterZeitstempel.getType()));

            System.out.println(zeitstempelAnzeige);

            status = EingabeHelper.menuEinzelEingabe("Wählen Sie einen Status aus", Arrays.asList(StatusType.AUSSTEHEND, StatusType.IN_BEARBEITUNG, StatusType.BEARBEITET), null);
            genehmigt = EingabeHelper.menuEinzelEingabe("Wollen sie diesen genehmigen?", Arrays.asList(true, false), MenuHelper::boolToHumanReadable);

            bearbeiteterAntrag = zeitstempelService.bearbeiteAntrag(ausgewaehlterZeitstempel, status, genehmigt);

            if (bearbeiteterAntrag == null)
                EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
        } while (bearbeiteterAntrag == null);
        ausgewaehlterZeitstempel = null;
    }
}

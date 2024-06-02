package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;

import java.util.Date;
import java.util.List;

/**
 * Interface, welches den ZeitstempelService beschreibt
 *
 * @author Julius Beier
 */
public interface IZeitstempelService {
    /**
     * Erstellt einen Zeitstempelantrag mit ARBEIT_BEGIN
     *
     * @param stellenderMitarbeiter    Der Mitarbeiter, welcher den Antrag stellt
     * @return Den erstellten Antrag
     * @author Julius Beier
     */
    Antrag erstelleBeginZeitstempel(final Mitarbeiter stellenderMitarbeiter);

    /**
     * Erstellt einen Zeitstempelantrag mit ARBEIT_ENDE
     *
     * @param stellenderMitarbeiter    Der Mitarbeiter, welcher den Antrag stellt
     * @return Den erstellten Antrag
     * @author Julius Beier
     */
    Antrag erstelleEndeZeitstempel(final Mitarbeiter stellenderMitarbeiter);

    /**
     * Bearbeitet einen Zeitstempelantrag
     *
     * @param antrag                   Der zu bearbeitende Antrag
     * @param status                   Der Status des Antrages
     * @param genehmigt                   Ob der Antrag genehmigt wurde
     * @return Den bearbeiteten Antrag
     * @author Julius Beier
     */
    Antrag bearbeiteAntrag(Antrag antrag, final StatusType status, final Boolean genehmigt);

    /**
     * Bearbeitet einen Zeitstempelantrag
     *
     * @return Den bearbeiteten Antrag
     * @author Julius Beier
     */
    List<Antrag> findeAlleZeitstempelFuerStellerZwischen(final Mitarbeiter steller, final Date begin, final Date end);

    List<Antrag> findeAlleZeitstempelFuerSteller(final Mitarbeiter steller);

    List<Antrag> findeAlleZeitstempelFuerBearbeiterZwischen(final Mitarbeiter bearbeiter, final Date begin, final Date end);

    List<Antrag> findeAlleZeitstempelFuerBearbeiter(final Mitarbeiter bearbeiter);
}

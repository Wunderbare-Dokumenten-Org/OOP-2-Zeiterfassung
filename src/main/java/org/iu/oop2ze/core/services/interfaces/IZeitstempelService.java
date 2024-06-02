package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
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
     * @param stellenderMitarbeiter Der Mitarbeiter, welcher den Antrag stellt
     * @return Den erstellten Antrag
     * @author Julius Beier
     */
    Antrag erstelleBeginZeitstempel(final Mitarbeiter stellenderMitarbeiter);

    /**
     * Erstellt einen Zeitstempelantrag mit ARBEIT_ENDE
     *
     * @param stellenderMitarbeiter Der Mitarbeiter, welcher den Antrag stellt
     * @return Den erstellten Antrag
     * @author Julius Beier
     */
    Antrag erstelleEndeZeitstempel(final Mitarbeiter stellenderMitarbeiter);

    /**
     * Bearbeitet einen Zeitstempelantrag
     *
     * @param antrag    Der zu bearbeitende Antrag
     * @param status    Der Status des Antrages
     * @param genehmigt Ob der Antrag genehmigt wurde
     * @return Den bearbeiteten Antrag
     * @author Julius Beier
     */
    Antrag bearbeiteAntrag(Antrag antrag, final StatusType status, final Boolean genehmigt);

    /**
     * Findet alle Zeitstempel für einen Steller, in einem Zeitraum
     *
     * @param steller Mitarbeiter, welcher den Zeitstempelantrag gestellt hat
     * @param begin   Anfang, des Zeitraumes
     * @param end     Ende, des Zeitraumes
     * @return Zeitstempelanträge in einem Zeitraum
     * @author Julius Beier
     */
    List<Antrag> findeAlleZeitstempelFuerStellerZwischen(final Mitarbeiter steller, final Date begin, final Date end);

    /**
     * Findet alle Zeitstempel für einen Steller
     *
     * @param steller Mitarbeiter, welcher die Anträge gestellt hat
     * @return Alle bisher gestellten Zeitstempelanträge
     * @author Julius Beier
     */
    List<Antrag> findeAlleZeitstempelFuerSteller(final Mitarbeiter steller);

    /**
     * Findet alle Zeitstempel für einen Bearbeiter, in einem Zeitraum
     *
     * @param bearbeiter Mitarbeiter, welcher den Zeitstempelantrag bearbeitet
     * @param begin      Anfang, des Zeitraumes
     * @param end        Ende, des Zeitraumes
     * @return Zeitstempelanträge in einem Zeitraum
     * @author Julius Beier
     */
    List<Antrag> findeAlleZeitstempelFuerBearbeiterZwischen(final Mitarbeiter bearbeiter, final Date begin, final Date end);

    /**
     * Findet alle Zeitstempel für einen Bearbeiter
     *
     * @param bearbeiter Mitarbeiter, welcher die Anträge bearbeitet
     * @return Alle bisher zu bearbeitende Zeitstempelanträge
     * @author Julius Beier
     */
    List<Antrag> findeAlleZeitstempelFuerBearbeiter(final Mitarbeiter bearbeiter);
}

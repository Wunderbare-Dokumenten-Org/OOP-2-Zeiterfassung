package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;

import java.util.Date;

/**
 * Interface, welches den AntragService beschreibt
 *
 * @author Julius Beier
 */
public interface IAntragService {
    /**
     * Erstellt einen Antrag
     *
     * @param stellenderMitarbeiter    Der Mitarbeiter, welcher den Antrag stellt
     * @param type                     Der Type des Antrags
     * @param datum                    Das Datum, für wann der Antrag gedacht ist
     * @param titel                    Der Titel des Antrages
     * @param status                   Der Status des Antrages
     * @param kommentar                Der Kommentar des Antrages
     * @param bearbeitenderMitarbeiter Der Mitarbeiter, welcher den Antrag bearbeitet
     * @return Den erstellten Antrag
     * @author Julius Beier, Leon Dieringer
     */
    Antrag erstelleAntrag(final Mitarbeiter stellenderMitarbeiter, final AntragType type, final Date datum, final String titel, final StatusType status, final String kommentar, final Mitarbeiter bearbeitenderMitarbeiter);

    /**
     * Bearbeitet einen Antrag
     *
     * @param antrag                   Der zu bearbeitende Antrag
     * @param type                     Der Type des Antrags
     * @param datum                    Das Datum, für wann der Antrag gedacht ist
     * @param status                   Der Status des Antrages
     * @param kommentar                Der Kommentar des Antrages
     * @param bearbeitenderMitarbeiter Der Mitarbeiter, welcher den Antrag bearbeitet
     * @return Den bearbeiteten Antrag
     * @author Julius Beier, Leon Dieringer
     */
    Antrag bearbeiteAntrag(Antrag antrag, final AntragType type, final Date datum, final StatusType status, final String kommentar, final Mitarbeiter bearbeitenderMitarbeiter);

    /**
     * Löscht einen Antrag
     *
     * @param antrag Der zu löschende Antrag
     * @author Julius Beier
     */
    void loescheAntrag(final Antrag antrag);
}

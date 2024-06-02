package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;

import java.util.List;

/**
 * Interface, welches den AbteilungService beschreibt
 *
 * @author Julius Beier
 */
public interface IAbteilungService {
    /**
     * Erstellt eine neue Abteilung
     *
     * @param name                 Name der Abteilung
     * @param isHr                 Ob die Abteilung HR Funktionalität zur Verfügung hat
     * @param leitenderMitarbeiter Leitender Mitarbeiter der Abteilung
     * @return Die neu erstellte Abteilung
     * @author Julius Beier
     */
    Abteilung erstelleAbteilung(final String name, final Boolean isHr, final Mitarbeiter leitenderMitarbeiter);

    /**
     * Bearbeitet eine Abteilung
     *
     * @param abteilung            Instanz der zu bearbeitenden Abteilung
     * @param name                 Name der Abteilung
     * @param leitenderMitarbeiter Leitender Mitarbeiter der Abteilung
     * @return Die bearbeitete Abteilung
     * @author Julius Beier
     */
    Abteilung bearbeiteAbteilung(Abteilung abteilung, final String name, final Mitarbeiter leitenderMitarbeiter);

    /**
     * Löscht eine Abteilung
     *
     * @param abteilung Instanz der zu löschenden Abteilung
     * @author Julius Beier
     */
    void loescheAbteilung(final Abteilung abteilung);

    /**
     * Gibt alle vorhanden Abteilungen zurück
     *
     * @return Liste aller vorhanden Abteilungen
     * @author Julius Beier, Nico
     */
    List<Abteilung> findeAlle();
}

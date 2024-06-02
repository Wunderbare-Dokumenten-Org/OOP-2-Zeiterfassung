package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;

import java.util.List;

/**
 * Interface, welches den MitarbeiterService beschreibt
 *
 * @author Julius Beier
 */
public interface IMitarbeiterService {
    /**
     * Erstellt einen Mitarbeiter (Passwort wird beim ersten Login des Mitarbeiters gesetzt)
     *
     * @param name           Name des Mitarbeiters
     * @param vorname        Vorname des Mitarbeiters
     * @param personalnummer Personalnummer des Mitarbeiters
     * @param abteilung      Abteilung, welcher der Mitarbeiter zugeordnet wird
     * @return Neu erstellten Mitarbeiter
     * @author Julius Beier
     */
    Mitarbeiter erstelleMitarbeiter(final String name, final String vorname, final String personalnummer, final Abteilung abteilung);

    /**
     * Bearbeitet einen Mitarbeiter
     *
     * @param mitarbeiter Der Mitarbeiter, der bearbeitet wird
     * @param name        Name des Mitarbeiters
     * @param vorname     Vorname des Mitarbeiters
     * @param abteilung   Abteilung, welcher der Mitarbeiter zugeordnet wird
     * @return bearbeiteten Mitarbeiter
     * @author Julius Beier
     */
    Mitarbeiter bearbeiteMitarbeiter(Mitarbeiter mitarbeiter, final String name, final String vorname, final Abteilung abteilung);

    /**
     * Löscht einen Mitarbeiter
     *
     * @param mitarbeiter Mitarbeiter der gelöscht wird
     * @author Julius Beier
     */
    void loescheMitarbeiter(final Mitarbeiter mitarbeiter);

    /**
     * Gibt den Mitarbeiter zurück, welcher versucht sich anzumelden
     * und setzt, das Passwort, wenn noch nicht Vorhanden
     *
     * @param email    E-Mail, des Mitarbeiters
     * @param passwort Passwort, des Mitarbeiters, welches gesetzt wird, falls nicht Vorhanden
     * @return Den Mitarbeiter
     * @author Julius Beier
     */
    Mitarbeiter findeMitarbeiterMitLogin(final String email, final String passwort);

    /**
     * Gibt alle vorhanden Mitarbeiter zurück, bis auf den Systemadministrator
     *
     * @return alle vorhandenen Mitarbeiter
     * @author Julius Beier
     */
    List<Mitarbeiter> findeAlleMitarbeiter();

    /**
     * Gibt alle vorhanden Mitarbeiter, einer Abteilung zurück
     *
     * @param abteilung Die Abteilung, welche die Mitarbeiter angehören
     * @return alle vorhandenen Mitarbeiter, einer Abteilung
     * @author Julius Beier
     */
    List<Mitarbeiter> findeAlleMitarbeiterFuerAbteilung(final Abteilung abteilung);
}

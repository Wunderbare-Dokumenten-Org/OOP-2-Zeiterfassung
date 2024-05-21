package org.iu.oop2ze.core.services;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.AbteilungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Klasse, welche Funktionen und Methoden für Abteilungen beinhaltet
 *
 * @author Julius Beier
 */
@Service
@Slf4j
public class AbteilungService {
    @Autowired
    AbteilungRepository abteilungRepository;

    /**
     * Erstellt eine neue Abteilung
     *
     * @param name Name der Abteilung
     * @param leitenderMitarbeiter Leitender Mitarbeiter der Abteilung
     * @return Die neu erstellte Abteilung
     * @author Julius Beier
     */
    public Abteilung erstelleAbteilung(final String name, final Mitarbeiter leitenderMitarbeiter) {
        if (name.isBlank() || leitenderMitarbeiter == null) {
            throw new IllegalArgumentException();
        }

        if (abteilungRepository.findByName(name) != null) {
            log.error("Abteilung mit dem Namen: '%s' existiert bereits".formatted(name));
            return null;
        }

        var abteilung = new Abteilung(name, leitenderMitarbeiter);

        abteilungRepository.save(abteilung);
        return abteilung;
    }

    /**
     * Findet Abteilungen mit dem übergebenen Namen
     *
     * @param name Name der Abteilung nach welcher gesucht wird
     * @return Die gesuchte Abteilung
     * @author Julius Beier
     */
    public Abteilung findeAbteilungNachName(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }

        var abteilung = abteilungRepository.findByName(name);

        if (abteilung == null) {
            log.error("Abteilung mit dem Namen: '%s' konnte nicht gefunden werden".formatted(name));
            return null;
        }

        return abteilung;
    }
}

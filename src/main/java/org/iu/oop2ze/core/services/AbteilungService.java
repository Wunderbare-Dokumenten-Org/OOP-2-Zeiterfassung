package org.iu.oop2ze.core.services;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.AbteilungRepository;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
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
public class AbteilungService implements IAbteilungService {
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
    public Abteilung erstelleAbteilung(final String name, final Boolean isHr, final Mitarbeiter leitenderMitarbeiter) {
        if (name.isBlank() || leitenderMitarbeiter == null || isHr == null) {
            throw new IllegalArgumentException();
        }

        if (abteilungRepository.findByName(name) != null) {
            log.error("Abteilung mit dem Namen: '%s' existiert bereits".formatted(name));
            return null;
        }

        var abteilung = new Abteilung(name, isHr, leitenderMitarbeiter);

        abteilungRepository.save(abteilung);
        return abteilung;
    }

    /**
     * Bearbeitet eine Abteilung
     *
     * @param abteilung Instanz der zubearbeitenden Abteilung
     * @param name Name der Abteilung
     * @param leitenderMitarbeiter Leitender Mitarbeiter der Abteilung
     * @return Die neu erstellte Abteilung
     * @author Julius Beier
     */
    public Abteilung bearbeiteAbteilung(
            Abteilung abteilung,
            final String name,
            final Mitarbeiter leitenderMitarbeiter
    ) {
        if (abteilung == null) {
            throw new IllegalArgumentException();
        }

        if (!name.isBlank())
            abteilung.setName(name);

        if (leitenderMitarbeiter != null)
            abteilung.setLeitenderMitarbeiter(leitenderMitarbeiter);

        abteilungRepository.save(abteilung);
        return abteilung;
    }

    public void loescheAbteilung(final Abteilung abteilung) {
        if (abteilung == null) {
            throw new IllegalArgumentException();
        }

        abteilungRepository.delete(abteilung);
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

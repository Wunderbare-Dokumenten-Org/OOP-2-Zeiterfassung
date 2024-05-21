package org.iu.oop2ze.core.services;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.MitarbeiterRepository;
import org.iu.oop2ze.core.helpers.EnviromentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Klasse, welche Funktionen und Methoden für Mitarbeiter beinhaltet
 *
 * @author Julius Beier
 */
@Service
@Slf4j
public class MitarbeiterService {
    @Autowired
    private MitarbeiterRepository mitarbeiterRepository;

    /**
     * Erstellt einen Mitarbeiter
     *
     * @param name Name des Mitarbeiters
     * @param vorname Vorname des Mitarbeiters
     * @param personalnummer Personalnummer des Mitarbeiters
     * @param abteilung Abteilung, welcher der Mitarbeiter zugeordnet wird
     * @return Neu erstellten Mitarbeiter
     * @author Julius Beier
     */
    public Mitarbeiter erstelleMitarbeiter(
            final String name,
            final String vorname,
            final String personalnummer,
            final Abteilung abteilung) {
        if (name.isBlank() || vorname.isBlank() || personalnummer.isBlank() || abteilung == null) {
            throw new IllegalArgumentException();
        }

        if (mitarbeiterRepository.findByPersonalnummer(personalnummer) != null) {
            log.error("Mitarbeiter mit der Personalnummer: '%s' existiert bereits".formatted(personalnummer));
            return null;
        }

        var email = "%s.%s@%s.de".formatted(vorname, name, EnviromentHelper.gibFirma());

        var mitarbeiter = new Mitarbeiter(name, vorname, personalnummer, false, abteilung, email, "");

        mitarbeiterRepository.save(mitarbeiter);
        return mitarbeiter;
    }
}

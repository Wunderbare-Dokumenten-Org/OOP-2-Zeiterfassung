package org.iu.oop2ze.core.services;

import lombok.extern.slf4j.Slf4j;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.AbteilungRepository;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, welche Funktionen und Methoden für Abteilungen beinhaltet
 *
 * @author Julius Beier
 */
@Service
@Slf4j
public class AbteilungService implements IAbteilungService {
    @Autowired
    private AbteilungRepository abteilungRepository;

    @Override
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

    @Override
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

    @Override
    public void loescheAbteilung(final Abteilung abteilung) {
        if (abteilung == null) {
            throw new IllegalArgumentException();
        }

        abteilungRepository.delete(abteilung);
    }

    @Override
    public List<Abteilung> findeAlle() {
        var abteilungen = new ArrayList<Abteilung>();
        abteilungRepository.findAll().forEach(abteilungen::add);
        return abteilungen;
    }
}

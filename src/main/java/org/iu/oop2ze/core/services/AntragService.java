package org.iu.oop2ze.core.services;

import lombok.extern.slf4j.Slf4j;
import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.database.repositories.AntragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Klasse, welche Funktionen und Methoden für Anträge beinhaltet
 *
 * @author Julius Beier
 */
@Service
@Slf4j
public class AntragService {
    @Autowired
    private AntragRepository antragRepository;

    /**
     * Erstellt einen Antrag
     *
     * @param stellenderMitarbeiter Der Mitarbeiter, welcher den Antrag stellt
     * @param type Der Type des Antrags
     * @param datum Das Datum, für wann der Antrag gedacht ist
     * @return Den erstellten Antrag
     * @author Julius Beier
     */
    public Antrag erstelleAntrag(
            final Mitarbeiter stellenderMitarbeiter,
            final AntragType type,
            final Date datum
    ) {
        if (stellenderMitarbeiter == null || type == null || datum == null) {
            throw new IllegalArgumentException();
        }

        var antrag = new Antrag(stellenderMitarbeiter, type, datum);

        antragRepository.save(antrag);
        return antrag;
    }
};

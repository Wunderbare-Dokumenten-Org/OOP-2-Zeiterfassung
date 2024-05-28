package org.iu.oop2ze.core.services;

import lombok.extern.slf4j.Slf4j;
import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.database.repositories.AntragRepository;
import org.iu.oop2ze.core.services.interfaces.IAntragService;
import org.jetbrains.annotations.NotNull;
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
public class AntragService implements IAntragService {
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
    @Override
    public Antrag erstelleAntrag(
            @NotNull final Mitarbeiter stellenderMitarbeiter,
            @NotNull final AntragType type,
            @NotNull final Date datum
    ) {
        var antrag = new Antrag(stellenderMitarbeiter, type, datum);

        antragRepository.save(antrag);
        return antrag;
    }

    /**
     * Bearbeitet einen Antrag
     *
     * @param antrag Der zu bearbeitende Antrag
     * @param type Der Type des Antrags
     * @param datum Das Datum des Antrags
     * @return Den bearbeiteten Antrag
     * @author Julius Beier
     */
    @Override
    public Antrag bearbeiteAntrag(@NotNull Antrag antrag, final AntragType type, final Date datum) {
        if (type != null)
            antrag.setType(type);

        if (datum != null)
            antrag.setDatum(datum);

        antragRepository.save(antrag);
        return antrag;
    }

    /**
     * Löscht einen Antrag
     *
     * @param antrag Der zu löschende Antrag
     * @author Julius Beier
     */
    @Override
    public void loescheAntrag(@NotNull final Antrag antrag) {
        antragRepository.delete(antrag);
    }


};
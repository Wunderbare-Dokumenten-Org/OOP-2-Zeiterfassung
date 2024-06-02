package org.iu.oop2ze.core.services;

import lombok.extern.slf4j.Slf4j;
import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;
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

    @Override
    public Antrag erstelleAntrag(
            @NotNull final Mitarbeiter stellenderMitarbeiter,
            @NotNull final AntragType type,
            @NotNull final Date datum,
            @NotNull final String titel,
            @NotNull final StatusType status,
            final String kommentar,
            @NotNull final Mitarbeiter bearbeitenderMitarbeiter
    ) {
        var antrag = new Antrag(stellenderMitarbeiter, type, datum, titel, status, kommentar, false, bearbeitenderMitarbeiter);

        antragRepository.save(antrag);
        return antrag;
    }

    @Override
    public Antrag bearbeiteAntrag(
            @NotNull Antrag antrag,
            final AntragType type,
            final Date datum,
            final StatusType status,
            final String kommentar,
            final Mitarbeiter bearbeitenderMitarbeiter
    ) {
        if (type != null)
            antrag.setType(type);

        if (datum != null)
            antrag.setDatum(datum);

        if (status != null)
            antrag.setStatus(status);

        if (kommentar != null)
            antrag.setKommentar(kommentar);

        if (bearbeitenderMitarbeiter != null)
            antrag.setBearbeitenderMitarbeiter(bearbeitenderMitarbeiter);

        antragRepository.save(antrag);
        return antrag;
    }

    @Override
    public void loescheAntrag(@NotNull final Antrag antrag) {
        antragRepository.delete(antrag);
    }
}

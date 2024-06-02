package org.iu.oop2ze.core.services;

import lombok.extern.slf4j.Slf4j;
import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;
import org.iu.oop2ze.core.database.repositories.AntragRepository;
import org.iu.oop2ze.core.services.interfaces.IZeitstempelService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Klasse, welche Funktionen und Methoden für Anträge beinhaltet
 *
 * @author Julius Beier
 */
@Service
@Slf4j
public class ZeitstempelService implements IZeitstempelService {
    @Autowired
    private AntragRepository antragRepository;

    private Antrag erstelleZeitstempel(@NotNull final Mitarbeiter stellenderMitarbeiter, AntragType type) {
        var letzterAntrag = antragRepository.findFirstByStellenderMitarbeiterAndTypeOrderByErstelltDesc(stellenderMitarbeiter, type);
        if (letzterAntrag != null && (letzterAntrag.getType() == type)) {
            log.error("Sie können kein %s Stempeln, wenn Sie ihre letzte Arbeitszeit, noch nicht %s haben"
                    .formatted("BEGIN", "ENDE"));
            return null;
        }

        var bearbeiter = stellenderMitarbeiter.getAbteilung().getLeitenderMitarbeiter();

        var zeitstempel = new Antrag(stellenderMitarbeiter, type,
                new Date(), "Arbeitszeit Beginn", StatusType.AUSSTEHEND, null, false, bearbeiter);

        antragRepository.save(zeitstempel);
        return zeitstempel;
    }

    @Override
    public Antrag erstelleBeginZeitstempel(@NotNull final Mitarbeiter stellenderMitarbeiter) {
        return erstelleZeitstempel(stellenderMitarbeiter, AntragType.ARBEIT_BEGIN);
    }

    @Override
    public Antrag erstelleEndeZeitstempel(Mitarbeiter stellenderMitarbeiter) {
        return erstelleZeitstempel(stellenderMitarbeiter, AntragType.ARBEIT_ENDE);
    }

    @Override
    public Antrag bearbeiteAntrag(@NotNull Antrag antrag, final StatusType status, final Boolean genehmigt) {
        if (status != null)
            antrag.setStatus(status);

        if (genehmigt != null)
            antrag.setGenehmigt(genehmigt);

        antragRepository.save(antrag);
        return antrag;
    }

    private List<Antrag> filterAntragZwischen(@NotNull List<Antrag> antraege, @NotNull final Date begin, @NotNull final Date end) {
        if (antraege.isEmpty())
            return antraege;

        antraege
                .stream()
                .filter(antrag ->
                        antrag.getErstellt().compareTo(end) > 0 || antrag.getErstellt().compareTo(begin) < 0)
                .forEach(antraege::remove);

        return antraege;
    }

    @Override
    public List<Antrag> findeAlleZeitstempelFuerStellerZwischen(@NotNull final Mitarbeiter steller, @NotNull final Date begin, @NotNull final Date end) {
        var antraege = findeAlleZeitstempelFuerSteller(steller);
        return filterAntragZwischen(antraege, begin, end);
    }

    @Override
    public List<Antrag> findeAlleZeitstempelFuerSteller(@NotNull final Mitarbeiter steller) {
        var antraege = new ArrayList<Antrag>();
        antraege.addAll(antragRepository.findByStellenderMitarbeiterAndType(steller, AntragType.ARBEIT_BEGIN));
        antraege.addAll(antragRepository.findByStellenderMitarbeiterAndType(steller, AntragType.ARBEIT_ENDE));
        return antraege;
    }

    @Override
    public List<Antrag> findeAlleZeitstempelFuerBearbeiterZwischen(@NotNull final Mitarbeiter bearbeiter, @NotNull final Date begin, @NotNull final Date end) {
        var antraege = findeAlleZeitstempelFuerBearbeiter(bearbeiter);
        return filterAntragZwischen(antraege, begin, end);
    }

    @Override
    public List<Antrag> findeAlleZeitstempelFuerBearbeiter(@NotNull final Mitarbeiter bearbeiter) {
        var antraege = new ArrayList<Antrag>();
        antraege.addAll(antragRepository.findByBearbeitenderMitarbeiterAndType(bearbeiter, AntragType.ARBEIT_BEGIN));
        antraege.addAll(antragRepository.findByBearbeitenderMitarbeiterAndType(bearbeiter, AntragType.ARBEIT_ENDE));
        return antraege;
    }
}

package org.iu.oop2ze.core.services;

import lombok.extern.slf4j.Slf4j;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.MitarbeiterRepository;
import org.iu.oop2ze.core.helpers.EnviromentHelper;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, welche Funktionen und Methoden für Mitarbeiter beinhaltet
 *
 * @author Julius Beier
 */
@Service
@Slf4j
public class MitarbeiterService implements IMitarbeiterService {
    @Autowired
    private MitarbeiterRepository mitarbeiterRepository;

    /**
     * Erstellt einen Mitarbeiter (Passwort wird beim ersten Login des Mitarbeiters durch Ihn gestetzt)
     *
     * @param name           Name des Mitarbeiters
     * @param vorname        Vorname des Mitarbeiters
     * @param personalnummer Personalnummer des Mitarbeiters
     * @param abteilung      Abteilung, welcher der Mitarbeiter zugeordnet wird
     * @return Neu erstellten Mitarbeiter
     * @author Julius Beier
     */
    public Mitarbeiter erstelleMitarbeiter(
            @NotNull final String name,
            @NotNull final String vorname,
            @NotNull final String personalnummer,
            @NotNull final Abteilung abteilung
    ) {
        if (name.isBlank() || vorname.isBlank() || personalnummer.isBlank()) {
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

    @Override
    public Mitarbeiter bearbeiteMitarbeiter(
            @NotNull Mitarbeiter mitarbeiter,
            @NotNull final String name,
            @NotNull final String vorname,
            final Abteilung abteilung
    ) {
        if (!name.isBlank())
            mitarbeiter.setName(name);

        if (!vorname.isBlank())
            mitarbeiter.setVorname(vorname);

        if (abteilung != null)
            mitarbeiter.setAbteilung(abteilung);

        mitarbeiterRepository.save(mitarbeiter);
        return mitarbeiter;
    }

    @Override
    public void loescheMitarbeiter(@NotNull final Mitarbeiter mitarbeiter) {
        mitarbeiterRepository.delete(mitarbeiter);
    }

    @Override
    public Mitarbeiter findeMitarbeiterMitLogin(@NotNull final String email, @NotNull final String passwort) {
        return mitarbeiterRepository.findByEmailAndPasswort(email, passwort);
    }

    public List<Mitarbeiter> findeAlleMitarbeiter() {
        List<Mitarbeiter> mitarbeiter = new ArrayList<>();

        for (Mitarbeiter m : mitarbeiterRepository.findAll()) {
            if (!m.getIsSysAdmin())
                mitarbeiter.add(m);
        }

        mitarbeiterRepository.findAll().forEach(mitarbeiter::add);

        return mitarbeiter;
    }

    public List<Mitarbeiter> findeAlleMitarbeiterFuerAbteilung(@NotNull final Abteilung abteilung) {
        return new ArrayList<>(mitarbeiterRepository.findAllByAbteilung(abteilung));
    }
}

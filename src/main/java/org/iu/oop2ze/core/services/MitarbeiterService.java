package org.iu.oop2ze.core.services;

import lombok.extern.slf4j.Slf4j;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.AbteilungRepository;
import org.iu.oop2ze.core.database.repositories.MitarbeiterRepository;
import org.iu.oop2ze.core.helpers.EnviromentHelper;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.jetbrains.annotations.NotNull;
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
    @LazyInject
    private MitarbeiterRepository mitarbeiterRepository;

    @LazyInject
    private AbteilungRepository abteilungRepository;

    public Mitarbeiter erstelleMitarbeiter(
            @NotNull final String name,
            @NotNull final String vorname,
            @NotNull final String personalnummer,
            final Abteilung abteilung
    ) {
        if (name.isBlank() || vorname.isBlank() || personalnummer.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (mitarbeiterRepository.findByPersonalnummer(personalnummer) != null) {
            log.error("Mitarbeiter mit der Personalnummer: '%s' existiert bereits".formatted(personalnummer));
            return null;
        }

        var email = "%s.%s@%s.de".formatted(vorname, name, EnviromentHelper.gibFirma());
        if (mitarbeiterRepository.findByEmail(email) != null) {
            log.error("Mitarbeiter mit der Email: '%s' existiert bereits".formatted(email));
            return null;
        }

        var mitarbeiter = new Mitarbeiter(name, vorname, personalnummer, false, abteilung, email, "");

        mitarbeiterRepository.save(mitarbeiter);
        return mitarbeiter;
    }

    @Override
    public Mitarbeiter bearbeiteMitarbeiter(
            @NotNull Mitarbeiter mitarbeiter,
            final String name,
            final String vorname,
            final Abteilung abteilung
    ) {
        if (name != null && !name.isBlank())
            mitarbeiter.setName(name);

        if (vorname != null && !vorname.isBlank())
            mitarbeiter.setVorname(vorname);

        var email = "%s.%s@%s.de".formatted(vorname, name, EnviromentHelper.gibFirma());
        if (email.compareTo(mitarbeiter.getEmail()) != 0) {
            if (mitarbeiterRepository.findByEmail(email) != null) {
                log.error("Mitarbeiter mit der Email: '%s' existiert bereits".formatted(email));
                return null;
            }
            mitarbeiter.setEmail(email);
        }

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
        var mitarbeiter = mitarbeiterRepository.findByEmailAndPasswort(email, passwort);

        if (mitarbeiter == null) {
            var emailMitarbeiter = mitarbeiterRepository.findByEmail(email);
            if (emailMitarbeiter != null && emailMitarbeiter.getPasswort().isBlank()) {
                emailMitarbeiter.setPasswort(passwort);
                mitarbeiterRepository.save(emailMitarbeiter);

                return emailMitarbeiter;
            }
        }

        return mitarbeiter;
    }

    public List<Mitarbeiter> findeAlleMitarbeiter() {
        List<Mitarbeiter> mitarbeiter = new ArrayList<>();

        for (Mitarbeiter m : mitarbeiterRepository.findAll()) {
            if (!m.getIsSysAdmin())
                mitarbeiter.add(m);
        }

        return mitarbeiter;
    }

    public List<Mitarbeiter> findeAlleMitarbeiterFuerAbteilung(@NotNull final Abteilung abteilung) {
        return new ArrayList<>(mitarbeiterRepository.findAllByAbteilung(abteilung));
    }

    @Override
    public List<Mitarbeiter> findeAlleFreienHRMitarbeiter() {
        List<Mitarbeiter> hrMitarbeiter = new ArrayList<>();

        var hrAbteilungen = abteilungRepository.findByIsHr(true);

        for (Abteilung abteilung : hrAbteilungen) {
            hrMitarbeiter.addAll(mitarbeiterRepository.findAllByAbteilung(abteilung));
        }

        hrMitarbeiter
                .stream()
                .filter(mitarbeiter -> abteilungRepository.findByLeitenderMitarbeiter(mitarbeiter) != null)
                .forEach(hrMitarbeiter::remove);

        return hrMitarbeiter;
    }
}

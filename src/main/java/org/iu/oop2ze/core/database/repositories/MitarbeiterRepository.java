package org.iu.oop2ze.core.database.repositories;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter, Long> {
    Mitarbeiter findByPersonalnummer(final String personalnummer);
    Mitarbeiter findByIsSysAdmin(final Boolean isSysAdmin);
    Mitarbeiter findByEmailAndPasswort(final String email, final String passwort);
    List<Mitarbeiter> findAllByAbteilung(final Abteilung abteilung);
}

package org.iu.oop2ze.core.database.repositories;

import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;

public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter, Long> {
    Mitarbeiter findByPersonalnummer(final String personalnummer);
}

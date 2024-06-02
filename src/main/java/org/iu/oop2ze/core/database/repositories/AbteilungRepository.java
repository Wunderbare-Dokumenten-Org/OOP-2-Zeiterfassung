package org.iu.oop2ze.core.database.repositories;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interface, um die Datenbank für Abteilungen abzufragen (wird automatisch implementiert)
 *
 * @author Julius Beier
 */
public interface AbteilungRepository extends CrudRepository<Abteilung, Long> {
    Abteilung findByName(final String name);

    List<Abteilung> findByIsHr(final boolean isHr);

    Abteilung findByLeitenderMitarbeiter(final Mitarbeiter leitenderMitarbeiter);
}

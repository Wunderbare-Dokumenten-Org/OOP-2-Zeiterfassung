package org.iu.oop2ze.core.database.repositories;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.springframework.data.repository.CrudRepository;

public interface AbteilungRepository extends CrudRepository<Abteilung, Long> {
    Abteilung findByName(final String name);
    Abteilung findByIsHr(final boolean isHr);
}

package org.iu.oop2ze.core.database.repositories;

import org.iu.oop2ze.core.database.models.Antrag;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface, um die Datenbank für Anträge abzufragen (wird automatisch implementiert)
 *
 * @author Julius Beier
 */
public interface AntragRepository extends CrudRepository<Antrag, Long> {
}
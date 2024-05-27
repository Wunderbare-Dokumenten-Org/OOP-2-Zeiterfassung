package org.iu.oop2ze.core.database.repositories;

import org.iu.oop2ze.core.database.models.Antrag;
import org.springframework.data.repository.CrudRepository;

public interface AntragRepository extends CrudRepository<Antrag, Long> {
}

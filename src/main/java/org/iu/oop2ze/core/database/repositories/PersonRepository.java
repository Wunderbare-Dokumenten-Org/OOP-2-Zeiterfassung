package org.iu.oop2ze.core.database.repositories;

import org.iu.oop2ze.core.database.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}

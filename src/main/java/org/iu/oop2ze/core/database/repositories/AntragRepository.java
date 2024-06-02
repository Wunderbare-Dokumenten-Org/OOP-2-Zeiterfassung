package org.iu.oop2ze.core.database.repositories;

import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interface, um die Datenbank für (Zeitstempel) Anträge abzufragen (wird automatisch implementiert)
 *
 * @author Julius Beier
 */
public interface AntragRepository extends CrudRepository<Antrag, Long> {
    Antrag findFirstByStellenderMitarbeiterAndTypeOrderByErstelltDesc(final Mitarbeiter stellenderMitarbeiter, final AntragType type);

    List<Antrag> findByStellenderMitarbeiterAndType(final Mitarbeiter stellenderMitarbeiter, AntragType type);

    List<Antrag> findByBearbeitenderMitarbeiterAndType(final Mitarbeiter bearbeitenderMitarbeiter, AntragType type);
}
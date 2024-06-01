package org.iu.oop2ze.core.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iu.oop2ze.core.database.models.abstracts.BaseEntity;

/**
 * Stellt eine Abteilung, in der Datenbank dar
 *
 * @author Julius Beier
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Abteilung extends BaseEntity {
    private String name;
    private Boolean isHr;
    @OneToOne
    private Mitarbeiter leitenderMitarbeiter;
}

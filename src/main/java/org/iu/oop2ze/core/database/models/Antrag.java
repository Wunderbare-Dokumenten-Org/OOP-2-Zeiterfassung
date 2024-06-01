package org.iu.oop2ze.core.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iu.oop2ze.core.database.models.abstracts.BaseEntity;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;

import java.util.Date;

/**
 * Stellt einen Antrag, in der Datenbank dar
 *
 * @author Julius Beier
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Antrag extends BaseEntity {
    @ManyToOne
    private Mitarbeiter stellenderMitarbeiter;
    private AntragType type;
    private Date datum;
    private String titel;
    private StatusType status;
    private String kommentar;
    @ManyToOne
    private Mitarbeiter bearbeitenderMitarbeiter;
}

package org.iu.oop2ze.core.database.models;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iu.oop2ze.core.database.encryption.Encrypter;
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
    @Convert(converter = Encrypter.class)
    private AntragType type;
    @Convert(converter = Encrypter.class)
    private Date datum;
    @Convert(converter = Encrypter.class)
    private String titel;
    @Convert(converter = Encrypter.class)
    private StatusType status;
    @Convert(converter = Encrypter.class)
    private String kommentar;
    @Convert(converter = Encrypter.class)
    private Boolean genehmigt;
    @ManyToOne
    private Mitarbeiter bearbeitenderMitarbeiter;
}

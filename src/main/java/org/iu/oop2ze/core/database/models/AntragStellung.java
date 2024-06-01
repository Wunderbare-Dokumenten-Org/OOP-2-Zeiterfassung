package org.iu.oop2ze.core.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iu.oop2ze.core.database.models.abstracts.BaseEntity;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AntragStellung extends BaseEntity {
    @OneToOne
    private Antrag antrag;
    private String titel;
    private StatusType status;
    private String kommentar;
    @ManyToOne
    private Mitarbeiter bearbeitenderMitarbeiter;
}

package org.iu.oop2ze.core.database.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.iu.oop2ze.core.database.models.abstracts.BaseEntity;

import lombok.Getter;
import lombok.Setter;

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

    public String getBeschreibung() {
        return null;
    }
}

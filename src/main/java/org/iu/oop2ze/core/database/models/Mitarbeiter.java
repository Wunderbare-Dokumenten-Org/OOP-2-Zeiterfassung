package org.iu.oop2ze.core.database.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.iu.oop2ze.core.database.models.abstracts.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mitarbeiter extends BaseEntity {
    private String name;
    private String vorname;
    private String personalnummer;
    private Boolean isSysAdmin;
    @ManyToOne
    private Abteilung abteilung;
    private String email;
    private String passwort;
}

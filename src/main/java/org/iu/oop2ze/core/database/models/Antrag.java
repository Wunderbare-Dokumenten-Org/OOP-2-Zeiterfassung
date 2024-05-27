package org.iu.oop2ze.core.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.iu.oop2ze.core.database.models.abstracts.BaseEntity;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Antrag extends BaseEntity {
    @OneToMany
    private Mitarbeiter stellenderMitarbeiter;
    private AntragType type;
    private Date uhrzeit;
}
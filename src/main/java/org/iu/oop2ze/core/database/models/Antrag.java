package org.iu.oop2ze.core.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Antrag {
    @Id
    @GeneratedValue
    private Long Id;
    @OneToOne
    private Person StellendePerson;
    private AntragType Type;
    private LocalDateTime Uhrzeit;
    @OneToOne
    private Person BearbeitendePerson;
}

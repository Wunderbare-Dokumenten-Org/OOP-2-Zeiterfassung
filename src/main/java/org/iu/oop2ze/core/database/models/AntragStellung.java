package org.iu.oop2ze.core.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class AntragStellung {
    @Id
    @GeneratedValue
    private Long Id;
    @OneToOne
    private Antrag Antrag;
    private String Titel;
    private LocalDateTime Erstellt;
    private LocalDateTime Bearbeitet;
    private StatusType Status;
    private String Kommentar;
}

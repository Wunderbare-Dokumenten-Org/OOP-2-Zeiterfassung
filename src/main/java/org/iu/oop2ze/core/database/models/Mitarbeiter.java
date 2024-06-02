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

/**
 * Stellt einen Mitarbeiter, in der Datenbank dar
 *
 * @author Julius Beier
 */
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
    @Convert(converter = Encrypter.class)
    private String passwort;
}

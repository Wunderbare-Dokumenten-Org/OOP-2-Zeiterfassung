package org.iu.oop2ze.core.database.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue
    private Long Id;
    private String Name;
    private String Vorname;
    private String Personalnummer;
    private Boolean IsLeitend;
    private Boolean IsSysAdmin;
    @ManyToOne
    private Abteilung Abteilung;
    private String Email;
    private String Passwort;
}

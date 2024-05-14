package org.iu.oop2ze.core.database.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Abteilung {
  @Id @GeneratedValue private Long Id;
  private String Name;
  @OneToOne private Person LeitendePerson;
  @OneToMany private List<Person> Personen;
}

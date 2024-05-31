package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;

import java.util.List;

public interface IMitarbeiterService {
    Mitarbeiter erstelleMitarbeiter(final String name, final String vorname, final String personalnummer, final Abteilung abteilung);

    Mitarbeiter bearbeiteMitarbeiter(Mitarbeiter mitarbeiter, final String name, final String vorname, final Abteilung abteilung);

    void loescheMitarbeiter(final Mitarbeiter mitarbeiter);

    Mitarbeiter findeMitarbeiterMitLogin(final String email, final String passwort);

    List<Mitarbeiter> findeAlleMitarbeiter();

    List<Mitarbeiter> findeAlleMitarbeiterFuerAbteilung(final Abteilung abteilung);
}

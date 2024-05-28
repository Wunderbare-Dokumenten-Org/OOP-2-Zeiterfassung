package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;

public interface IAbteilungService {
    Abteilung erstelleAbteilung(final String name, final Boolean isHr, final Mitarbeiter leitenderMitarbeiter);

    Abteilung bearbeiteAbteilung(Abteilung abteilung, final String name, final Mitarbeiter leitenderMitarbeiter);

    void loescheAbteilung(final Abteilung abteilung);
}
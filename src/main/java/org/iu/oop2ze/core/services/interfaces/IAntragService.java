package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;

import java.util.Date;

public interface IAntragService {
    Antrag erstelleAntrag(final Mitarbeiter stellenderMitarbeiter, final AntragType type, final Date datum);

    Antrag bearbeiteAntrag(Antrag antrag, final AntragType type, final Date datum);

    void loescheAntrag(final Antrag antrag);
}

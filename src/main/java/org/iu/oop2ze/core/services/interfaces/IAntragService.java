package org.iu.oop2ze.core.services.interfaces;

import org.iu.oop2ze.core.database.models.Antrag;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.models.abstracts.enums.AntragType;
import org.iu.oop2ze.core.database.models.abstracts.enums.StatusType;

import java.util.Date;

public interface IAntragService {
    Antrag erstelleAntrag(final Mitarbeiter stellenderMitarbeiter, final AntragType type, final Date datum, final String titel, final StatusType status,final String kommentar, final Mitarbeiter bearbeitenderMitarbeiter);

    Antrag bearbeiteAntrag(Antrag antrag, final AntragType type, final Date datum, final StatusType status, final String kommentar, final Mitarbeiter bearbeitenderMitarbeiter);

    void loescheAntrag(final Antrag antrag);
}

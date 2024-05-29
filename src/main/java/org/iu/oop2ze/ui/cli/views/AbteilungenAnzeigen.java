package org.iu.oop2ze.ui.cli.views;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class AbteilungenAnzeigen extends CliComponent {
    @Autowired
    private IAbteilungService abteilungService;
    @Override
    public void exec() {
        var abteilungen = abteilungService.findeAlleAbteilungen();
        if (abteilungen.isEmpty()) {
            System.out.println("Keine Abteilungen gefunden.");
        } else {
            System.out.println("Liste der Abteilungen:");
            for (Abteilung abteilung : abteilungen) {
                System.out.println("ID: " + abteilung.getId() + ", Name: " + abteilung.getName() + ", Beschreibung: " + abteilung.getBeschreibung());
            }
        }
    }
}

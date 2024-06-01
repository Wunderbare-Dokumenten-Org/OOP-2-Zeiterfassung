package org.iu.oop2ze.ui.cli.views.abteilung;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class AbteilungenBearbeitenView extends CliComponent {
    @Autowired
    private IAbteilungService abteilungService;

    @Autowired
    private IMitarbeiterService mitarbeiterService;

    @Override
    public void exec() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Möchten Sie die Abteilung nach ID oder Name bearbeiten? (ID/Name):");
        String auswahl = scanner.nextLine();

        Abteilung abteilung = null;

        if (auswahl.equalsIgnoreCase("ID")) {
            System.out.println("Geben Sie die ID der Abteilung ein, die bearbeitet werden soll:");
            Long id = Long.parseLong(scanner.nextLine());
            abteilung = abteilungService.findeAbteilungNachId(id);
        } else if (auswahl.equalsIgnoreCase("Name")) {
            System.out.println("Geben Sie den Namen der Abteilung ein, die bearbeitet werden soll:");
            String name = scanner.nextLine();
            abteilung = abteilungService.findeAbteilungNachName(name);
        } else {
            System.out.println("Ungültige Auswahl.");
            return;
        }

        if (abteilung == null) {
            System.out.println("Abteilung nicht gefunden.");
            return;
        }

        System.out.println("Geben Sie den neuen Namen der Abteilung ein (leer lassen, um unverändert zu lassen):");
        String neuerName = scanner.nextLine();

        System.out.println("Geben Sie den Namen des neuen Leiters ein (leer lassen, um unverändert zu lassen):");
        String neuerLeiterName = scanner.nextLine();
        Mitarbeiter neuerLeiter = null;
        if (!neuerLeiterName.isBlank()) {
            neuerLeiter = mitarbeiterService.findeMitarbeiterNachName(neuerLeiterName);
            if (neuerLeiter == null) {
                System.out.println("Mitarbeiter mit diesem Namen nicht gefunden.");
                return;
        }

        abteilungService.bearbeiteAbteilung(abteilung, neuerName, neuerLeiter);
        System.out.println("Abteilung erfolgreich bearbeitet.");
    }
}
}

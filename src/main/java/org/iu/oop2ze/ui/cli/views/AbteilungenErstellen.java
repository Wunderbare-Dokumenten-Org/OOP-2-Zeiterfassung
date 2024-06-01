package org.iu.oop2ze.ui.cli.views;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
public class AbteilungenErstellen extends CliComponent {

    @Autowired
    private IAbteilungService abteilungService;

    @Autowired
    private IMitarbeiterService mitarbeiterService;

    @Override
    public void exec() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie den Namen der neuen Abteilung ein:");
        String name = scanner.nextLine();

        System.out.println("Ist dies eine HR-Abteilung? (Ja/Nein):");
        String isHrInput = scanner.nextLine();
        Boolean isHr = isHrInput.equalsIgnoreCase("Ja");

        System.out.println("Geben Sie den Namen des leitenden Mitarbeiters ein:");
        String leiterName = scanner.nextLine();
        Mitarbeiter leitenderMitarbeiter = mitarbeiterService.findeMitarbeiterNachName(leiterName);
        if (leitenderMitarbeiter == null) {
            System.out.println("Mitarbeiter mit diesem Namen nicht gefunden.");
            return;
        }

        Abteilung neueAbteilung = abteilungService.erstelleAbteilung(name, isHr, leitenderMitarbeiter);
        if (neueAbteilung != null) {
            System.out.println("Neue Abteilung erfolgreich erstellt.");
        } else {
            System.out.println("Fehler beim Erstellen der neuen Abteilung.");
        }
    }
}

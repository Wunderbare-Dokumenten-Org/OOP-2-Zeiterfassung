package org.iu.oop2ze.ui;
import java.util.Scanner;
public class StaticHome {
    public static void startseite() {
        System.out.println("Willkommen beim Zeiterfassungssystem!");
        System.out.println("Bitte wählen Sie eine Option:");
        System.out.println("1. Arbeitszeithistorie anzeigen");
        System.out.println("2. Einstempeln");
        System.out.println("3. Antrag stellen");
        System.out.println("4. Beenden");

        Scanner scanner = new Scanner(System.in);
        int auswahl = scanner.nextInt();

        switch (auswahl) {
            case 1:
                anzeigenArbeitszeithistorie();
                break;
            case 2:
                einstempeln();
                break;
            case 3:
                AntragStellen.antragStellen();
                Urlaubsantrag.stelleUrlaubsantrag();
                break;
            case 4:
                System.out.println("Tschö mit ö");
                System.exit(0);
                break;
            default:
                System.out.println("Ungültige Auswahl. Bitte wählen Sie erneut.");
                startseite();
                break;
        }
    }

}

package org.iu.oop2ze.ui;
import java.util.Scanner;
public class Start {
    private Scanner scanner;

    public Start() {
        scanner = new Scanner(System.in);
    }

    public void startseite() {
        System.out.println("Willkommen beim Zeiterfassungssystem!");
        System.out.println("Bitte wählen Sie eine Option:");
        System.out.println("1. Arbeitszeithistorie anzeigen");
        System.out.println("2. Einstempeln");
        System.out.println("3. Antrag stellen");
        System.out.println("4. Beenden");

        int auswahl = scanner.nextInt();

        switch (auswahl) {
            case 1:
                anzeigenArbeitszeithistorie();
                break;
            case 2:
                einstempeln();
                break;
            case 3:
                antragStellen();
                break;
            case 4:
                System.out.println("Vielen Dank für die Nutzung des Zeiterfassungssystems!");
                System.exit(0);
                break;
            default:
                System.out.println("Ungültige Auswahl. Bitte wählen Sie erneut.");
                startseite();
                break;
        }
    }

    private void anzeigenArbeitszeithistorie() {
        // Hier implementieren Sie den Code zum Anzeigen der Arbeitszeithistorie
        System.out.println("Arbeitszeithistorie anzeigen...");
    }

    private void einstempeln() {
        // Hier implementieren Sie den Code zum Ein- und Ausstempeln
        System.out.println("Einstempeln...");
    }

    private void antragStellen() {
        // Hier implementieren Sie den Code zum Stellen von Anträgen
        System.out.println("Antrag stellen...");
    }

    public static void main(String[] args) {
        Start start = new Start();
        start.startseite();
    }
}

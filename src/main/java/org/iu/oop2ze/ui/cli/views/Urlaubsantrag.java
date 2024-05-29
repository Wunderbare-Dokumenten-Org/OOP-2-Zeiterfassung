package org.iu.oop2ze.ui.cli.views;

import java.util.Scanner;

public class Urlaubsantrag {
    public static void stelleUrlaubsantrag() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Urlaubsantrag stellen...");
        System.out.print("Bitte geben Sie den Grund für den Urlaubsantrag ein: ");
        String grund = scanner.nextLine();

        System.out.print("Bitte geben Sie das Startdatum (tt.mm.jj) ein: ");
        String startdatum = scanner.nextLine();

        System.out.print("Bitte geben Sie das Enddatum (tt.mm.jj) ein: ");
        String enddatum = scanner.nextLine();

        if (istDatumGueltig(startdatum) && istDatumGueltig(enddatum) && istZeitraumGueltig(startdatum, enddatum)) {
            System.out.println("Ihr Urlaubsantrag wurde erfolgreich gestellt.");
            System.out.println("Grund: " + grund);
            System.out.println("Startdatum: " + startdatum);
            System.out.println("Enddatum: " + enddatum);
        } else {
            System.out.println("Ungültige Datumsangabe. Bitte versuchen Sie es erneut.");
        }
    }

    private static boolean istDatumGueltig(String datum) {
        return datum.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    private static boolean istZeitraumGueltig(String startdatum, String enddatum) {
        return startdatum.compareTo(enddatum) <= 0;
    }
}

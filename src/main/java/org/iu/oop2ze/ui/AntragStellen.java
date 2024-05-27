package org.iu.oop2ze.ui;
import java.util.Scanner;
public class AntragStellen {
    public static void antragStellen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Antrag stellen...");
        System.out.print("Bitte geben Sie den Grund für den Antrag ein: ");
        String cause = scanner.nextLine();

        System.out.println("Ihr Antrag wurde erfolgreich gestellt.");
        System.out.println("Grund: " + cause);
    }
}

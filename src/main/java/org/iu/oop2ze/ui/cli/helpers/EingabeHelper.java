package org.iu.oop2ze.ui.cli.helpers;

import org.iu.oop2ze.ui.cli.abstracts.MenuComponent;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Klasse, welche statische Hilfsmethoden und Hilfsfunktionen, zur Konsolen Eingabe beinhaltet
 *
 * @author Julius Beier
 */
public class EingabeHelper {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Leert, die Konsole
     *
     * @author Julius Beier
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Gibt ein Element aus der options Liste oder null zurück
     *
     * @param title         Der Titel, des Menüs
     * @param options       Die auswählbaren Menüeinträge
     * @param menuComponent Lambda Expression, zur formatierung, der Menüeinträge
     * @return Den ausgewählten Menüeintrag oder null
     * @author Julius Beier
     * @see MenuComponent
     */
    public static <T> T menuEinzelEingabe(@NotNull final String title,
                                          @NotNull final List<T> options,
                                          MenuComponent<T> menuComponent) {
        // NOTE: vllt multipage support???
        if (options.isEmpty())
            return null;

        var prompt = new StringBuilder();

        prompt.append("%s\n".formatted(title));

        if (menuComponent == null)
            menuComponent = Object::toString;

        int i = 1;
        for (Iterator<T> iter = options.iterator(); iter.hasNext(); i++) {
            var item = iter.next();
            prompt.append("\t%d: %s\n".formatted(i, menuComponent.getMenuEntry(item)));
        }

        prompt.append("Wählen Sie eine Option (%d - %d):".formatted(1, options.size()));

        var menu = prompt.toString();

        int result = 0;
        do {
            clearConsole();
            System.out.print(menu);

            var tmp = scanner.nextLine();
            if (tmp.isBlank()) {
                return null;
            }

            try {
                result = Integer.parseInt(tmp);
            } catch (Exception e) {
                System.out.println("Fehler bei der Eingabe");
                EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
            }
        } while (result < 1 || result > options.size());

        return options.get(result - 1);
    }

    /**
     * Funktion, welche eine String Eingabe darstellt
     *
     * @param prompt       Der Text, welcher zur Eingabe auffordert
     * @param defaultValue Wert, welcher bei einer Leeren Eingabe zurückgegeben wird
     * @return Der eingegebene Text
     * @author Julius Beier
     */
    public static String stringEingabe(final String prompt, final String defaultValue) {
        String result;

        do {
            System.out.print(prompt);
            result = scanner.nextLine();

            if (defaultValue != null) {
                if (result.isBlank() && !defaultValue.isBlank()) {
                    return defaultValue;
                }
            }
        } while (result.isBlank());

        return result;
    }
}

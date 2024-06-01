package org.iu.oop2ze.ui.cli.helpers;

import lombok.Getter;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.jetbrains.annotations.NotNull;

/**
 * Klasse, welche statische Hilfsfunktionen für den angemeldeten Mitarbeiter bereitstellt
 *
 * @author Julius Beier
 */
public class UserHelper {
    @Getter
    private static Mitarbeiter angemeldeterMitarbeiter;

    /**
     * Methode, welche den angemeldeten Mitarbeiter setzt
     *
     * @param mitarbeiter Der angemeldete Mitarbeiter
     * @author Julius Beier
     */
    public static void login(@NotNull final Mitarbeiter mitarbeiter) {
        if (angemeldeterMitarbeiter == null)
            angemeldeterMitarbeiter = mitarbeiter;
    }

    /**
     * Methode, welche den angemeldeten Mitarbeiter null setzt
     *
     * @author Julius Beier
     */
    public static void logout() {
        angemeldeterMitarbeiter = null;
    }

    /**
     * Funktion, welche aussagt, ob ein Mitarbeiter angemeldet ist
     *
     * @return Ob ein Mitarbeiter angemeldet ist
     * @author Julius Beier
     */
    public static Boolean isAngemeldet() {
        return angemeldeterMitarbeiter != null;
    }
}

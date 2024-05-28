package org.iu.oop2ze.ui.cli.helpers;

import lombok.Getter;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.jetbrains.annotations.NotNull;

public class UserHelper {
    @Getter
    private static Mitarbeiter angemeldeterMitarbeiter;

    public static void login(@NotNull final Mitarbeiter mitarbeiter) {
        if (angemeldeterMitarbeiter == null)
            angemeldeterMitarbeiter = mitarbeiter;
    }

    public static void logout() {
        angemeldeterMitarbeiter = null;
    }

    public static Boolean isAngemeldet() {
        return angemeldeterMitarbeiter != null;
    }
}

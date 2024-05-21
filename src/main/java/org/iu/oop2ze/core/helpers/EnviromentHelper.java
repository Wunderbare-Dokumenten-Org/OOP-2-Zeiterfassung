package org.iu.oop2ze.core.helpers;

import lombok.extern.slf4j.Slf4j;

/**
 * Klasse mit statischen Funktionen, welche Umgebungsvariablen laden
 *
 * @author Julius Beier
 */
@Slf4j
public class EnviromentHelper {
    private static String firma;

    /**
     * Lädt den Firmen Namen aus den Umgebungsvariablen
     *
     * @return Name der Firma
     * @author Julius Beier
     */
    public static String gibFirma() {
        if (firma != null)
            if (!firma.isBlank()) return firma;

        var envVarInhalt = System.getenv("OOP2ZE_FIRMA");
        if (envVarInhalt == null || envVarInhalt.isBlank()) {
            log.error("Firmen Name konnte nicht aus den Umgebungsvariablen geladen werden");
            throw new IllegalStateException();
        }

        firma = envVarInhalt;
        return firma;
    }
}

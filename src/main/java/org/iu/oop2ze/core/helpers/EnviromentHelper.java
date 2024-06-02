package org.iu.oop2ze.core.helpers;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * Klasse mit statischen Funktionen, welche Umgebungsvariablen laden
 *
 * @author Julius Beier
 */
@Slf4j
public class EnviromentHelper {
    private static String firma;
    private static String encryptionSecret;

    /**
     * Lädt den Firmen Namen aus den Umgebungsvariablen
     *
     * @return Name der Firma
     * @author Julius Beier
     */
    public static String gibFirma() {
        var envVarInhalt = System.getenv();
        return gibEnvVar("OOP2ZE_FIRMA", firma);
    }

    public static String gibEncryptionSecret() {
        return gibEnvVar("OOP2ZE_ENCRYPTION_SECRET", encryptionSecret);
    }

    private static String gibEnvVar(@NotNull final String envVar, String storeVar) {
        if (storeVar != null)
            if (!storeVar.isBlank()) return storeVar;

        var envVarInhalt = System.getenv(envVar);
        if (envVarInhalt == null || envVarInhalt.isBlank()) {
            throw new IllegalStateException();
        }

        storeVar = envVarInhalt;
        return storeVar;
    }
}

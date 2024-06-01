package org.iu.oop2ze.ui.cli.helpers;

import org.jetbrains.annotations.NotNull;

/**
 * Klasse, welche statische Hilfsfunktionen für Prompts bereitstellt
 *
 * @author Julius Beier
 */
public class PromptHelper {
    /**
     * Funktion, welche einen formatierten Prompt String zurückgibt
     *
     * @param prompt String mit einem Platzhalter, für den Defaultwert, der Eingabe
     * @param value  Der Defaultwert, welcher bei einer Leeren Eingabe zurückgegeben wird
     * @return Den formatierten Prompt String
     * @author Julius Beier
     * @see EingabeHelper
     */
    public static String erstellInputPrompt(@NotNull final String prompt, @NotNull final String value) {
        return prompt.formatted(value.isBlank() ? "" : "(%s)".formatted(value));
    }
}

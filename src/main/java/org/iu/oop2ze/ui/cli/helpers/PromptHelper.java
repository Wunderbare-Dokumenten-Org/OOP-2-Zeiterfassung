package org.iu.oop2ze.ui.cli.helpers;

import org.jetbrains.annotations.NotNull;

public class PromptHelper {
    public static String erstellInputPrompt(@NotNull final String prompt, @NotNull final String value) {
        return prompt.formatted(value.isBlank() ? "" : "(%s)".formatted(value));
    }
}

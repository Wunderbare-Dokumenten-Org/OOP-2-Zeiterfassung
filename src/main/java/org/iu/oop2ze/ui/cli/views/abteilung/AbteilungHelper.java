package org.iu.oop2ze.ui.cli.views.abteilung;

import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;

/**
 * Klasse, welche statische Hilfsfunktionen für die Abteilungsmanipulation bereitstellt
 *
 * @author Julius Beier, Nico Nimschofsky
 * @see CliComponent
 */
public class AbteilungHelper {
    /**
     * Funktion, welche einen Mitarbeiter auswählen lässt
     *
     * @author Julius Beier
     * @see CliComponent
     */
    public static Mitarbeiter gibLeitenderMitarbeiter(Mitarbeiter leitenderMitarbeiter, Mitarbeiter lastLeitenderMitarbeiter, IMitarbeiterService mitarbeiterService) {
        var leitenderMitarbeiterPrompt = PromptHelper.erstellInputPrompt("Leitender Mitarbeiter%s: ",
                leitenderMitarbeiter == null ? "" : leitenderMitarbeiter.getName());

        leitenderMitarbeiter = EingabeHelper.menuEinzelEingabe(leitenderMitarbeiterPrompt,
                mitarbeiterService.findeAlleMitarbeiter(), (Mitarbeiter m) -> {
                    return "%s, %s".formatted(m.getName(), m.getVorname());
                });

        if (leitenderMitarbeiter != null)
            lastLeitenderMitarbeiter = leitenderMitarbeiter;

        if (leitenderMitarbeiter == null && lastLeitenderMitarbeiter != null)
            leitenderMitarbeiter = lastLeitenderMitarbeiter;

        return leitenderMitarbeiter;
    }
}

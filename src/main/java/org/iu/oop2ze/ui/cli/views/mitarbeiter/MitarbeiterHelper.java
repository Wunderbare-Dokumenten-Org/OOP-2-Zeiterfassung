package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;

/**
 * Klasse, welche statische Hilfsfunktionen für die Mitarbeitermanipulation bereitstellt
 *
 * @author Julius Beier
 * @see CliComponent
 */
public class MitarbeiterHelper {
    /**
     * Funktion, welche eine Abteilung auswählen lässt
     *
     * @author Julius Beier
     * @see CliComponent
     */
    public static Abteilung getAbteilung(Abteilung abteilung, Abteilung letzteAbteilung, IAbteilungService abteilungService) {
        var abteilungPrompt = PromptHelper.erstellInputPrompt(
                "Abteilung des Mitarbeiters%s: ",
                abteilung == null ? "" : abteilung.getName());
        abteilung = EingabeHelper.menuEinzelEingabe(abteilungPrompt, abteilungService.findeAlle(), Abteilung::getName);

        if (abteilung != null)
            letzteAbteilung = abteilung;

        if (abteilung == null && letzteAbteilung != null)
            abteilung = letzteAbteilung;

        return abteilung;
    }
}

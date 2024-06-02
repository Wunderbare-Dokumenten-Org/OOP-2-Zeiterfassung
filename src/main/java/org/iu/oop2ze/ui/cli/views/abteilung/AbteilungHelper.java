package org.iu.oop2ze.ui.cli.views.abteilung;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;

public class AbteilungHelper {
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

package org.iu.oop2ze.ui.cli.views.abteilung;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;

public class AbteilungBearbeitenView extends CliComponent {
    @LazyInject
    private IAbteilungService abteilungService;

    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @Setter
    private Abteilung ausgewaehlteAbteilung;

    @Override
    public void exec() {
        if (ausgewaehlteAbteilung == null)
            throw new IllegalStateException();

        EingabeHelper.clearConsole();

        System.out.println("Abteilung - Bearbeiten");
        var namePrompt = PromptHelper.erstellInputPrompt("Name der Abteilung%s: ", ausgewaehlteAbteilung.getName());
        var name = EingabeHelper.stringEingabe(namePrompt, ausgewaehlteAbteilung.getName());

        var currentleitenderMitarbeiter = ausgewaehlteAbteilung.getLeitenderMitarbeiter();
        var abteilungPrompt = PromptHelper.erstellInputPrompt(
                "Leitender Mitarbeiter%s: ",
                currentleitenderMitarbeiter == null ? "" : currentleitenderMitarbeiter.getName());
        var leitenderMitarbeiter = EingabeHelper.menuEinzelEingabe(abteilungPrompt, mitarbeiterService.findeAlleMitarbeiter(), (Mitarbeiter m) -> {
            return "%s, %s".formatted(m.getName(), m.getVorname());
        });

        if (leitenderMitarbeiter == null && currentleitenderMitarbeiter != null)
            leitenderMitarbeiter = currentleitenderMitarbeiter;

        abteilungService.bearbeiteAbteilung(ausgewaehlteAbteilung, name, leitenderMitarbeiter);
        ausgewaehlteAbteilung = null;
        EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
    }
}

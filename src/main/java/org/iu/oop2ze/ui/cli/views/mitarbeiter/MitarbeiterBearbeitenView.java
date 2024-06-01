package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import lombok.Setter;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IAbteilungService;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;

public class MitarbeiterBearbeitenView extends CliComponent {
    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @LazyInject
    private IAbteilungService abteilungService;

    @Setter
    private Mitarbeiter ausgewaehlterMitarbeiter;

    @Override
    public void exec() {
        if (ausgewaehlterMitarbeiter == null)
            throw new IllegalStateException();

        EingabeHelper.clearConsole();

        System.out.println("Mitarbeiter - Bearbeiten");
        var namePrompt = PromptHelper.erstellInputPrompt("Name des Mitarbeiters%s: ", ausgewaehlterMitarbeiter.getName());
        var name = EingabeHelper.stringEingabe(namePrompt, ausgewaehlterMitarbeiter.getName());

        var vornamePrompt = PromptHelper.erstellInputPrompt("Vorname des Mitarbeiters%s: ", ausgewaehlterMitarbeiter.getVorname());
        var vorname = EingabeHelper.stringEingabe(vornamePrompt, ausgewaehlterMitarbeiter.getVorname());

        var mitarbeiterAbteilung = ausgewaehlterMitarbeiter.getAbteilung();
        var abteilungPrompt = PromptHelper.erstellInputPrompt(
                "Abteilung des Mitarbeiters%s: ",
                mitarbeiterAbteilung == null ? "" : mitarbeiterAbteilung.getName());
        var abteilung = EingabeHelper.menuEinzelEingabe(abteilungPrompt, abteilungService.findeAlle(), Abteilung::getName);

        mitarbeiterService.bearbeiteMitarbeiter(ausgewaehlterMitarbeiter, name, vorname, abteilung);
        ausgewaehlterMitarbeiter = null;
    }
}

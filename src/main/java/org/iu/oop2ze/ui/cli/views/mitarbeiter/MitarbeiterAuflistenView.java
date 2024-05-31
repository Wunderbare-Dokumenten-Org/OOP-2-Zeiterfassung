package org.iu.oop2ze.ui.cli.views.mitarbeiter;

import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public class MitarbeiterAuflistenView extends CliComponent {
    @Lazy
    @Autowired
    private IMitarbeiterService mitarbeiterService;

    @Override
    public void exec() {
        List<Mitarbeiter> mitarbeiter;

        var user = UserHelper.getAngemeldeterMitarbeiter();

        if (user.getIsSysAdmin()) {
            mitarbeiter = mitarbeiterService.findeAlleMitarbeiter();
        } else if (user.getAbteilung().getIsHr()) {
            mitarbeiter = mitarbeiterService.findeAlleMitarbeiterFuerAbteilung(user.getAbteilung());
        } else {
            throw new IllegalStateException();
        }

        var res = EingabeHelper.menuEinzelEingabe("Wählen Sie einen Mitarbeiter aus", mitarbeiter);
        if (res != null) System.out.println(res.getName());
    }
}

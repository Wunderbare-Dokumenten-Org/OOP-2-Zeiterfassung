package org.iu.oop2ze.core.config;

import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.AbteilungRepository;
import org.iu.oop2ze.core.database.repositories.MitarbeiterRepository;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.springframework.stereotype.Component;

/**
 * Initialisiert die Datenbank
 *
 * @author Julius Beier
 */
@Component
public class Initializer {
    @LazyInject
    private MitarbeiterRepository mitarbeiterRepository;

    @LazyInject
    private AbteilungRepository abteilungRepository;

    /**
     * Erstellt, falls nötig, einen Systemadministrator und eine Abteilung (Hr)
     *
     * @author Julius Beier
     */
    public void initDb() {
        Mitarbeiter sysAdmin = mitarbeiterRepository.findByIsSysAdmin(true);
        if (sysAdmin == null) {
            sysAdmin = new Mitarbeiter("Admin", "Admin", "0", true, null, "admin@admin.de", "12345678");
            mitarbeiterRepository.save(sysAdmin);
        }

        Abteilung abteilung = abteilungRepository.findByIsHr(true);
        if (abteilung == null) {
            Abteilung defaultHr = new Abteilung("Human Resources", true, sysAdmin);
            abteilungRepository.save(defaultHr);
        }
    }
}

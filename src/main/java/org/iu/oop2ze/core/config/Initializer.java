package org.iu.oop2ze.core.config;

import jakarta.transaction.Transactional;
import org.iu.oop2ze.core.database.models.Abteilung;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.AbteilungRepository;
import org.iu.oop2ze.core.database.repositories.MitarbeiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(300)
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MitarbeiterRepository mitarbeiterRepository;

    @Autowired
    private AbteilungRepository abteilungRepository;

    public void onApplicationEvent(ContextRefreshedEvent event) {
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

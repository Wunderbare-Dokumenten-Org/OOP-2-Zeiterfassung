package org.iu.oop2ze.core.config;

import jakarta.transaction.Transactional;
import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.database.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(300)
@Transactional
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PersonRepository personRepository;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        Iterable<Mitarbeiter> persons = personRepository.findAll();
        if (!persons.iterator().hasNext()) {
            Mitarbeiter sysAdmin = new Mitarbeiter("Admin", "Admin", "0", true, null, "admin@admin.de", "12345678");

            this.personRepository.save(sysAdmin);
        }
    }
}

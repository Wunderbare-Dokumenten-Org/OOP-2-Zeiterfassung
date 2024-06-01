package org.iu.oop2ze.ui.cli.views;

import org.iu.oop2ze.core.database.models.Mitarbeiter;
import org.iu.oop2ze.core.services.interfaces.IMitarbeiterService;
import org.iu.oop2ze.ui.cli.abstracts.CliComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.helpers.EingabeHelper;
import org.iu.oop2ze.ui.cli.helpers.PromptHelper;
import org.iu.oop2ze.ui.cli.helpers.UserHelper;

/**
 * Klasse, welche den Login darstellt
 *
 * @author Julius Beier
 * @see CliComponent
 */
public class LoginView extends CliComponent {
    @LazyInject
    private IMitarbeiterService mitarbeiterService;

    @Override
    public void exec() {
        if (UserHelper.isAngemeldet())
            return;

        String email = "";
        String passwort = "";

        Mitarbeiter user;

        do {
            EingabeHelper.clearConsole();

            System.out.println("User - LoginView");

            var emailPrompt = PromptHelper.erstellInputPrompt("Bitte geben Sie Ihre Email an%s: ", email);
            email = EingabeHelper.stringEingabe(emailPrompt, email);

            var passwortPrompt = PromptHelper.erstellInputPrompt("Bitte geben Sie Ihr Passwort an%s: ", "*".repeat(passwort.length()));
            passwort = EingabeHelper.stringEingabe(passwortPrompt, passwort);

            user = mitarbeiterService.findeMitarbeiterMitLogin(email, passwort);
            if (user == null)
                EingabeHelper.stringEingabe("<ENTER> zum Fortfahren", "<ENTER>");
        } while (user == null);

        UserHelper.login(user);
    }
}

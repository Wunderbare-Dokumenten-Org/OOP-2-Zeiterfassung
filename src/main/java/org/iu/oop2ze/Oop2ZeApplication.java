package org.iu.oop2ze;

import org.iu.oop2ze.core.config.Initializer;
import org.iu.oop2ze.ui.cli.abstracts.InheritComponent;
import org.iu.oop2ze.ui.cli.abstracts.LazyInject;
import org.iu.oop2ze.ui.cli.views.HomeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Klasse, welche den Einstiegspunkt, der Anwendung beinhaltet
 *
 * @author Julius Beier
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.iu.oop2ze",
        includeFilters = @ComponentScan.Filter(InheritComponent.class))
@ComponentScan(basePackages = "org.iu.oop2ze",
        includeFilters = @ComponentScan.Filter(LazyInject.class))
public class Oop2ZeApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Oop2ZeApplication.class).run(args);
    }

    @Override
    public void run(String... args) {
        context.getBean(Initializer.class).initDb();
        context.getBean(HomeView.class).exec();
    }
}

package org.iu.oop2ze;

import org.iu.oop2ze.ui.cli.Home;
import org.iu.oop2ze.ui.cli.abstracts.InheritComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.iu.oop2ze",
        includeFilters = @ComponentScan.Filter(InheritComponent.class))
public class Oop2ZeApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Oop2ZeApplication.class).run(args);
    }

    @Override
    public void run(String... args) {
        context.getBean(Home.class).exec();
    }
}

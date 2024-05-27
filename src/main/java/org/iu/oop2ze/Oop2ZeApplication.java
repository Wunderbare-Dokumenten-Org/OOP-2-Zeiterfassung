package org.iu.oop2ze;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Oop2ZeApplication implements CommandLineRunner {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Oop2ZeApplication.class).run(args);
    }

    @Override
    public void run(String... args) {
    }
}

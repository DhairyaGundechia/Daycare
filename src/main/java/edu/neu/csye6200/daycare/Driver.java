package edu.neu.csye6200.daycare;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Driver {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Driver.class).headless(false).run(args);
    }
}

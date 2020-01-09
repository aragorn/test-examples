package me.jkkim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ExampleApplication.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }
}

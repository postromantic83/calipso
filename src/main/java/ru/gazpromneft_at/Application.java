package ru.gazpromneft_at;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application
{    /**
 * Главный вход.
 * @param args
 */
public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
}

}

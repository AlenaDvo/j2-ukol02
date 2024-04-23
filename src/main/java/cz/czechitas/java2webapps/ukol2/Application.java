package cz.czechitas.java2webapps.ukol2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hlavní třída, která spouští celou aplikaci pomocí Spring Boot.
 */
@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

//    private static List<String> readAllLines(String resource) throws IOException {
//        //Soubory z resources se získávají pomocí classloaderu. Nejprve musíme získat aktuální classloader.
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//
//        //Pomocí metody getResourceAsStream() získáme z classloaderu InpuStream, který čte z příslušného souboru.
//        //Následně InputStream převedeme na BufferedRead, který čte text v kódování UTF-8
//        try (InputStream inputStream = classLoader.getResourceAsStream(resource);
//             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
//
//            //Metoda lines() vrací stream řádků ze souboru. Pomocí kolektoru převedeme Stream<String> na List<String>.
//            return reader
//                    .lines()
//                    .collect(Collectors.toList());
//        }
//    }
//
    public static void main(String... args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        logger.info("Aplikace běží na adrese: http://localhost:{}", applicationContext.getEnvironment().getProperty("local.server.port"));
//        try {
//            System.out.println(readAllLines("citaty.txt"));
//
//        } catch (IOException e) {
//            System.out.println("Error");
//        }
    }
}

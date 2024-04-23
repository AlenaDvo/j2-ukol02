package cz.czechitas.java2webapps.ukol2.controller;

import cz.czechitas.java2webapps.ukol2.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final Random random = new Random();

    private static List<String> readAllLines(String resource) throws IOException {
        //Soubory z resources se získávají pomocí classloaderu. Nejprve musíme získat aktuální classloader.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        //Pomocí metody getResourceAsStream() získáme z classloaderu InpuStream, který čte z příslušného souboru.
        //Následně InputStream převedeme na BufferedRead, který čte text v kódování UTF-8
        try (InputStream inputStream = classLoader.getResourceAsStream(resource);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            //Metoda lines() vrací stream řádků ze souboru. Pomocí kolektoru převedeme Stream<String> na List<String>.
            return reader
                    .lines()
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/")
    public ModelAndView novyCitat() {
        try {
            List<String> citaty = readAllLines("citaty.txt");
            String vybranyCitat = citaty.get(random.nextInt(citaty.size()));
            System.out.println(vybranyCitat);
            ModelAndView result = new ModelAndView("citat");
            result.addObject("vybranyCitat", vybranyCitat);
            return result;
        } catch (IOException e) {
            System.out.println("IOException");
        }
        ModelAndView result = new ModelAndView("citat");
        result.addObject("vybranyCitat", "Toto je nahradni citat.");
        return result;
    }
}


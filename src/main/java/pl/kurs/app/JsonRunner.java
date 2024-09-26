package pl.kurs.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.config.ObjectMapperHolder;
import pl.kurs.model.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class JsonRunner {
    public static void main(String[] args) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper(); // Utworzenie obiektu klasy odpowiedzialnej za prace z JSON

        ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();

        List<Kid> kids = List.of(new Kid("Maciuś", "Nowak", 7),
                new Kid("Franuś", "Nowak", 4));

        Person adamN = new Person("Adam", "Nowak", 35, true, List.of("Motoryzacja"), kids);

//        objectMapper.writeValue(new File("src/main/resources/adamnowak.json"), adamN); // Zapis obiektu json - pierwszy argument gdzie chcemy zapisac(nie zawsze plik),
                                                                                                // drugi argument - co chcemy zapisac, jaki obiekt

        String adamNJson = objectMapper.writeValueAsString(adamN); // Zapisanie obiektu w formie JSON do obiektu typu String

        System.out.println(adamNJson);

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(adamN)); // Zapisanie obiektu w formie JSON do obiektu typu String w formie
                                                                                                    // "ładnej" - wciecia, spacje itp

        Person adam = objectMapper.readValue(new File("src/main/resources/adamnowak.json"), Person.class); // Odczyt z zasobu(nie koniecznie zawsze plik),
                                                                                                                    // pierwszy argument to skad odczytujemy
                                                                                                                    // drugi argument to do jakiej klasy chcemy odczytać


        System.out.println(adam);

        Todos todo3 = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/5"), Todos.class); // Pobranie JSON z adresu sieciowego i zamiana na obiekt

        System.out.println(todo3);

        String kidJson = "{\"firstName\":\"Maciuś\",\"lastName\":\"Nowak\",\"age\":4}";

        Kid macius = objectMapper.readValue(kidJson, Kid.class); // Zamiana na obiekt Kid z JSONa w stringu

        System.out.println(macius);

        // ----------------------------------------------------------

        System.out.println("\n \n");

        String json = "{ \"firstName\" : \"Robert\" } ";

        JsonNode jsonNode = objectMapper.readTree(json); // Utworzenie JsonNode z jsona
        System.out.println(jsonNode.get("firstName").asText()); // Wyciagniecie wartosci z JsonNode w postaci textu(string)

        System.out.println(jsonNode.toPrettyString()); // Wypisanie w postaci ladnego JSONa

        System.out.println(jsonNode.toString()); // Wypisanie w postaci JSON

        Kid kid = new Kid("Franek", "Kwiatkowski", 12);

        JsonNode kidJsonNode = objectMapper.valueToTree(kid); // Zamiana obiektu na JsonNode
        System.out.println(kidJsonNode);

        Kid kid2 = objectMapper.treeToValue(kidJsonNode, Kid.class); // Zamiana z JsonNode na obiekt (odwrotnosc tego wyzej)

        System.out.println(kid2);

        DateKeeper dateKeeper = new DateKeeper(new Date(86_400_000L * 20000));

        System.out.println(objectMapper.writeValueAsString(dateKeeper));

        Car car = new Car("Seat", 5);

        String carString = objectMapper.writeValueAsString(car);

        Dog dog = new Dog("Rambo", "Adam");

        System.out.println(objectMapper.writeValueAsString(dog));

        Car carFromString = objectMapper.readValue(carString, Car.class);

        System.out.println(carFromString);


    }
}

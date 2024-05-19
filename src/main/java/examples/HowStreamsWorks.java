package examples;

import beans.Car;
import beans.Person;
import mockData.MockData;

import java.util.List;
import java.util.stream.Collectors;

public class HowStreamsWorks {
    public static void understandingCollect() throws Exception {
        List<String> emails = MockData.readPeopleJson().stream()
                .map(Person::getEmail)
                .collect(Collectors.toList());
                emails.forEach(System.out::println);
        emails.forEach(System.out::println);

    }

    public static void intermediateAndTerminalOperations()throws Exception{

        List<Double> carsPrices = MockData.readCarJson().stream()
                .filter(car -> car.getPrice() < 10000)
                .map(Car::getPrice)
                .map(price -> price + (price * .14))
                .collect(Collectors.toList());

        carsPrices.forEach(System.out::println);
    }

    public static void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.readPeopleJson();
        List<Person> youngPeople = people.stream()
                .filter(p -> p.getAge() <= 15)
                .limit(15)
                .collect(Collectors.toList());

        youngPeople.forEach(System.out::println);
    }
}

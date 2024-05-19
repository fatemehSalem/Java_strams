package examples;

import beans.Car;
import beans.Person;
import mockData.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    public static  void sortedArray(){
        List<Integer> list = Arrays.asList(12 , 10 , 2 , 30 , 25 , 11 , 35 , 10);
        List<Integer> result = list.stream().sorted().collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    public static  void reverseSortedArray(){
        List<Integer> list = Arrays.asList(12 , 10 , 2 , 30 , 25 , 11 , 35 , 10);
        List<Integer> result = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    public static void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.readPeopleJson();

        Comparator<Person> comparing = Comparator
                .comparing(Person::getEmail)
                .reversed()
                .thenComparing(Person::getFirstName);

        List<Person> sort = people.stream()
                .sorted(comparing)
                .collect(Collectors.toList());
        sort.forEach(System.out::println);
    }


    public static  void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.readCarJson();
        List<Car> topTen = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(5)
                .collect(Collectors.toList());
        topTen.forEach(System.out::println);
    }
}

package examples;


import beans.Car;
import mockData.MockData;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    public static void filter() throws Exception {
        List<Car> cars = MockData.readCarJson();

        List<Car> carsLessThan20k = cars.stream()
                .filter(car -> car.getPrice() < 20_000.00)
                .filter(car -> car.getColor().equals("Yellow"))
                .filter(car -> car.getYear() > 1997)
                .collect(Collectors.toList());

        carsLessThan20k.forEach(System.out::println);
    }

    public static void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("using dropWhile");

        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

    }

    public static void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");

        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    public static void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n % 2 != 0)
                        .findFirst().orElse(-1);

        System.out.println();
        System.out.println("the result of find first: " + result);

    }

    public static void findAny() {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n == 9)
                .findAny()
                .orElse(-1);


        System.out.println();
        System.out.println("the result of find Any: " + result);

    }

    public static void allMatch() {

        int[] even = {2, 4, 7, 8, 10 };
        boolean allMatch = Arrays.stream(even).allMatch(n -> n % 2 == 0);

        System.out.println();
        System.out.println("the result of allMatch: " + allMatch);
    }

    public static void anyMatch()  {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean anyMatch = Arrays.stream(evenAndOneOdd).anyMatch(n -> !(n % 2 == 0));

        System.out.println();
        System.out.println("the result of anyMatch: " + anyMatch);
    }

}




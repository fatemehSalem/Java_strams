package examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SolvingQuestions {

    //Q1: Given an array of integers, write a function to return a new array containing only the even numbers
    // from the original array. Utilize Java Stream API to implement this.

    public static void giveEvenNumbers(){
        List<Integer> lst = Stream.of(10, 12, 15, 22, 17, 11).
                filter(num -> num % 2 == 0).toList();
        lst.forEach(System.out::println);
    }

    //Q2: Write a function to calculate the average of all the
    // elements in an integer array. Use Java Stream API to perform the summation and division.

    public static void calculateAverage(){
        Double result =  Stream.of(10, 12, 15, 22, 17, 11).mapToDouble(n->n).average().orElse(0);
        System.out.println(result);
    }

    //Q3: Implement a function that takes an integer n as input and returns a list of all prime numbers less than n.
    // Utilize Java Stream API to filter out the non-prime numbers efficiently.

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void primeNumber(int number){
        List<Integer> primeNumbers = IntStream.range(0, number)
                .filter(SolvingQuestions::isPrime)
                .boxed().toList();
        primeNumbers.forEach(System.out::println);
    }

    //Q4: Given a list of strings, group the strings by their length. Return a map where the keys are the lengths and
    // the values are lists of strings of that length. Use Java Stream API for grouping and mapping.

    public static void groupingByLength(){
      Map<Integer , List<String>> map = Stream.of("Sara" , "Ali" , "Fatemeh" , "Alex" , "John" , "Ben" , "Peter")
              .collect(Collectors.groupingBy(String::length, Collectors.toList()));
      map.forEach((s,lst) ->{
          System.out.println("Length : " + s);
          lst.forEach(System.out::println);
          System.out.println("_________________________");
      });
    }

    //Q5: Write a function to find the maximum element in an array of integers.
    // Utilize Java Stream API to find the maximum value.

    public static void findMaxNumber(){
        int[] myList = {1 , 2 , 8 , 11 , 3 , 22 , 12 , 10};
        int result = Arrays.stream(myList).max().orElse(0);
        System.out.println("result : " + result);
    }
}

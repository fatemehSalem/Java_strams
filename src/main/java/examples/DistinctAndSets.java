package examples;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctAndSets {
    public static void distinct()  {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> distinct = numbers.stream().distinct().toList();
        System.out.println("with distinct: " + distinct);
    }
    public static void distinctWithSet() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        Set<Integer> distinct = new HashSet<>(numbers);
        System.out.println("without distinct: " + distinct);
    }
}

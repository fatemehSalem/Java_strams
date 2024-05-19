package examples;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {
    public static void joiningStringsWithStream() {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");

        String join = names.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .collect(Collectors.joining("|"));

        System.out.println(join);

    }
}

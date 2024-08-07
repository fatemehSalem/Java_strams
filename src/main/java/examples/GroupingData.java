package examples;

import beans.Car;
import beans.Person;
import mockData.MockData;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingData {

    public static void simpleGrouping() throws Exception {
        Map<String, List<Car>> map = MockData.readCarJson()
                .stream()
                .filter(car -> car.getPrice() > 87991)
                .collect(Collectors.groupingBy(Car::getMake));
        map.forEach((s, cars) -> {
            System.out.println("Make " + s);
            cars.forEach(System.out::println);
            System.out.println("---------------------");
        });

    }

    public static void simpleGrouping2() throws IOException {
        List<Person> personList = MockData.readPeopleJson();
      Map<String , List<Person>>   map = personList.stream().limit(10).
              collect(Collectors.groupingBy(Person::getGender , Collectors.toList()));

      map.forEach((p , lst) ->{
          System.out.println("Gender is : " + p);
          lst.forEach(System.out::println);
          System.out.println("---------------------");
      });
    }

    public static  void groupingAndCounting(){
        List<String> names = List.of(
                "Zahra",
                "Fatemeh",
                "Zahra",
                "Ali",
                "Mohammad",
                "Mohammad",
                "Zahra",
                "Mahnaz",
                "Ali"
        );

       Map<String ,Long> map = names.stream()
               .collect(Collectors.groupingBy(name -> name , Collectors.counting()));

       System.out.println(map);

    }
}

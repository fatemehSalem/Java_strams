package examples;

import beans.Car;
import mockData.MockData;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    public static void minNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(min);
    }

    public static void maxNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer max = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);
    }

    public static void count() throws Exception {
        List<Car> cars = MockData.readCarJson();
        long count = cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Ford"))
                .filter(car -> car.getYear() > 2010)
                .count();
        System.out.println(count);
    }

    public static void min() throws Exception {
        List<Car> cars = MockData.readCarJson();
        Double min =  cars.stream().mapToDouble(Car::getPrice).min().orElse(0);
        System.out.println(min);
    }

    public void max() throws Exception {
        List<Car> cars = MockData.readCarJson();
        double max = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println(max);
    }

    public void average() throws Exception {
        List<Car> cars = MockData.readCarJson();
        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(average);
    }

    public void sum() throws Exception {
        List<Car> cars = MockData.readCarJson();
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        System.out.println(BigDecimal.valueOf(sum));
    }

    public void statistics() throws Exception {
        List<Car> cars = MockData.readCarJson();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(BigDecimal.valueOf(statistics.getSum()));
    }
}

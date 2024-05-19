package mockData;

import beans.Car;
import beans.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MockData {
    public static List<Person> readPeopleJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // converting Java objects to JSON and vice versa
        ClassLoader classLoader = MockData.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("people.json");

        if (inputStream == null) {
            throw new IOException("people.json not found in resources folder");
        }

        List<Person> people = mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
        inputStream.close();
        return people;
    }

    public static List<Car> readCarJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = MockData.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("cars.json");

        if (inputStream == null) {
            throw new IOException("cars.json not found in resources folder");
        }

        List<Car> cars = mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(List.class, Car.class));
        inputStream.close();
        return cars;
    }
}

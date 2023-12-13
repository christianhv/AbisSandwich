package be.abis.sandwich.test;

import be.abis.sandwich.model.Order;
import be.abis.sandwich.model.Person;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.Session;
import be.abis.sandwich.repository.FileSandwichRepository;
import be.abis.sandwich.repository.MemoryPersonRepository;
import be.abis.sandwich.repository.PersonRepository;
import be.abis.sandwich.repository.SandwichRepository;
import be.abis.sandwich.theenums.Course;
import be.abis.sandwich.theenums.SandwichType;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TestCreateOrders {
    public static void main(String[] args) throws IOException {

        SandwichRepository sr = new FileSandwichRepository();
        List<Sandwich> ss = sr.findAllSandwiches();
        ss.forEach(System.out::println);

        Sandwich s = sr.findSandwichByNameandType("BRIE", SandwichType.CHEESE);

        System.out.println("found sandwich is:" + s);

        PersonRepository pr = new MemoryPersonRepository();
        List<Person> allUsers = pr.findAllPersons();
        LocalDateTime now = LocalDateTime.now();
        Session sse = new Session(new now, Course.JAVA_ADV);

        Order ord = new Order(sse);


    }
}

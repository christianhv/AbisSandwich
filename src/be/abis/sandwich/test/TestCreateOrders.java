package be.abis.sandwich.test;

import be.abis.sandwich.exception.PersonNotFoundException;
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
import java.util.Comparator;
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

            sr.printMenu();

            List<Person> pp = pr.findAllPersons();
            pp.forEach(System.out::println);

        for (Person person : pp) {
            try {
            person.hasRole("OrderResponsible");
            } catch (PersonNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

//        System.out.println("  -----   ");
//
//               Person per = (Person) pp
//              .stream()
//              .filter(person -> person.getMail().equals("gindesteege@abis.be"))
//              .findFirst()
//              .stream().toList();
//
//        System.out.println("  -----   " + per);

//        try {
//            per.hasRole("PersonalOrder");
//        } catch (PersonNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        LocalDateTime now = LocalDateTime.now();
//        Session sse = new Session(now, Course.JAVA_ADV);

//        Order ord = new Order(sse);



    }
}

package be.abis.sandwich.test;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.exception.PersonalOrderNotFoundException;
import be.abis.sandwich.model.*;
import be.abis.sandwich.repository.FileSandwichRepository;
import be.abis.sandwich.repository.MemoryPersonRepository;
import be.abis.sandwich.repository.PersonRepository;
import be.abis.sandwich.repository.SandwichRepository;
import be.abis.sandwich.theenums.BreadType;
import be.abis.sandwich.theenums.Course;
import be.abis.sandwich.theenums.SandwichType;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TestCreateOrders {
    public static void main(String[] args) throws IOException, PersonalOrderNotFoundException {

        SandwichRepository sr = new FileSandwichRepository();
        List<Sandwich> ss = sr.findAllSandwiches();
        System.out.println("COMPLETE");
        ss.forEach(System.out::println);
        System.out.println("\n\n\n");

        Sandwich s = sr.findSandwichByNameandType("BRIE", SandwichType.CHEESE);

        System.out.println("found sandwich is:" + s);

        sr.removeSandwich(ss.get(0));
        System.out.println("REMOVED++++++");
        sr.findAllSandwiches().forEach(System.out::println);
        /*
        PersonRepository pr = new MemoryPersonRepository();
        List<Person> allPersons = pr.findAllPersons();

            sr.printMenu();

            List<Person> pp = pr.findAllPersons();
            pp.forEach(System.out::println);

        for (Person person: pp) {
            if (person.hasRole("Order Responsible")){
                System.out.println("Name: " + person.getFirstName() + " has Order Responsible rol");
            }
        }
        Session session = new Session(LocalDateTime.now(), Course.JAVA_ADV);
        Order order = new Order(session);
        PersonalOrder Ord1 = new PersonalOrder(ss.get(0),Boolean.FALSE, BreadType.GRAY,allPersons.get(0));
        PersonalOrder Ord2 = new PersonalOrder(ss.get(0),Boolean.TRUE, BreadType.WHITE,allPersons.get(0));
        PersonalOrder Ord3 = new PersonalOrder(ss.get(0),Boolean.FALSE, BreadType.GRAY,allPersons.get(0));

        order.addPersonalOrder(Ord1);
        order.addPersonalOrder(Ord2);
        order.addPersonalOrder(Ord3);

         */




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

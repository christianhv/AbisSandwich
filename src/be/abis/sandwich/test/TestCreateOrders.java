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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCreateOrders {
    public static void main(String[] args) throws IOException {

        SandwichRepository sr = new FileSandwichRepository();
        //List<Sandwich> ss = sr.findAllSandwiches();


        Sandwich s = sr.findSandwichByNameandType("BRIE", SandwichType.CHEESE);

        System.out.println("\nfound sandwich is:" + s);

        PersonRepository pr = new MemoryPersonRepository();
        List<Person> allUsers = pr.findAllPersons();

        sr.printMenu();

        List<Person> pp = pr.findAllPersons();

        System.out.println("  -----   ");

               pp
              .stream()
              .filter(person -> person.getMail().equals("gindesteege@abis.be"))
              .findFirst().ifPresent(System.out::println);


    }
}

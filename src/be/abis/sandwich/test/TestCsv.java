package be.abis.sandwich.test;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.exception.RoleModificationException;
import be.abis.sandwich.model.CSVReaderTest;
import be.abis.sandwich.model.Person;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.repository.FileSandwichRepository;
import be.abis.sandwich.repository.MemoryPersonRepository;
import be.abis.sandwich.repository.PersonRepository;
import be.abis.sandwich.repository.SandwichRepository;
import be.abis.sandwich.theenums.SandwichType;

import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ofLocalizedDateTime;

public class TestCsv {

    public static void main(String[] args) throws IOException, PersonNotFoundException {

        String csvFile = "src/be/abis/sandwich/util/orderOf2023-12-19___13-06.txt";
        CSVReaderTest.read(csvFile);

//        PersonRepository pr = new MemoryPersonRepository();
//        List<Person> allUsers = pr.findAllPersons();
//        Person p = allUsers
//                .stream()
//                .filter(person -> person.getMail().equals("gindesteege@abis.be"))
//                .findFirst()
//                .stream().toList().get(0);
//
//        System.out.println("persone has role ? : " + p.hasRole("Order Responsible"));
//
//        SandwichRepository sr1 = new FileSandwichRepository();
//        List<Sandwich> ss1 = sr1.findAllSandwiches();
//
//        Sandwich s = ss1.get(0);
//        System.out.println(" TEST  "+ s);
//
//        try {
//            sr1.removeSandwich(ss1.get(0),p);
//        } catch (RoleModificationException e) {
//            throw new RuntimeException(e);
//        }
//
    }

}

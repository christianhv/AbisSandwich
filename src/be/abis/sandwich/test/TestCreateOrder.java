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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCreateOrder {

    public static void main(String[] args) {


        System.out.printf("\n");
        System.out.printf("%90s\n", "pick up your sandwich from the menu below : \n \n");


        SandwichRepository sr = null;
        try {
            sr = new FileSandwichRepository();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            sr.printMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.printf("\n");
        System.out.printf("\n \n");


        PersonRepository pr = new MemoryPersonRepository();
        List<Person> pp = pr.findAllPersons();

        List<Person> ppp = pp.stream()
                .filter(p -> p.getSession().getCourse().equals(Course.OOP))
                .collect(Collectors.toList());

//        Person inst1 = new Person("Sandy", "Schillebeeckx", "sschillebeeckx@abis.be", new Session(Course.OOP));
//        Person inst2 = new Person("Koen", "De Backer", "kdebacker@abis.be", new Session(Course.JAVA_PROGRAMMING));
//        Person inst3 = new Person("Emely", "Dubois", "gindesteege@abis.be", new Session(Course.JAVA_ADV), new OrderResponsible());

//        PersonalOrder prdr = new PersonalOrder(new Sandwich(SandwichType.CHEESE, "BRIE DELUXE", 5.5, "Broodje met brie, sla, walnut en honing"), true, BreadType.GRAY,inst1 );
//        PersonalOrder prdr1 = new PersonalOrder(new Sandwich(SandwichType.MEAT, "HAM", 3.95, "Broodje met ham en boter"), true, BreadType.GRAY,inst2);
//        PersonalOrder prdr2 = new PersonalOrder(new Sandwich(SandwichType.CHEESE, "GEZOND HAM", 4.95, "GEZOND HAM"), true, BreadType.GRAY,inst3 );
//        ArrayList<PersonalOrder> orderlist = new ArrayList<>(Arrays.asList(new PersonalOrder[]{prdr, prdr1, prdr2}));

        PersonalOrder prdr = new PersonalOrder(new Sandwich(SandwichType.CHEESE, "BRIE DELUXE", 5.5, "Broodje met brie, sla, walnut en honing"), true, BreadType.GRAY, (Person) ppp.stream().filter(person -> person.getMail().equals("sschillebeeckx@abis.be")).findFirst().get());
        PersonalOrder prdr1 = new PersonalOrder(new Sandwich(SandwichType.MEAT, "HAM", 3.95, "Broodje met ham en boter"), true, BreadType.GRAY, (Person) ppp.stream().filter(person -> person.getMail().equals("bob.miles@ibm.com")).findFirst().get());
        PersonalOrder prdr2 = new PersonalOrder(new Sandwich(SandwichType.CHEESE, "GEZOND HAM", 4.95, "GEZOND HAM"), true, BreadType.GRAY, (Person) ppp.stream().filter(person -> person.getMail().equals("jefke@yahoo.com")).findFirst().get());
        PersonalOrder prdr3 = new PersonalOrder(new Sandwich(SandwichType.FISH, "TONIJNTINO", 9.6, "Broodje met tonijnsalade, martinosaus, augurk en rauwe uitjes"), true, BreadType.GRAY, (Person) ppp.stream().filter(person -> person.getMail().equals("Sara@gmail.be")).findFirst().get());
        PersonalOrder prdr4 = new PersonalOrder(new Sandwich(SandwichType.CHICKEN, "SMOSKE KIP HAWAII", 7.2, "Broodje met gerafelde kip, ananas, sla, tomaat, ei en cocktailsaus"), true, BreadType.GRAY, (Person) ppp.stream().filter(person -> person.getMail().equals("Sanny@gmail.be")).findFirst().get());
        PersonalOrder prdr5 = new PersonalOrder(new Sandwich(SandwichType.CHICKEN, "SMOSKE KIP HAWAII", 7.2, "Broodje met gerafelde kip, ananas, sla, tomaat, ei en cocktailsaus"), true, BreadType.GRAY, (Person) ppp.stream().filter(person -> person.getMail().equals("Karine@gmail.be")).findFirst().get());
        PersonalOrder prdr6 = new PersonalOrder(new Sandwich(SandwichType.CHICKEN, "SMOSKE KIP HAWAII", 7.2, "Broodje met gerafelde kip, ananas, sla, tomaat, ei en cocktailsaus"), true, BreadType.GRAY, (Person) ppp.stream().filter(person -> person.getMail().equals("Karine@gmail.be")).findFirst().get());
        ArrayList<PersonalOrder> orderlist = new ArrayList<>(Arrays.asList(new PersonalOrder[]{prdr, prdr1, prdr2, prdr3, prdr4, prdr5, prdr6}));
        // to be tested with 3 sandwiches for one person
        //PersonalOrder prdr7 = new PersonalOrder(new Sandwich(SandwichType.CHICKEN, "SMOSKE KIP HAWAII", 7.2, "Broodje met gerafelde kip, ananas, sla, tomaat, ei en cocktailsaus"), true, BreadType.GRAY, (Person) ppp.stream().filter(person -> person.getMail().equals("Karine@gmail.be")).findFirst().get());
        //ArrayList<PersonalOrder> orderlist = new ArrayList<>(Arrays.asList(new PersonalOrder[]{prdr, prdr1, prdr2, prdr3, prdr4, prdr5,prdr6,prdr7}));
        Person ordrRes = new Person("Emely", "Dubois","gindesteege@abis.be",new Session(Course.JAVA_ADV ),new OrderResponsible());

        Order rdr = new Order();
        for (PersonalOrder po : orderlist) {
            try {
                rdr.addPersonalOrder(po,ordrRes);
            } catch (PersonNotFoundException | PersonalOrderNotFoundException e ) {
                throw new RuntimeException(e);
            }
        }




//
//        try {
//            rdr.addPersonalOrder(po,ordrRes);
//        } catch (PersonalOrderNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (PersonNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }


        rdr.printOrder();


    }

}

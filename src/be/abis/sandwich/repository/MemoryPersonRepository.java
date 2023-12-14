package be.abis.sandwich.repository;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryPersonRepository implements PersonRepository {

    private List<Person> persons = new ArrayList<Person>();

    public MemoryPersonRepository()  {

        Person inst1 = new Person("Sandy", "Schillebeeckx","sschillebeeckx@abis.be",new Instructor(),new Accountant());
        Person inst2 = new Person("Koen", "De Backer","kdebacker@abis.be",new Instructor(),new Manager(),new Accountant());
        Person inst3 = new Person("Emely", "Dubois","gindesteege@abis.be",new OrderResponsible());
        Person inst4 = new Person("Bart", "Lemarcq","blemarcq@abis.be",new Instructor());
        Person p1 = new Person("Michel","Dupont","michel.dupont@bnpparibasfortis.com",new Instructor());
        Person p2 = new Person("Anne","Van der Meulen","anne.vandermeulen@bnpparibasfortis.com",new Instructor());
        Person p3 = new Person("Bob","Miles","bob.miles@ibm.com",new Instructor());
        Person p4 = new Person("Willem-Alexander","Janssen","willemalexander.janssen@klm.nl",new Instructor());
        Person p5 = new Person("Jef","Smits","jefke@yahoo.com",new Instructor());

        persons.addAll(Arrays.asList(new Person[]{inst1,inst2,inst3,inst4,p1,p2,p3,p4,p5}));
    }


    @Override
    public List<Person> findAllPersons() {
        return persons;
    }

    @Override
    public String findPersonByEmail(String email) throws PersonNotFoundException {
        String mail = String.valueOf(persons
                .stream()
                .filter(person -> person.getMail().equals(email))
                .findFirst()
                .stream().toList().get(0));


        return mail;
    }

    @Override
    public void addPerson(Person p) {

    }
}

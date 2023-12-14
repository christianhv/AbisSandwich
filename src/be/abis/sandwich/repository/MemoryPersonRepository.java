package be.abis.sandwich.repository;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryPersonRepository implements PersonRepository{
    private List<Person> persons = new ArrayList<Person>();
    public MemoryPersonRepository() {

        Person inst1 = new Person("Sandy", "Schillebeeckx", "sschillebeeckx@abis.be", new Instructor(), new Accountant());
        Person inst2 = new Person("Koen", "De Backer","kdebacker@abis.be",new Instructor(), new OrderResponsible());
        Person inst3 = new Person("Gie", "Indesteege","gindesteege@abis.be",new Instructor(),new Manager());
        Person inst4 = new Person("Bart", "Lemarcq","blemarcq@abis.be",new Instructor());
        Person p1 = new Person("Michel","Dupont","michel.dupont@bnpparibasfortis.com");
        Person p2 = new Person("Anne","Van der Meulen","anne.vandermeulen@bnpparibasfortis.com");
        Person p3 = new Person("Bob","Miles","bob.miles@ibm.com");
        Person p4 = new Person("Willem-Alexander","Janssen","willemalexander.janssen@klm.nl");
        Person p5 = new Person("Jef","Smits","jefke@yahoo.com");

        persons.addAll(Arrays.asList(new Person[]{inst1,inst2,inst3,inst4,p1,p2,p3,p4,p5}));


    }

    @Override
    public List<Person> findAllPersons() {
        return persons;
    }

    @Override
    public Person findPersonByEmail(String email, String password) throws PersonNotFoundException {
        Person person = this.persons
                .stream()
                .filter(person1 -> person1.getMail().equals(email))
                .findFirst().get();

        return null;
    }

    @Override
    public void addPerson(Person p) {
        persons.add(p);
    }
}

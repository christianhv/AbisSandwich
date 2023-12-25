package be.abis.sandwich.test;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.model.Manager;
import be.abis.sandwich.model.Person;
import be.abis.sandwich.model.Role;
import be.abis.sandwich.repository.MemoryPersonRepository;
import be.abis.sandwich.repository.PersonRepository;
import be.abis.sandwich.theenums.Course;

import java.util.List;

public class TestPerson {
    public static void main(String[] args) throws PersonNotFoundException {
        PersonRepository pr = new MemoryPersonRepository();

        List<Person> ps = pr.findAllPersons();

        for (Person p: ps){
            System.out.println(" "+ p.getMail());
        }

        ps.get(0).addRole(new Manager());

        Role r = ps.get(0).findRole("Manager");

        System.out.println(r.getType());
        System.out.println(ps.get(9).hasRole("Manager"));



    }
}

package be.abis.sandwich.repository;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> findAllPersons();
    //Person findPersonById(int id) throws PersonNotFoundException;
    String findPersonByEmail(String email) throws PersonNotFoundException;
    void addPerson(Person p);
}

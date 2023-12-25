package be.abis.sandwich.repository;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.exception.PersonalOrderNotFoundException;
import be.abis.sandwich.exception.RoleModificationException;
import be.abis.sandwich.model.Person;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.theenums.SandwichType;

import java.io.IOException;
import java.util.List;

public interface SandwichRepository {
    void removeSandwich(Sandwich sandwich, Person p) throws PersonNotFoundException, RoleModificationException, IOException;
     void addSandwich(Sandwich sandwich, Person p) throws PersonNotFoundException, RoleModificationException;

    String formatSandwich(Sandwich sandwich);
    List<Sandwich> findAllSandwiches();
    Sandwich findSandwichByName(String name);
    Sandwich findSandwichByNameandType(String name, SandwichType type);
    void printMenu() throws IOException;
}

package be.abis.sandwich.repository;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.theenums.SandwichType;

import java.util.List;

public interface SandwichRepository {
    void removeSandwich(Sandwich sandwich);
    void addSandwich(Sandwich sandwich);
    List<Sandwich> findAllSandwiches();
    Sandwich findSandwichByName(String name);
    Sandwich findSandwichByNameandType(String name, SandwichType type);
}

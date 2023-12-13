package be.abis.sandwich.repository;

import be.abis.sandwich.model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public interface SandwichRepository {
    void removeSandwich(Sandwich sandwich);
    void addSandwich(Sandwich sandwich);
    List<Sandwich> findAllSandwiches();
    Sandwich findSanwichbyName(Sandwich sandwich);
}

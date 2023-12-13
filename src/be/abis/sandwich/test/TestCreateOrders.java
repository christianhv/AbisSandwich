package be.abis.sandwich.test;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.repository.FileSandwichRepository;
import be.abis.sandwich.repository.SandwichRepository;
import be.abis.sandwich.theenums.SandwichType;

import java.io.IOException;
import java.util.List;

public class TestCreateOrders {
    public static void main(String[] args) throws IOException {

        SandwichRepository sr = new FileSandwichRepository();
        List<Sandwich> ss = sr.findAllSandwiches();
        ss.forEach(System.out::println);

        Sandwich s = sr.findSandwichByNameandType("BRIE", SandwichType.CHEESE);

        System.out.println("found sandwich is:" + s);


    }
}

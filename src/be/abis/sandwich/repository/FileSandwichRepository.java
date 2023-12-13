package be.abis.sandwich.repository;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.theenums.SandwichType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSandwichRepository implements SandwichRepository{
    private List<Sandwich> sandwiches = new ArrayList<Sandwich>();
    private String filePath = "/Users/Duser/IdeaProjects/AbisSandwich/src/be/abis/sandwich/util/sandwiches.csv";

    public FileSandwichRepository()  throws IOException {
       sandwiches = Files.lines(Paths.get(this.filePath))
                .map(line->this.parseSandwiches(line)).toList();
    }

    @Override
    public void removeSandwich(Sandwich sandwich) {

    }

    @Override
    public void addSandwich(Sandwich sandwich) {

    }

    @Override
    public List<Sandwich> findAllSandwiches() {
        return sandwiches;
    }

    @Override
    public Sandwich findSanwichbyName(Sandwich sandwich) {
        return null;
    }

    private Sandwich parseSandwiches(String s){
        String[] cells = s.split(";");
        //System.out.println(cells[0]);
        SandwichType type = SandwichType.valueOf(cells[0]);
        String name = cells[1];
        Double price = Double.parseDouble(cells[2]);
        String description = cells[3];

        Sandwich sandwich = new Sandwich(name, type, price, description);
        return sandwich;
    }
}

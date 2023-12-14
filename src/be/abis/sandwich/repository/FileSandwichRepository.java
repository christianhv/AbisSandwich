package be.abis.sandwich.repository;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.exception.PersonalOrderNotFoundException;
import be.abis.sandwich.exception.RoleModificationException;
import be.abis.sandwich.model.Person;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.theenums.SandwichType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class FileSandwichRepository implements SandwichRepository{
    private List<Sandwich> sandwiches = new ArrayList<Sandwich>();
    private Person person;
    //private String filePath = "/Users/Duser/IdeaProjects/AbisSandwich/src/be/abis/sandwich/util/sandwiches.csv";
    private String filePath = "src/be/abis/sandwich/util/sandwiches.csv";
    private String filePathRem = "src/be/abis/sandwich/util/sandwiches_withRemoved.csv";
    public FileSandwichRepository()  throws IOException {
        this.sandwiches = Files.lines(Paths.get(this.filePath))
                .map(line->this.parseSandwiches(line)).toList()
                .stream().collect(toCollection(ArrayList::new));
    }
    @Override
    public void removeSandwich(Sandwich sandwich) {
        //Sandwich s = this.findSandwichByNameandType(sandwich.getName(), sandwich.getSandwichType());
        this.sandwiches.removeIf(s-> s.getName().equals(sandwich.getName()));

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePathRem), Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            //bw.write(this.formatSandwich(sandwich)+"\n");
            this.sandwiches.forEach(sandwich1 -> {
                try {
                    bw.write(this.formatSandwich(sandwich1));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void addSandwich(Sandwich sandwich, Person p) throws PersonNotFoundException, RoleModificationException {

        if(p.hasRole("OrderResponsible")){

            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath), Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
                bw.write(this.formatSandwich(sandwich)+"\n");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }else {

            throw new RoleModificationException(" No personal order found in the list ");
        }

    }

    @Override
    public String formatSandwich(Sandwich sandwich) {
        StringBuilder sb = new StringBuilder("");
        sb.append(sandwich.getSandwichType()).append(";")
                .append(sandwich.getName()).append(";")
                .append(sandwich.getPricePerUnit()).append(";")
                .append(sandwich.getDescription());
        return sb.toString();
    }

    @Override
    public List<Sandwich> findAllSandwiches() {
        return sandwiches;
    }

    @Override
    public Sandwich findSandwichByName(String name) {
        Sandwich s = (Sandwich) sandwiches
                .stream()
                .filter(sandwich -> sandwich.getName().equals(name))
                .toList();

        return null;
    }

    @Override
    public Sandwich findSandwichByNameandType(String name, SandwichType type) {
        Sandwich sandwich = sandwiches
                .stream()
                .filter(sandwich1 -> sandwich1.getName().equals(name))
                .filter(sandwich1 -> sandwich1.getSandwichType().equals(type))
                .findFirst()
                .stream().toList().get(0);

        return sandwich;
    }

    @Override
    public void printMenu() throws IOException {
        String overview = "overview";
        String Type = "Type";
        String Sandwiches = "Sandwiche";
        String Price = "Price";
        String Description = "Description";
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%55s\n", overview);
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%-25s %-25s %-25s %-25s \n", Type,Sandwiches,Price,Description);
        System.out.println("-------------------------------------------------------------------------------------------------");
        SandwichRepository sr = new FileSandwichRepository();
        List<Sandwich> ss = sr.findAllSandwiches();
        ss.forEach(sandwich -> System.out.printf("%-25s %-25s %-25s %-25s \n",sandwich.getSandwichType(), sandwich.getName() , sandwich.getPricePerUnit(),sandwich.getDescription()));
    }

    private Sandwich parseSandwiches(String s){
        String[] cells = s.split(";");
        SandwichType type = SandwichType.valueOf(cells[0]);
        String name = cells[1];
        Double price = Double.parseDouble(cells[2]);
        String description = cells[3];
        Sandwich sandwich = new Sandwich(type,name, price, description);
        return sandwich;
    }
}

package be.abis.sandwich.model;

public class Manager implements Role{

    public Manager() {
    }

    @Override
    public String getType() {
        return "Manager";
    }

    @Override
    public void doJob() {
        System.out.println("Create Statistics");
    }
}

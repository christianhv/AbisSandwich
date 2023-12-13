package be.abis.sandwich.model;

public class Manager implements Role{

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void doJob() {
        System.out.println("Create Statistics");
    }
}

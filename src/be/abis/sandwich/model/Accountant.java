package be.abis.sandwich.model;

public class Accountant implements Role{
    @Override
    public String getType() {
        return "manager";
    }

    @Override
    public void doJob() {

    }
}

package be.abis.sandwich.model;

public class Instructor implements Role{
    @Override
    public String getType() {
        return "Instructor";
    }

    @Override
    public void doJob() {
        System.out.println("Give lessons");
    }
}

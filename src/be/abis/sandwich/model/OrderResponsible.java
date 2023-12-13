package be.abis.sandwich.model;

public class OrderResponsible implements Role{
    @Override
    public String getType() {
        return "Order Responsible";
    }

    @Override
    public void doJob() {
        System.out.println("Create, close and send orders");

    }
}

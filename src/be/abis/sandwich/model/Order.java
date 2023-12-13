package be.abis.sandwich.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    ArrayList<PersonalOrder> listOfPersonalOrders;
    Session session;
    Date date;

    public Order(Session session) {
        this.session = session;
        listOfPersonalOrders= new ArrayList<PersonalOrder>();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addPersonalOrder(PersonalOrder pOrder){
        //we need to check if person already exist twice
        long inList = this.listOfPersonalOrders
                .stream()
                .filter(personalOrder -> personalOrder.getOrderOwner().getMail().equals(pOrder.getOrderOwner().getMail())).count();

        if (inList<2) {
            this.listOfPersonalOrders.add(pOrder);
        }
        else{
            System.out.println("Throw exception here, you can't order more than 2 sandwiches");
        }
    }

    public Double calculateTotalPrice(){
        Double totalPrice=0.0;
        //need to calculate totalPrice
        return totalPrice;
    }

    public int getNumberOfSandwiches(){
        return listOfPersonalOrders.size();
    }
}

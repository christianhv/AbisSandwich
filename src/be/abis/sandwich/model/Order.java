package be.abis.sandwich.model;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.exception.PersonalOrderNotFoundException;

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

    public void addPersonalOrder(PersonalOrder pOrder) throws PersonalOrderNotFoundException {
        //we need to check if person already exist twice
        long inList = this.listOfPersonalOrders
                .stream()
                .filter(personalOrder -> personalOrder.getOrderOwner().getMail().equals(pOrder.getOrderOwner().getMail())).count();

        if (inList<2) {
            this.listOfPersonalOrders.add(pOrder);
            System.out.println("Order added!");
        }
        else{
            throw new PersonalOrderNotFoundException("2 orders Already added!");
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

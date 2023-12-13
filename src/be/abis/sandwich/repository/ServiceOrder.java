package be.abis.sandwich.repository;

import be.abis.sandwich.model.Order;
import be.abis.sandwich.model.Session;

public class ServiceOrder {

    public Order createOrder(Session session){
        Order order = new Order(session);
        return order;
    }

    public void closeOrder(){

    }

    public void sendOrder(){}



}

package be.abis.sandwich.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    ArrayList<PersonalOrder> listOfPersonalOrders= new ArrayList<PersonalOrder>();
    Session session;
    Date date;
}

package be.abis.sandwich.model;

import be.abis.sandwich.exception.PersonNotFoundException;
import be.abis.sandwich.exception.PersonalOrderNotFoundException;
import be.abis.sandwich.exception.RoleModificationException;
import be.abis.sandwich.repository.ServiceOrder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Order {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd___HH-mm");
    private LocalDateTime now = LocalDateTime.now();
    private File filePath = new File("src/be/abis/sandwich/util/history/orderOf"+ dtf.format(now)+".txt");

    LocalDate currentdate = LocalDate.now();
    int currentDay = currentdate.getDayOfMonth();
    private File filePathHreport = new File("src/be/abis/sandwich/util/history/reportOrder_"+currentDay+"_OftheMonth.txt");

    private ArrayList<PersonalOrder> listOfPersonalOrders = new ArrayList<>();

    private LocalDateTime date;

    public Order() {
    }



    public Order(LocalDateTime date) {
        this.listOfPersonalOrders = listOfPersonalOrders;
        this.date = date;
    }
    //    Session session;
//    public Order(Session session) {
//        this.session = session;
//        listOfPersonalOrders= new ArrayList<PersonalOrder>();
//    }

//    public Session getSession() {
//        return session;
//    }
//
//    public void setSession(Session session) {
//        this.session = session;
//    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void addPersonalOrder(PersonalOrder pOrder,  Person p) throws PersonalOrderNotFoundException, PersonNotFoundException {


        long inList = this.listOfPersonalOrders
                .stream()
                .filter(personalOrder -> personalOrder.getOrderOwner().getMail().equals(pOrder.getOrderOwner().getMail())).count();

        if (inList<2 && p.hasRole("Order Responsible")) {
            this.listOfPersonalOrders.add(pOrder);
            try {
                this.addOrderToHistory(pOrder,p);
            } catch (RoleModificationException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            throw new PersonalOrderNotFoundException(" Cannot order then two sandwiches ");
        }
    }


    public void addOrderToHistory(PersonalOrder pOrder, Person p) throws RoleModificationException {

        try {
            ServiceOrder.cleanUpOldfiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if(p.hasRole("Order Responsible")){

                try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePathHreport.toURI()), Charset.forName("UTF-8"),StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                    bw.write(this.formatOrder(pOrder)+"\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }else {

                throw new RoleModificationException(" No personal order found in the list ");
            }
        } catch (PersonNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public String formatOrder(PersonalOrder pOrder) {
        StringBuilder sb = new StringBuilder("");
        sb.append(pOrder.getSandwich().getSandwichType()).append(";")
                .append(pOrder.getSandwich().getName()).append(";")
                .append(pOrder.getSandwich().getPricePerUnit()).append(";")
                .append(pOrder.getSandwich().getDescription()).append(";")
                .append(pOrder.getOrderOwner().getMail());
        return sb.toString();
    }

    public void printOrder(){
        String overview = "overview of the order";
        String Type = "Type";
        String Sandwiches = "Sandwiche";
        String Price = "Price";
        String Mail = "mail";
        String Session = "session";
        String NumberOfSandwich = "NumberOfSandwich";
        String TotalPrice = "TotalPrice";
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%75s\n", overview);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-25s %-25s %-25s %-25s %-25s\n", Type,Sandwiches,Price,Mail,Session);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------\n");
        this.listOfPersonalOrders
                .forEach(po -> System.out.printf("%-25s %-25s %-25s %-25s %-25s\n", po.getSandwich().getSandwichType(),po.getSandwich().getName(),po.getSandwich().getPricePerUnit(),
                po.getOrderOwner().getMail(), po.getOrderOwner().getSession()));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s\n", NumberOfSandwich + " : "  + this.getNumberOfSandwiches());
        System.out.printf("%10s\n", TotalPrice + " : "  + this.calculateTotalPrice());
    }

    public Double calculateTotalPrice(){
        Double totalPrice=listOfPersonalOrders
                .stream()
                .mapToDouble(t -> t.getSandwich().getPricePerUnit())
                .sum();
        return totalPrice;
    }

    public int getNumberOfSandwiches(){
        return listOfPersonalOrders.size();
    }





















    /*
    *
    *
    *
    *
    *
    * */















}

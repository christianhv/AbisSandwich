package be.abis.sandwich.repository;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ServiceOrder implements ServiceOrderInterface{

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDateTime now = LocalDateTime.now();
    private File filePath = new File("src/be/abis/sandwich/util/orderOf"+ dtf.format(now)+".txt");
    private File filePathMonthlyHreport = new File("src/be/abis/sandwich/util/history/reportOrderOf"+ dtf.format(now)+".txt");
    //private File filePathHreport = new File("src/be/abis/sandwich/util/orderOf2023-12-22___18-53.txt");

    LocalDate currentdate = LocalDate.now();
    int currentDay = currentdate.getDayOfMonth();
    private File filePathHreport = new File("src/be/abis/sandwich/util/history/reportOrder_"+currentDay+"_OftheMonth.txt");

    private List<ServiceOrder> listOfOrdersInfiles = new ArrayList<>();
    private String sandwichType;

    private String sandwichName;

    private double priceUnits;

    private String description;
    private String personaleOrderOwner;



    public void closeOrder(){

    }

    public void sendOrder(){}

    public ServiceOrder( String sandwichType, String sandwichName, double priceUnits, String description,String personaleOrderOwner) {

        this.sandwichType = sandwichType;
        this.sandwichName = sandwichName;
        this.priceUnits = priceUnits;
        this.description = description;
        this.personaleOrderOwner = personaleOrderOwner;
    }

    public ServiceOrder()  throws IOException {
        listOfOrdersInfiles = Files.lines(Paths.get(this.filePathHreport.toURI()))
                .map(line->this.parsePersonalOrderHistory(line)).toList()
                .stream().toList();

    }

    public String getSandwichType() {
        return sandwichType;
    }


    public String getSandwichName() {
        return sandwichName;
    }

    public double getPriceUnits() {
        return priceUnits;
    }

    public String getPersonaleOrderOwner() {
        return personaleOrderOwner;
    }

    private ServiceOrder parsePersonalOrderHistory(String s){
        String[] cells = s.split(";");
//        String sandwichType = String.valueOf(SandwichType.valueOf(cells[0]));
        this.sandwichType = cells[0];
        this.sandwichName = cells[1];
        this.priceUnits = Double.parseDouble(cells[2]);
        this.description = cells[3];
        this.personaleOrderOwner = cells[4];
        return new ServiceOrder(sandwichType,sandwichName, priceUnits, description,personaleOrderOwner);
    }

    @Override
    public List<ServiceOrder> findAllSandwiches() {
        return listOfOrdersInfiles;
    }


    public static void cleanUpOldfiles() throws IOException {

        File f=new File("src/be/abis/sandwich/util/history");
        String list[]=f.list();
        Calendar lCal = Calendar.getInstance(); // initializes with today
        lCal.add(Calendar.DATE, -2); // Captures a date which is 10 days before today
        for (String s : list) {
            File tmpFile = new File("src/be/abis/sandwich/util/history/" + s);
            System.out.println(tmpFile);
            Date date = new Date(tmpFile.lastModified());
            if (date.before(lCal.getTime())) {
                Files.deleteIfExists(tmpFile.toPath());
            }
        }

    }
    public List<String> printFileNames(List<String> a)throws IOException
    {
        File f = new File("src/be/abis/sandwich/util/history/");
        if(f.exists() && f.isDirectory()){
            a = List.of(f.list());
        }else throw new IOException(" History folder not found ");

        return a;
    }


    public void test (){


        List<ServiceOrder> ls = new ArrayList<>();
        try {
            ls = Files.lines(Paths.get("src/be/abis/sandwich/util/history/reportOrderOf2023-12-25.txt"))
                    .map(line->this.parsePersonalOrderHistory(line)).toList()
                    .stream().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        System.out.println("  Here is the statistics of the orders by type : " );
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");


        Map<String, Long> reportOfOrders = ls.stream()
                .collect(Collectors.groupingBy(ServiceOrder::getSandwichName,TreeMap::new,Collectors.counting()));
        reportOfOrders.forEach((sandwichName,count)-> System.out.format("%s : %s\n",sandwichName,count));


        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePathMonthlyHreport.toURI()), Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
            bw.write("\n------------------------- Here is the statistics of the orders by type : --------------------------\n" );

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        for (Map.Entry<String, Long> entry :
                reportOfOrders.entrySet()) {

            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePathMonthlyHreport.toURI()), Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
                bw.write( entry.getKey() + ":"
                        + entry.getValue());
                bw.newLine();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        double totalPrice=ls
                .stream()
                .mapToDouble(t -> t.priceUnits)
                .sum();
        double price = 0;
        price = totalPrice+ price;

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePathMonthlyHreport.toURI()), Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
            bw.write("\n ---------------------------The total orders cost of this month is :-------------------------------\n\n" + (price) + " euro \n");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public  void createMonthlyReportOrder() throws IOException {


        String path = String.valueOf(this.filePathMonthlyHreport);
        System.out.println(path);

            try {
                boolean result =
                Files.deleteIfExists(Path.of(path));
                if (result)
                    System.out.println("File is deleted");
                else
                    System.out.println("File does not exists");

            } catch (IOException e) {
                e.printStackTrace();
            }

        this.createMonthlyReportOrderFile();
    }
    public  void createMonthlyReportOrderFile()throws IOException{
        double price = 0;
        List <String> lst = new ArrayList<>();
        List<ServiceOrder> ls = new ArrayList<>();
        File f = new File("src/be/abis/sandwich/util/history/");
        if(f.exists() && f.isDirectory()){
            lst = List.of(f.list());
        }else throw new IOException(" History folder not found ");

        for (String s : lst) {
            File tmpFile = new File("src/be/abis/sandwich/util/history/" + s);

            ls = Files.lines(Paths.get(tmpFile.toURI()))
                    .map(line->this.parsePersonalOrderHistory(line)).toList()
                    .stream().toList();

            for (ServiceOrder l : ls){

            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePathMonthlyHreport.toURI()), Charset.forName("UTF-8"),StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                bw.write(this.formatOrder(l)+"\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

            double totalPrice=ls
                    .stream()
                    .mapToDouble(t -> t.priceUnits)
                    .sum();
            price = totalPrice+price;

///////////////////////////////////////////////////////////////////////
//            Map<String, Long> reportOfOrders = ls.stream()
//                    .collect(Collectors.groupingBy(ServiceOrder::getSandwichName,TreeMap::new,Collectors.counting()));
//            reportOfOrders.forEach((sandwichName,count)-> System.out.format("%s : %s\n",sandwichName,count));
//
//            for (Map.Entry<String, Long> entry :
//                    reportOfOrders.entrySet()) {
//
//                try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePathMonthlyHreport.toURI()), Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
//                    bw.write(entry.getKey() + ":"
//                            + entry.getValue());
//                    bw.newLine();
//
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                }
//            }

//////////////////////////////////////////////////

            }

//        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePathMonthlyHreport.toURI()), Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
//            bw.write("The total orders cost of this month is :" + (price) + "\n");
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

    }

    public String formatOrder(ServiceOrder lst) {
        StringBuilder sb = new StringBuilder("");

            sb.append(lst.getSandwichType()).append(";")
                    .append(lst.getSandwichName()).append(";")
                    .append(lst.getPriceUnits()).append(";")
                    .append(lst.description).append(";")
                    .append(lst.getPersonaleOrderOwner());

        return sb.toString();
    }
public void getHistoryTotalPrice(){
        List<ServiceOrder> mylist = new ArrayList<>();
    try {
        this.createMonthlyReportOrder();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    Double totalPrice=mylist
            .stream()
            .mapToDouble(t -> t.priceUnits)
            .sum();
}



    @Override
    public String toString() {
        return "ServiceOrder{" +
                "sandwichType='" + sandwichType + '\'' +
                ", sandwichName='" + sandwichName + '\'' +
                ", priceUnits=" + priceUnits +
                ", description='" + description + '\'' +
                ", personaleOrderOwner='" + personaleOrderOwner + '\'' +
                '}';
    }
}

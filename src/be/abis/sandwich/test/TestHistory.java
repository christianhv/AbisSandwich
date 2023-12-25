package be.abis.sandwich.test;

import be.abis.sandwich.model.Person;
import be.abis.sandwich.model.PersonalOrder;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.repository.MemoryPersonRepository;
import be.abis.sandwich.repository.PersonRepository;
import be.abis.sandwich.repository.ServiceOrder;
import be.abis.sandwich.repository.ServiceOrderInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class TestHistory {

    static int getLastDayOfMonthUsingYearMonth(YearMonth date) {
        return date.atEndOfMonth()
                .getDayOfMonth();
    }


    static int getLastDayOfMonthUsingTemporalAdjusters(LocalDate date) {
        return date.with(TemporalAdjusters.lastDayOfMonth())
                .getDayOfMonth();
    }
    public static void main(String[] args) throws IOException {

        ServiceOrderInterface soi = new ServiceOrder();

        List<ServiceOrder> list = soi.findAllSandwiches();



//        list.forEach(System.out::println);
//        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
//        System.out.println("Displaying Files from the history directory : " );
//        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        ServiceOrder so = new ServiceOrder();
//        List <String> str = new ArrayList<>();
//        List <String> str1 = so.printFileNames(str);
//       str1.stream().filter(s -> s.startsWith("reportOrder")).forEach(System.out::println);

        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        System.out.println("Displaying personal orders from the files of the month : " );
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        so.createMonthlyReportOrder();
        //so.getHistoryTotalPrice();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        so.test();









//        Calendar calendar = Calendar.getInstance();
//        int maxdayOftheMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        LocalDate currentdate = LocalDate.now();
//        int currentDay = currentdate.getDayOfMonth();
//
//        if (maxdayOftheMonth == currentDay){
//
//            System.out.println( " true ");
//        }else {
//
//            System.out.println(" false ");
//        }

    }

}

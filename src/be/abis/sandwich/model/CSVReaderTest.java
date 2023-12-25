package be.abis.sandwich.model;

import java.io.*;
import java.util.*;

public class CSVReaderTest {

//    public static final String delimiter = ";";
//    public static void read(String csvFile) {
//        try {
//            File file = new File(csvFile);
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//            String line = "";
//            String[] tempArr;
//            while((line = br.readLine()) != null) {
//                tempArr = line.split(delimiter);
//                for(String tempStr : tempArr) {
//                    System.out.print(tempStr + ";");
//                }
//                System.out.println();
//            }
//            br.close();
//        } catch(IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }




    public static void read(String csvFile) throws IOException {
        List<List<String>> records = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            records.add(Arrays.asList(values));
            records.forEach(System.out::println);
        }

    }



//    public static Map<String, String> byBufferedReader(String filePath, DupKeyOption dupKeyOption) {
//        HashMap<String, String> map = new HashMap<>();
//        String line;
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            while ((line = reader.readLine()) != null) {
//                String[] keyValuePair = line.split(":", 2);
//                if (keyValuePair.length > 1) {
//                    String key = keyValuePair[0];
//                    String value = keyValuePair[1];
//                    if (DupKeyOption.OVERWRITE == dupKeyOption) {
//                        map.put(key, value);
//                    } else if (DupKeyOption.DISCARD == dupKeyOption) {
//                        map.putIfAbsent(key, value);
//                    }
//                } else {
//                    System.out.println("No Key:Value found in line, ignoring: " + line);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return map;
//    }

}

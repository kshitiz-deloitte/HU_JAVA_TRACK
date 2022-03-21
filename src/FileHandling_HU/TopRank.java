package FileHandling_HU;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TopRank {
    static ArrayList<Students> students;
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\kbhurtel\\Desktop\\StudentData.csv";//file path
        FileReader fr = new FileReader(file);
        students = new ArrayList<Students>();

        try (BufferedReader br = new BufferedReader(fr)) {

            String DELIMITER = ",";
            String line;
            while ((line = br.readLine()) != null) {

                String[] columns = line.split(DELIMITER);
                if(columns[0].compareTo("Name")==0){
                    continue;
                }
                students.add(new Students(columns[0], columns[1], columns[2], columns[3], Integer.parseInt(columns[4])));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int i = 0;
        HashMap<Integer, Students> map = new HashMap<>();


        int[] rank = new int[students.size()];
        for(Students s: students){
            map.put(s.getRank(), s);
        }
        ArrayList<Integer> sortedList = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortedList);
        int k=0;
        FileWriter writer = null;
        writer = new FileWriter("SelectedStudents.csv");
        writer.append("10th:");
        writer.append(',');
        writer.append("12th");
        writer.append(',');
        writer.append("B. Tech");
        writer.append('\n');

        for (Integer s : sortedList){
            if(k>4)
                break;
            Students stu = map.get(s);
            writer.append(stu.getReg10());
            writer.append(',');
            writer.append(stu.getReg12());
            writer.append(',');
            writer.append(stu.getRegBtech());
            writer.append('\n');

            k++;
        }
        writer.flush();
        writer.close();
    }
}

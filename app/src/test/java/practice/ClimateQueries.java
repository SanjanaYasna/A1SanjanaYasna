package practice; 
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
//-99 is a null value. ODn't include it in min calculations
public class ClimateQueries {
    public static float[] temperatures = new float[3567];
    public static String[] correspDates = new String[3567];
    static int count = 0;
    public static void main(String[] args) throws Exception{
        String filename = (args.length > 0) ? args[0] : "app/src/main/java/practice/Dhaka.txt/"; //Dhaka.txt";
        Scanner file = null;
        ArrayMethods queries = new ArrayMethods();

        try {
          file = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
          System.err.println("Cannot locate file.");
          System.exit(-1);
        } //so set the temperatures,.... arrays
        while (file.hasNextLine()) {
          String line = file.nextLine();
          line = line.stripLeading();
        
          String[] fields = line.split("\\s+"); //0 month, 1 day, 2 year, 3 tempt
          //to make dates universally formatted
        
          //to not include null values (represented by -99)
          if (Float.valueOf(fields[3]) == -99){
            continue;
          }
          //format dates
          if (Integer.valueOf(fields[0]) < 10){
            fields[0] = "0" + fields[0];
          }
          if (Integer.valueOf(fields[1]) < 10){
            fields[1] = "0" + fields[1];
          }

          //dates
          String date = fields[2] + fields[0] + fields[1];
          //if (date.length() < 6) System.out.println(date); dates passed!
          
          //set temp values to temperatures array
          float temperature = Float.valueOf(fields[3]);
          temperatures[count] = temperature; 


          //set date values in correspDates array
          correspDates[count] = date;
          

          count++; //increment 
        }
        float[] arr = {1.0f, -9999.0f, 3.0f, 2.0f};
        String[] str = {"20230101","20230214","20230704"};
        boolean[] arr1 = {false, true, true, false};
        boolean[] arr2 = {false, true, false, true};
        System.out.println(Arrays.toString(queries.logicalAnd(arr1, arr2)));
        
        file.close();
      }
}

package practice; 
import java.io.*;
import java.util.Scanner;

import org.checkerframework.checker.units.qual.s;

import java.util.Arrays;
import java.util.InputMismatchException;
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
      public static boolean[] isEqualTo(float[] arr, float comparison){
        boolean[] res = new boolean[arr.length];
        int count = 0;
        for (float i : arr){
            if (i == comparison) {
                res[count] = true;
                count++;
            }
            else {
                res[count] = false;
                count++; }
    }
        return res;

  }
    public static boolean[] isGreaterThan(float[] arr, float comparison){
        boolean[] res = new boolean[arr.length];
        int count = 0;
        for (float i : arr){
            if (i > comparison) {
                res[count] = true;
                count++;
            }
            else {
                res[count] = false;
                count++; }
    }
        return res;

    }

    public static boolean[] logicalNot(boolean[] arr){
      int count = 0;
      for (boolean i: arr){
        if (arr[count] == false){
          arr[count] = true;
          count++;
        }
        else {
          arr[count] = false;
          count++;
        }
      }
      return arr;
    }

    public static float mean(float[] arr, boolean[] includeOrNot, int lo, int hi)throws Exception{
      if (arr.length != includeOrNot.length){
        throw new InputMismatchException();
      }
      if (lo > hi) throw new IndexOutOfBoundsException();
      if (lo == hi) return Float.NaN;
      int trueCount = 0; //number of elemnts that are to be counted
      int sum = 0;
      for (int i = lo; i <hi; i++ ){
        if (includeOrNot[i] == true){
          sum += arr[i];
          trueCount ++;
        }
      }
      if (sum == 0) return 0f; //avoid divide by zero error
      else return sum/trueCount;
    }

    public static boolean[] datesBetween(String[] arr, String begin, String end){
        boolean[] res = new boolean[arr.length];
        int count = 0;
        for (String i : arr){
            if (Integer.valueOf(begin) < Integer.valueOf(i) && Integer.valueOf(end) > Integer.valueOf(i)) {
                res[count] = true;
                count++;
            }
            else {
                res[count] = false;
                count++; }
    }
        return res;

    }

    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2) throws Exception{
        if (arr1.length != arr2.length){
            throw new Exception("Can't compare apples to oranges");
        }
        boolean[] res = new boolean[arr1.length];
        for (int count = 0; count < arr1.length; count++){
            if (arr1[count] == arr2[count] && arr1[count] == true){
                res[count] = true;
            }
            else res[count] = false;
        }
        return res;

    }


}

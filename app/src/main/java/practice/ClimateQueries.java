/* This file includes:
ClimateQueries methods (isEqualTo,isGreaterThan, LogicalNot, LogicalAnd, datesBetween, count,findFirst, find)
Such methods below are tested in CilmateQueriesTest.java

Arrays for corresponding temepratures, dates, and one array for each of hte following pieces of info from Dhaka.txt:
The average daily temperature over the full year - averageDailyTemperaturePerYear
The first day in each year with an average temperature that exceeds the annual average from the first year of data -firstDaysToSurpassAnnualAvgTempofFirstYear
The number of days with temperatures over 30 degrees - daysTemperatureOver30

Prints average daily temperatures between years and first day to surpass average temperature in first year
Also does the analysis of such metrics above between teh two halves, and prints out the analysis results
 */
package practice; 
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException;
//-99 is a null value. It isn't included in the array of temperatures/isn't used in calculations, as instructed
//NOTE: the variable name "res" means resulting array
public class ClimateQueries {
    public static float[] temperatures = new float[3567];
    public static String[] correspDates = new String[3567];
    public static float[] averageDailyTemperaturePerYear = new float[16];
    public static String[] firstDaysToSurpassAnnualAvgTempofFirstYear = new String[16];
    public static boolean[] daysTemperatureOver30;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        String filename = (args.length > 0) ? args[0] : "app/src/main/java/practice/Dhaka.txt/"; //Dhaka.txt";
        Scanner file = null;

        try {
          file = new Scanner(new File(filename));
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
          //if (date.length() < 8) System.out.println(date); dates valid, arguments for each
          
          //set temp values to temperatures array
          float temperature = Float.valueOf(fields[3]);
          temperatures[count] = temperature; 

          //set date values in correspDates array
          correspDates[count] = date;

          count++; //increment 
        }
//Some testsss
        //System.out.println(Arrays.toString(queries.datesBetween(ClimateQueries.correspDates, "20100101","20170101")));
       // System.out.println(correspDates[0]);
        //System.out.println(correspDates[3566]);
        
        file.close();
          
        } catch (FileNotFoundException e) {
          System.err.println("Cannot locate file.");
          System.exit(-1);
        } 
        

    //so take first index, substring of first 4, int of, add one to that, make that dates between range
    //dates between
    //then mean (could do over entire range, or perhaps just over specific range by using get indices from find first)
    //try this for each of hte iterations until you get to the last part
    //number of overall iterations: 2010-1995+1 (since you have a  bit of 2010 that extends beyond first day)
        int firstYear = Integer.valueOf(correspDates[0].substring(0,4));
        int lastYear = Integer.valueOf(correspDates[3566].substring(0,4));
        //so dates between should loop between these years
        for (int year = firstYear; year <=lastYear; year++){
          //System.out.println(year); yep got the years
          //now get the dates for that year based on boolean
          boolean[] datesForSpecificYear = ClimateQueries.datesBetween(correspDates, year+"0100", (year+1)+"0101");
          int[] indicesToCount = ClimateQueries.find(datesForSpecificYear);
          int startIndex = indicesToCount[0];
          int endIndex = indicesToCount[indicesToCount.length -1];
          //find average dialy temperature from this, print that temperature
          float averageForYear = Math.round(ArrayMethods.mean(temperatures, startIndex, endIndex)*10f )/10.0f ;
          System.out.println("For year " + year + " the average daily temperature was " + averageForYear);
          //append such temperature to array of yearly average temps
          averageDailyTemperaturePerYear[year - firstYear] = averageForYear;

          //now find the first day of such year in which temperature exceeds averageForYear:
          //get first year average
          float firstYearAverage = averageDailyTemperaturePerYear[0];
          //System.out.println(firstYearAverage); first year average is 79.4!
          //can do that by using isGreaterThan to find dates >firstYearAverage, then logicalAnd to find temp >saidaverage and part of said year
          //finally, use findFirst to gfet hte first one of said year that meets said qualificaations
          boolean[] greaterThanFirstYearAverage = ClimateQueries.isGreaterThan(temperatures, firstYearAverage);
          boolean[] greaterThanFirstYearAverageAndPartOfYear = ClimateQueries.logicalAnd(greaterThanFirstYearAverage, datesForSpecificYear);
          int firstIndexThatMeetsBothCriteria = ClimateQueries.findFirst(greaterThanFirstYearAverageAndPartOfYear);
          //Now use this said index to add the date to the  tfirstDaysToSurpassAnnualAvgTempofFirstYear array
          firstDaysToSurpassAnnualAvgTempofFirstYear[year-firstYear] = correspDates[firstIndexThatMeetsBothCriteria];
          System.out.println("First day of this year to surpass annual average temperature (79.4C) of first year in data, 1995, is "  + firstDaysToSurpassAnnualAvgTempofFirstYear[year-firstYear]);
        }
        //Now find number of days with temperatures over 30 degrees
        //first which days have temperatures over 30
        daysTemperatureOver30 = ClimateQueries.isGreaterThan(temperatures, 86f);
        System.out.println("Total number of days with temperatures over 30C/86F: " + ClimateQueries.count(daysTemperatureOver30));
        //dhaka is a very hot place?


        //Now divide these values into two halves, 1995-2002, and 2003-2010
        //so average daily temperature from 1995-2002:
        float averageFirstHalf = Math.round(ArrayMethods.mean(averageDailyTemperaturePerYear, 0, 8)*100f) /100f;
        System.out.println("Average daily temperature from 1995-2002 was " + averageFirstHalf + "C");
        //2003-2010
        float averageSecondHalf = Math.round(ArrayMethods.mean(averageDailyTemperaturePerYear, 8, 16)*100f) /100f;
        System.out.println("Average daily temperature from 2003-2010 was " + averageSecondHalf + "C");
        
        //now day of the year averages
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyMMdd");
        //Now first half:
        int sum = 0;
        for (int i = 0; i < 8; i ++){
          sum += LocalDate.parse(firstDaysToSurpassAnnualAvgTempofFirstYear[i], fmt).getDayOfYear();
        }
        int avg = Math.round(sum /8);
        System.out.println("The average first nth day of year to surpass first year's average temperature (74.9C) from first half of data (roughly 1995-2002) is " + avg);

        //Now rinse and repeat for second half:
        int sum2 = 0;
        for (int i = 8; i < 16; i ++){
          sum2 += LocalDate.parse(firstDaysToSurpassAnnualAvgTempofFirstYear[i], fmt).getDayOfYear();
        }
        int avg2 = Math.round(sum2 /8);
        System.out.println("The average first nth day of year to surpass first year's average temperature (74.9C) from second half of data (roughly 2003-2010) is " + avg2);
        System.out.println("So the annual average temperature for the first year of the study is exceeded on average 5 days earlier in latter half of recordings as opposed to the first half");


        //now temperatures over 30C in 1995-2002:
        int numberOver30FirstHalf = ClimateQueries.count(daysTemperatureOver30, 0, 1783);
        System.out.println("From the first half of data, the number of days with a temperature over 30C/86F is : "+ numberOver30FirstHalf);
        //now second half
        int numberOver30SecondHalf = ClimateQueries.count(daysTemperatureOver30, 1783, 3567);
        System.out.println("From the second half of data, the number of days with a temperature over 30C/86F is : "+ numberOver30SecondHalf);
        System.out.println("Shout out to climate change for making this study possible");

        
        


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
      for (int i = 0; i < arr.length; i ++){
        if (arr[i] == true) arr[i] = false;
        else arr[i] = true;
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

    public static boolean[] datesBetween(String[] arr, String begin, String end)throws Exception{
        boolean[] res = new boolean[arr.length];
        //int count = 0;
        if (begin.length() != 8 || end.length() != 8){
          throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr.length; i++){
          if (Integer.valueOf(arr[i]) >= Integer.valueOf(begin) && Integer.valueOf(end) >= Integer.valueOf(arr[i])){
            res[i] = true;
          }
          else res[i] = false;
        }
        /*for (String i : arr){
            if (Integer.valueOf(i) >= Integer.valueOf(begin) && Integer.valueOf(end) >= Integer.valueOf(i)) {
                res[count] = true;
            }
            else res[count] = false;
            count++; 
    }*/
        return res;

    }

    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2) throws Exception{
        if (arr1.length != arr2.length){
            throw new Exception("Can't compare apples to oranges");
        }
        boolean[] res = new boolean[arr1.length];
        for (int count = 0; count < arr1.length; count++){
            if (arr1[count] == true && arr2[count] == true){
                res[count] = true;
            }
            else res[count] = false;
        }
        return res;

    }

    public static int count(boolean[] arr){
      int count = 0;
      for (boolean i : arr){
        if (i ==true) count++;
      }
      return count;
    }

    public static int count(boolean[] arr, int lo, int hi){
      if (lo > hi) throw new IndexOutOfBoundsException();
      if (lo == hi) return -1;
      int count = 0;
      for (int i = lo; i<hi; i++){
        if (arr[i] == true) count ++;
      }
      return count;
    }

    public static int findFirst(boolean[] arr){
      for (int i = 0; i < arr.length; i++){
        if (arr[i] == true){
          return i;
        }
      }
      return -1;
    }

    public static int[] find(boolean[] arr){
      int arrSize = count(arr);
      int[] res = new int[arrSize];
      int resIndex = 0;
      for (int i = 0; i<arr.length; i++){
        if (arr[i] == true){
          res[resIndex] = i;
          resIndex++;
        }
      }
      return res;
    }

}

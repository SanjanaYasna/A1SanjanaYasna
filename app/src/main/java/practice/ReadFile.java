package practice;
import java.io.*;
import java.util.Scanner;

/** Class containing a file reading demo */
public class ReadFile {
  public static float[] temperatures = new float[224];
  public static String[] correspDates = new String[224];
  /** The main method reads from a file and prints the contents. */
  public static void main(String[] args) throws Exception {
    String filename = (args.length > 0) ? args[0] : "YUMA_2023.txt";
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    } 
    int count = 0;
    while (file.hasNextLine()) {
      String line = file.nextLine();
      String[] fields = line.split("\\s+");
      if (Float.valueOf(fields[8]) == -9999.0f){
        continue;
      }
      String date = fields[1];
      float temperature = Float.valueOf(fields[8]);
      temperatures[count] = temperature;
      correspDates[count] = date;
     // System.out.println("On " + date + " the temperature was " + temperature + " degrees Celsius.");
      count++;
    }
    //System.out.println(count); //so  there are 224 entries that aren't null
    /*System.out.println((temperatures[223]));
    System.out.println((correspDates[223]));
    Just making sure the arrays are fully filled */
    file.close();
    //System.out.println(Arrays.toString(temperatures));

/*So here's the part where we get the output of (i mean, it doesn't relaly match...)
Source file: YUMA_2023.txt
Annual mean temperature: 25.6 degrees Celsius
Minimum average daily temperature: -2.7 degrees Celsius //if you control f for "-", you won't find any negative numbers in the temperatures values of the file
Maximum average daily temperature: 37.4 degrees Celsius
Mean temperature in January: 8.4 degrees Celsius
Mean temperature in July: 29.8 degrees Celsius*/
    System.out.println("Source file: YUMA_2023.txt");
    System.out.println("Minimum average daily temperature: " + ArrayMethods.min(temperatures));
    System.out.println("Maximum average daily temperature: " + ArrayMethods.max(temperatures));
    System.out.println("Annual mean temperature: " + Math.round(ArrayMethods.mean(temperatures)*10)/10.0);
    //dates between 20230101 - 20230131
    //findFirst to get first index to count
    //logicalNot then findFirst to get first index to not count, so basically do that index -1
    //oh wait, since mean's second index is exclusive, that wont' be necessary. just put in result of second findFIrst
    //apply mean from these two boundaries 


    //NOTE: FIGURE OUT WHY HERE DATESBETWEEN IS MIRACULOUSLY EXCLUSIVE...
    boolean[] rightDates = ArrayMethods.datesBetween(correspDates, "20230100", "20230201");
    //find first index to take the mean of (inclusive)
    int startIndex = ClimateQueries.findFirst(rightDates);
    //get second index where january dates end...
    rightDates = ClimateQueries.logicalNot(rightDates);
    int endIndex = ClimateQueries.findFirst(rightDates );
    System.out.println("Mean temperature in January: " + Math.round(ArrayMethods.mean(temperatures, startIndex, endIndex)*10 )/10.0 ) ;

    //rinse and repeat
    rightDates = ArrayMethods.datesBetween(correspDates, "20230631", "20230801");
    startIndex = ClimateQueries.findFirst(rightDates);
    //since the range isn't right at hte beginnng, can't use logial not and find first again
    //what we can do is use find and return the last index of find
    int[] indicesToCount = ClimateQueries.find(rightDates);
    endIndex = indicesToCount[indicesToCount.length -1] + 1;
    System.out.println("Mean temperature in July: " + Math.round(ArrayMethods.mean(temperatures, startIndex, endIndex)*10 )/10.0 ) ;



  }
}
/*Contains essentail array methods (wholeSum, sum, mean, min, max, isGreaterThan, lowest, and highest) 
Such methods are used in ClimateQueries.java to analyze the Dhaka.txt file, and ReadFile.java to analyze  the YUMA.txt file
*/
package practice;
import java.util.*;

public class ArrayMethods{
    public static float wholeSum(float[] temps){
        float sum = 0;
        for (int i = 0; i < temps.length; i++){
            sum += temps[i];
        }
        return sum;
    }
    public static float sum(float[] temps, int lo, int hi){
        float sum = 0;
        if (lo == hi) return 0f;
        for (int i = lo; i < hi; i++){
            sum += temps[i];
        }
        return sum;
    }

    public static float sum(float[] temps){
        return wholeSum(temps);
    }

    public static float mean(float[] temps){
        if (temps.length == 0){
            return 0f;
        }
        return (wholeSum(temps)/temps.length);
    }

    //it doesn't automatically throw out of bounds exception for invalid ranges, rather it skips over invalid loop and outputs -0.0f
    //maybe it's a java 20 thing
    public static float mean(float[] temps, int lo, int hi) throws Exception{
        if (lo > hi) throw new IndexOutOfBoundsException();
        float sum = 0;
        if (lo == hi) return 0f;
        for (int i = lo; i < hi; i++){
            sum += temps[i];
        }
        return sum/(hi-lo);
    }
//assuming NaN is essentailly skipped over...
    public static float min(float[] temps, int start, int end) throws Exception{
        float min = Float.MIN_VALUE;
        if (end < start){ 
            throw new IndexOutOfBoundsException(); }
        if (start == end){
            return Float.NaN;
        }
        int i = start;
        int j = end -1;
        while (i != j){
            if (Float.isNaN(temps[i])){
                i++;
            }
            else if (Float.isNaN(temps[j])){
                j--;
            }
            else if (temps[i] < temps[j]){
                min = temps[i];
                j--;
            }
            else{
                min = temps[j];
                i++;
            }
        }
        return min;

    }

    public static float min(float[] temps) throws Exception{
        if (temps.length == 0){
            return Float.NaN;
        }
        return min(temps, 0, temps.length);
    }

    public static float max(float[] temps, int start, int end) throws Exception{
        float max = Float.MIN_VALUE;
        if (end < start){
            throw new IndexOutOfBoundsException(); //maybe do this with junit testing, tho iwll have to speak about if we should configure this ourselves
        }
        if (start == end){
            return Float.NaN;
        }
        int i = start;
        int j = end -1;
        while (i != j){
            if (temps[i] < temps[j]){
                max = temps[j];
                i++;
            }
            else{
                max = temps[i];
                j--;
            }
        }
        return max;

    }

    public static float max(float[] temps) throws Exception{
        if (temps.length == 0){
            return Float.NaN;
        }
        return max(temps, 0, temps.length);
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


    //attempt stretch iwth bubble sort or heaps... (i assume we can't just use built-in sort method and call it a day)
    
    public static float[] lowest(float[] arr, int lo, int hi, int numOfElements) throws Exception{
        if (lo >= hi) throw new IndexOutOfBoundsException(); 
        float[] res = new float[numOfElements];
        PriorityQueue<Float> maxHeap = new PriorityQueue<Float>(Collections.reverseOrder());
        for (int i = lo; i < hi; i ++){
            maxHeap.add(arr[i]);
            //need to keep maxHeap to size we want, numOfElements:
            if (maxHeap.size() > numOfElements) maxHeap.poll();
        }
        int iterator = 0;
        while (!maxHeap.isEmpty()){
            res[iterator] = maxHeap.poll();
            iterator++;
        }
        //if numOfElements is higher than the available elements, fill rest with NaN
        while (iterator < numOfElements){
            res[iterator] = Float.NaN;
            iterator++;
        }
        return res;
    }

    public static float[] lowest(float[] arr, int numOfElements) throws Exception{
        float[] res = new float[numOfElements];
        PriorityQueue<Float> maxHeap = new PriorityQueue<Float>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i ++){
            maxHeap.add(arr[i]);
            //need to keep maxHeap to size we want, numOfElements:
            if (maxHeap.size() > numOfElements) maxHeap.poll();
        }
        int iterator = 0;
        while (!maxHeap.isEmpty()){
            res[iterator] = maxHeap.poll();
            iterator++;
        }
        while (iterator < numOfElements){
            res[iterator] = Float.NaN;
            iterator++;
        }
        return res;
    }

//copy-paste, no reverse order for minHeap
    public static float[] highest(float[] arr, int lo, int hi, int numOfElements) throws Exception{
        if (lo >= hi) throw new IndexOutOfBoundsException(); 
        float[] res = new float[numOfElements];
        PriorityQueue<Float> maxHeap = new PriorityQueue<Float>();
        for (int i = lo; i < hi; i ++){
            maxHeap.add(arr[i]);
            //need to keep maxHeap to size we want, numOfElements:
            if (maxHeap.size() > numOfElements) maxHeap.poll();
        }
        int iterator = 0;
        while (!maxHeap.isEmpty()){
            res[iterator] = maxHeap.poll();
            iterator++;
        }
        //if numOfElements is higher than the available elements, fill rest with NaN
        while (iterator < numOfElements){
            res[iterator] = Float.NaN;
            iterator++;
        }
        return res;
    }

    public static float[] highest(float[] arr, int numOfElements){
        float[] res = new float[numOfElements];
        PriorityQueue<Float> maxHeap = new PriorityQueue<Float>();
        for (int i = 0; i < arr.length; i ++){
            maxHeap.add(arr[i]);
            //need to keep maxHeap to size we want, numOfElements:
            if (maxHeap.size() > numOfElements) maxHeap.poll();
        }
        int iterator = 0;
        while (!maxHeap.isEmpty()){
            res[iterator] = maxHeap.poll();
            iterator++;
        }
        while (iterator < numOfElements){
            res[iterator] = Float.NaN;
            iterator++;
        }
        return res;
    }






}

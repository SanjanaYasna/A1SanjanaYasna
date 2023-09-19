package practice;
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

    //attempt stretch iwth bubble sort or heaps... (i assume we can't just use built-in sort method and call it a day)
    







}

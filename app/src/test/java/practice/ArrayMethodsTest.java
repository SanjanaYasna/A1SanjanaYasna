package practice;
import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayMethodsTest{
    @Test 
    public void wholeSumWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayMethods method1 = new ArrayMethods();
        float res = ArrayMethods.wholeSum(arr);
        assertEquals(10.0,res,0);
        float[] arr1 = {-7.5f, 3.2f};
        float res1 = method1.wholeSum(arr1);
        assertEquals(-4.3,res1,0.1);
        float[] arr2 = {};
        float res2 = method1.wholeSum(arr2);
        assertEquals(0,res2,0.1);
    }

    @Test 
    public void sumWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayMethods method1 = new ArrayMethods();
        float res = ArrayMethods.wholeSum(arr);
        assertEquals(10.0,res,0);
        float[] arr1 = {-7.5f, 3.2f};
        float res1 = method1.wholeSum(arr1);
        assertEquals(-4.3,res1,0.1);
        float[] arr2 = {};
        float res2 = method1.wholeSum(arr2);
        assertEquals(0,res2,0.1);
    }

    @Test 
    public void meanWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayMethods method1 = new ArrayMethods();
        float res = ArrayMethods.wholeSum(arr);
        assertEquals(10.0,res,0);
        float[] arr1 = {-7.5f, 3.2f};
        float res1 = method1.wholeSum(arr1);
        assertEquals(-4.3,res1,0.1);
        float[] arr2 = {};
        float res2 = method1.wholeSum(arr2);
        assertEquals(0,res2,0.1);
    }

    @Test 
    public void minMaxWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayMethods method1 = new ArrayMethods();
        float res = ArrayMethods.wholeSum(arr);
        assertEquals(10.0,res,0);
        float[] arr1 = {-7.5f, 3.2f};
        float res1 = method1.wholeSum(arr1);
        assertEquals(-4.3,res1,0.1);
        float[] arr2 = {};
        float res2 = method1.wholeSum(arr2);
        assertEquals(0,res2,0.1);
    }
    
/* 
    public static void main(String[] args) throws Exception{
       ArrayMethods method1 = new ArrayMethods();
       float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
       System.out.println(method1.max(arr, 1, 4));
       System.out.println("compiler is blind");
    }*/
    
}
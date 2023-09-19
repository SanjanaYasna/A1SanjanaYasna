package practice;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayMethodsTest{
    @Test 
    public void wholeSumWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayMethods methods = new ArrayMethods();
        float res = ArrayMethods.wholeSum(arr);
        assertEquals(10.0,res,0);
        float[] arr1 = {-7.5f, 3.2f};
        float res1 = methods.wholeSum(arr1);
        assertEquals(-4.3,res1,0.01);
        float[] arr2 = {};
        float res2 = methods.wholeSum(arr2);
        assertEquals(0,res2,0.01);
        float[] arr3 = {48f};
        float res3 = methods.wholeSum(arr3);
        assertEquals(48,res3,0.01);
        float[] arr4 = {0f, 8f};
        float res4 = methods.wholeSum(arr4);
        assertEquals(8,res4,0.01);
    }

    @Test 
    public void sumWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayMethods methods = new ArrayMethods();
        float res = ArrayMethods.sum(arr,1, 3);
        assertEquals(5.0,res,0.01);
        float res1 = methods.sum(arr, 0, 4);
        assertEquals(10,res1,0.01);
        float res2 = methods.sum(arr, 2, 2);
        assertEquals(0,res2,0.01);
        float[] arr1 = {8f, 2f, 14f};
        float res3 = methods.sum(arr1);
        assertEquals(24, res3, 0.01);
        float res4 = methods.sum(arr) + methods.sum(arr1);
        assertEquals(34, res4, 0.01);

    }

    @Test 
    public void meanWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayMethods methods = new ArrayMethods();
        float res = ArrayMethods.mean(arr, 2, 4);
        assertEquals(3.5,res,0);
        float res1 = methods.mean(arr);
        assertEquals(2.5,res1,0.01);
        float[] arr2 = {};
        float res2 = methods.mean(arr2);
        assertEquals(0,res2,0.01);
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()->{methods.mean(arr, 2, 1);});
        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, ()->{methods.mean(arr, 6, 1);});
    }

    @Test 
    public void minMaxWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayMethods methods = new ArrayMethods();
        float res = ArrayMethods.min(arr, 1, 4);
        assertEquals(2,res,0);
        float res1 = methods.min(arr);
        assertEquals(1,res1,0.01);
        float[] arr2 = {};
        float res2 = methods.min(arr2);
        assertEquals(Float.NaN,res2,0.01);
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()->{methods.min(arr, 10, 1);});
        float[] arr1 = {-7.5f, 3.2f, Float.NaN};
        float res3 = methods.min(arr1);
        assertEquals(Float.NaN, methods.min(arr1,1,1), 0.01);
        assertEquals(-7.5,res3,0);
        float res4 = methods.max(arr, 1, 4);
        assertEquals(4, res4, 0.01);
        float res5 = methods.max(arr, 1, 1);
        assertEquals(Float.NaN, res5, 0.01);
        float[] arrLastIWanttoDo = {1.0f, 3.f, 2.0f};
        float res6 = methods.max(arrLastIWanttoDo);
        assertEquals(3, res6, 0.01);
        float res7 = methods.max(arrLastIWanttoDo, 0, 0);
        assertEquals(Float.NaN, res7, 0.01);
    }
    
}
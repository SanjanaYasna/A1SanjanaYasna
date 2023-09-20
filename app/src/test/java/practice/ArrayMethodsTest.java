package practice;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayMethodsTest{
    @Test 
    public void wholeSumWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        float res = ArrayMethods.wholeSum(arr);
        assertEquals(10.0,res,0);
        float[] arr1 = {-7.5f, 3.2f};
        float res1 = ArrayMethods.wholeSum(arr1);
        assertEquals(-4.3,res1,0.01);
        float[] arr2 = {};
        float res2 = ArrayMethods.wholeSum(arr2);
        assertEquals(0,res2,0.01);
        float[] arr3 = {48f};
        float res3 = ArrayMethods.wholeSum(arr3);
        assertEquals(48,res3,0.01);
        float[] arr4 = {0f, 8f};
        float res4 = ArrayMethods.wholeSum(arr4);
        assertEquals(8,res4,0.01);
    }

    @Test 
    public void sumWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        float res = ArrayMethods.sum(arr,1, 3);
        assertEquals(5.0,res,0.01);
        float res1 = ArrayMethods.sum(arr, 0, 4);
        assertEquals(10,res1,0.01);
        float res2 = ArrayMethods.sum(arr, 2, 2);
        assertEquals(0,res2,0.01);
        float[] arr1 = {8f, 2f, 14f};
        float res3 = ArrayMethods.sum(arr1);
        assertEquals(24, res3, 0.01);
        float res4 = ArrayMethods.sum(arr) + ArrayMethods.sum(arr1);
        assertEquals(34, res4, 0.01);

    }

    @Test 
    public void meanWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        float res = ArrayMethods.mean(arr, 2, 4);
        assertEquals(3.5,res,0);
        float res1 = ArrayMethods.mean(arr);
        assertEquals(2.5,res1,0.01);
        float[] arr2 = {};
        float res2 = ArrayMethods.mean(arr2);
        assertEquals(0,res2,0.01);
        assertThrows(IndexOutOfBoundsException.class, ()->{ArrayMethods.mean(arr, 2, 1);});
        assertThrows(IndexOutOfBoundsException.class, ()->{ArrayMethods.mean(arr, 6, 1);});
    }

    @Test 
    public void minMaxWorks() throws Exception {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        float res = ArrayMethods.min(arr, 1, 4);
        assertEquals(2,res,0);
        float res1 = ArrayMethods.min(arr);
        assertEquals(1,res1,0.01);
        float[] arr2 = {};
        float res2 = ArrayMethods.min(arr2);
        assertEquals(Float.NaN,res2,0.01);
        assertThrows(IndexOutOfBoundsException.class, ()->{ArrayMethods.min(arr, 10, 1);});
        float[] arr1 = {-7.5f, 3.2f, Float.NaN};
        float res3 = ArrayMethods.min(arr1);
        assertEquals(Float.NaN, ArrayMethods.min(arr1,1,1), 0.01);
        assertEquals(-7.5,res3,0);
        float res4 = ArrayMethods.max(arr, 1, 4);
        assertEquals(4, res4, 0.01);
        float res5 = ArrayMethods.max(arr, 1, 1);
        assertEquals(Float.NaN, res5, 0.01);
        float[] arrLastIWanttoDo = {1.0f, 3.f, 2.0f};
        float res6 = ArrayMethods.max(arrLastIWanttoDo);
        assertEquals(3, res6, 0.01);
        float res7 = ArrayMethods.max(arrLastIWanttoDo, 0, 0);
        assertEquals(Float.NaN, res7, 0.01);
    }
    
}
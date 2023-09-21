/*Tests methods from ArrayMethods.java */
package practice;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
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
        assertThrows(IndexOutOfBoundsException.class, ()->{ArrayMethods.lowest(arr1, 4, 0, 3);});
    }
    @Test
    public void lowestWorks() throws Exception{
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] res = ArrayMethods.lowest(arr, 0, 4, 2);
        float[] output = {2f, 1f};
        assertArrayEquals(output, res, 0);
        float[] arr1 = {2.0f, 3.0f, 2.0f, 3.0f};
        float[] res1 = ArrayMethods.lowest(arr1, 0, 4, 3);
        float[] output1 = {3f, 2f, 2f};
        assertArrayEquals(output1, res1, 0);
        float[] arr2 = {4.0f, 3.0f, 2.0f, 1.0f};
        float[] output2 = {2.0f, 1f};
        assertArrayEquals(output2, ArrayMethods.lowest(arr2, 2), 0);
        float[] arr3 = {4.0f, 3.0f, 2.0f, 1.0f};
        float[] output3 = {1f};
        assertArrayEquals(output3, ArrayMethods.lowest(arr3, 1), 0);
        float[] arr4 = {4.0f, 3.0f};
        float[] output4 = {4f, 3f, Float.NaN};
        assertArrayEquals(output4, ArrayMethods.lowest(arr4, 3), 0);
        assertThrows(IndexOutOfBoundsException.class, ()->{ArrayMethods.lowest(arr1, 4, 4, 3);});
    }
    @Test
    public void highestWorks() throws Exception{
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] res = ArrayMethods.highest(arr, 0, 4, 2);
        float[] output = {3f, 4f};
        assertArrayEquals(output, res, 0);
        float[] arr1 = {2.0f, 3.0f, 2.0f, 3.0f};
        float[] res1 = ArrayMethods.highest(arr1, 0, 4, 3);
        float[] output1 = {2f, 3f, 3f};
        System.out.println(Arrays.toString(res1));
        assertArrayEquals(output1, res1, 0);
        float[] arr2 = {4.0f, 3.0f};
        float[] output2 = {4f};
        assertArrayEquals(output2, ArrayMethods.highest(arr2, 1), 0);
        float[] arr3 = {4.0f, 3.0f, 2.0f, 1.0f};
        float[] output3 = {1f, 2f, 3f, 4f, Float.NaN};
        assertArrayEquals(output3, ArrayMethods.highest(arr3, 5), 0);
        float[] arr4 = {4.0f, 3.0f};
        float[] output4 = {3f, 4f, Float.NaN};
        assertArrayEquals(output4, ArrayMethods.highest(arr4, 3), 0);
        assertThrows(IndexOutOfBoundsException.class, ()->{ArrayMethods.highest(arr1, 4, 0, 3);});
        assertThrows(IndexOutOfBoundsException.class, ()->{ArrayMethods.highest(arr1, 4, 4, 3);});
    }
}
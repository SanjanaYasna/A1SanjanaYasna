package practice;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.InputMismatchException;
public class ClimateQueriesTest {
    @Test
    public void isEqualToTest(){
        float[] input = {1.0f, 2.0f, 3.0f, 2.0f};
        boolean[] output = {false, true, false, true};
        assertArrayEquals(output, ClimateQueries.isEqualTo(input, 2.0f) );
        boolean[] output1 = {false, false, false, false};
        assertArrayEquals(output1,ClimateQueries.isEqualTo(input, Float.NaN));
        float[] input2 = {1.0f, -9999.0f, 3.f, 2.0f};
        boolean[] output2 = {false, true, false, false};
        assertArrayEquals(output2, ClimateQueries.isEqualTo(input2, -9999f));
    }

    @Test
    public void logicalNotTest(){
        boolean[] input = {false, true, false, false};
        boolean[] output = {true, false, true, true};
        assertArrayEquals(output, ClimateQueries.logicalNot(input) );
        boolean[] input3 = {};
        assertArrayEquals(input3,ClimateQueries.logicalNot(input3));
        boolean[] output2 = {true, false, true, true};
        boolean[] input2 = {false, true, false, false};
        assertArrayEquals(output2, ClimateQueries.logicalNot(input2));
    }

    @Test
    public void meanTest() throws Exception{
        boolean[] inputR = {true, false, true, true}; //as in right input, left input
        float[] inputL = {1.0f, -9999.0f, 3.0f, 2.0f};
        float[] badinputL = {1.0f, 0f, -9999.0f, 3.0f, 2.0f};
        assertEquals(2.0, ClimateQueries.mean(inputL, inputR, 0, 4), 0.01);
        assertThrows(IndexOutOfBoundsException.class, ()->{ClimateQueries.mean(inputL, inputR, 1, 5);});
        assertThrows(InputMismatchException.class, ()->{ClimateQueries.mean(badinputL, inputR, 0 ,4);});
        boolean[] inputR1 = {true, false, false, true, true};
        float[] inputL1 = {1.0f, -9999.0f, 3.0f, 2.0f, 18f};
        assertEquals(1f, ClimateQueries.mean(inputL1, inputR1, 0, 2), 0.01);
        assertEquals(0, ClimateQueries.mean(inputL1, inputR1, 1,2), 0.01);
    }

    @Test
    public void isGreaterThanTest() throws Exception{
        float[] input = {1.0f, 2.0f, 3.0f, 2.0f};
        boolean[] output = {false, false, true, false};
        assertArrayEquals(output, ClimateQueries.isGreaterThan(input, 2.5f) );
        boolean[] output1 = {false, false, false, false};
        assertArrayEquals(output1,ClimateQueries.isGreaterThan(input, Float.NaN));
        float[] input2 = {1.0f, -9999.0f, 3.f, 2.0f};
        boolean[] output2 = {false, false, false, false};
        assertArrayEquals(output2, ClimateQueries.isGreaterThan(input2, Float.MAX_VALUE));
    }

    @Test
    public void datesBetweenTest() throws Exception{
        String[] input = {"20230201","20230214","20230704"};
        boolean[] output = {true, true, false};
        System.out.println(Arrays.toString(ClimateQueries.datesBetween(input, "20230201", "20230601")));
        assertArrayEquals(output, ClimateQueries.datesBetween(input, "20230201", "20230601"));
        assertThrows(IllegalArgumentException.class, ()->{ClimateQueries.datesBetween(input, "202302010", "20230601");});
        assertThrows(IllegalArgumentException.class, ()->{ClimateQueries.datesBetween(input, "20230201", "2023060");});
        //ClimateQueries.datesBetween(ClimateClimateQueries.correspDates, "20100101","20170101");
        String[] input2 = {"20230101"};
        boolean[] output1 = {true};
        //System.out.println(Arrays.toString(ClimateClimateClimateQueries.datesBetween(input2, "20230101", "20230115")));
        assertArrayEquals(output1, ClimateQueries.datesBetween(input2, "20230101", "20230115"));
    }

    @Test
    public void logicalAndTest()throws Exception {
        boolean[] inputL = {false, true, true, false};
        boolean[] inputR = {false, true, false, true};
        boolean[] output = {false, true, false, false};
        assertArrayEquals(output, ClimateQueries.logicalAnd(inputL, inputR) );
        boolean[] input3 = {};
        assertArrayEquals(input3,ClimateQueries.logicalAnd(input3, input3));
        boolean[] inputL2 = {true, false, true, true};
        boolean[] inputR2 = {false, true, false, false};
        boolean[] output1 = {false, false, false, false};
        assertArrayEquals(output1, ClimateQueries.logicalAnd(inputL2, inputR2));
        boolean[] badInput = {true, false, false};
        //assert exception message same for bad inputs of varying length:
        Exception expectedEx = assertThrows(Exception.class, () -> 
        assertArrayEquals(output1, ClimateQueries.logicalAnd(inputL2, badInput)));
        assertEquals("Can't compare apples to oranges", expectedEx.getMessage());
    }

    @Test
    public void countTest() throws Exception{
        boolean[] input = {true, false, true, true}; 
        boolean[] input1 = {false, true, true, false, true};
        boolean[] input2 = {};
        assertEquals(3, ClimateQueries.count(input), 0.01);
        assertEquals(3, ClimateQueries.count(input1), 0.01);
        boolean[] input3 = {true, false, false, false, true};
        assertEquals(0, ClimateQueries.count(input2), 0.01);
        assertEquals(2, ClimateQueries.count(input3), 0.01);
    }

    @Test
    public void findFirstTest(){
        boolean[] input = {true, false, true, true}; 
        boolean[] input1 = {false, true, true, false, true};
        boolean[] input2 = {};
        assertEquals(0, ClimateQueries.findFirst(input), 0.01);
        assertEquals(1, ClimateQueries.findFirst(input1), 0.01);
        assertEquals(-1, ClimateQueries.findFirst(input2), 0.01);
        boolean[] input3 ={false, false, true, false, true};
        boolean[] input4 ={false, false, false};
        assertEquals(-1, ClimateQueries.findFirst(input4), 0.01);
        assertEquals(2, ClimateQueries.findFirst(input3), 0.01);
    }

    @Test
    public void findTest(){ //output numbers match their input numbers
        boolean[] input = {true, false, true, true}; 
        boolean[] input1 = {false, true, true, false, true};
        boolean[] input2 = {};
        int[] output = {0, 2, 3};
        int[] output1 = {1, 2, 4};
        int[] output2 = {};
        assertArrayEquals(output, ClimateQueries.find(input));
        assertArrayEquals(output1, ClimateQueries.find(input1));
        assertArrayEquals(output2, ClimateQueries.find(input2));
        boolean[] input3 ={false, true, true, false, true};
        boolean[] input4 ={false, false, false};
        int[] output3 = {1, 2, 4};
        //output4 is output2
        assertArrayEquals(output2, ClimateQueries.find(input4));
        assertArrayEquals(output3, ClimateQueries.find(input3));
    }







}

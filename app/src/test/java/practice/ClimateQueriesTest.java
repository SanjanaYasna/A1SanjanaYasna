package practice;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.InputMismatchException;
public class ClimateQueriesTest {
    @Test
    public void isEqualToTest(){
        ClimateQueries queries = new ClimateQueries();
        float[] input = {1.0f, 2.0f, 3.0f, 2.0f};
        boolean[] output = {false, true, false, true};
        assertArrayEquals(output, queries.isEqualTo(input, 2.0f) );
        boolean[] output1 = {false, false, false, false};
        assertArrayEquals(output1,queries.isEqualTo(input, Float.NaN));
        float[] input2 = {1.0f, -9999.0f, 3.f, 2.0f};
        boolean[] output2 = {false, true, false, false};
        assertArrayEquals(output2, queries.isEqualTo(input2, -9999f));
    }

    @Test
    public void logicalNotTest(){
        ClimateQueries queries = new ClimateQueries();
        boolean[] input = {false, true, false, false};
        boolean[] output = {true, false, true, true};
        assertArrayEquals(output, queries.logicalNot(input) );
        boolean[] input3 = {};
        assertArrayEquals(input3,queries.logicalNot(input3));
        boolean[] output2 = {true, false, true, true};
        boolean[] input2 = {false, true, false, false};
        assertArrayEquals(output2, queries.logicalNot(input2));
    }

    @Test
    public void meanTest() throws Exception{
        ClimateQueries queries = new ClimateQueries();
        boolean[] inputR = {true, false, true, true}; //as in right input, left input
        float[] inputL = {1.0f, -9999.0f, 3.0f, 2.0f};
        float[] badinputL = {1.0f, 0f, -9999.0f, 3.0f, 2.0f};
        assertEquals(2.0, queries.mean(inputL, inputR, 0, 4), 0.01);
        Throwable exception0 = assertThrows(IndexOutOfBoundsException.class, ()->{queries.mean(inputL, inputR, 1, 5);});
        Throwable exception1 = assertThrows(InputMismatchException.class, ()->{queries.mean(badinputL, inputR, 0 ,4);});
        boolean[] inputR1 = {true, false, false, true, true};
        float[] inputL1 = {1.0f, -9999.0f, 3.0f, 2.0f, 18f};
        assertEquals(1f, queries.mean(inputL1, inputR1, 0, 2), 0.01);
        assertEquals(0, queries.mean(inputL1, inputR1, 1,2), 0.01);
    }

    @Test
    public void isGreaterThanTest() throws Exception{
        ClimateQueries queries = new ClimateQueries();
        float[] input = {1.0f, 2.0f, 3.0f, 2.0f};
        boolean[] output = {false, false, true, false};
        assertArrayEquals(output, queries.isGreaterThan(input, 2.5f) );
        boolean[] output1 = {false, false, false, false};
        assertArrayEquals(output1,queries.isGreaterThan(input, Float.NaN));
        float[] input2 = {1.0f, -9999.0f, 3.f, 2.0f};
        boolean[] output2 = {false, false, false, false};
        assertArrayEquals(output2, queries.isGreaterThan(input2, Float.MAX_VALUE));
    }

    @Test
    public void datesBetweenTest() throws Exception{
        ClimateQueries queries = new ClimateQueries();
        String[] input = {"20230101","20230214","20230704"};
        boolean[] output = {false, true, false};
        assertArrayEquals(output, queries.datesBetween(input, "20230201", "20230601"));
        Throwable exception0 = assertThrows(IllegalArgumentException.class, ()->{queries.datesBetween(input, "202302010", "20230601");});
        Throwable exception1 = assertThrows(IllegalArgumentException.class, ()->{queries.datesBetween(input, "20230201", "2023060");});
        System.out.println(Arrays.toString(queries.correspDates));
        //queries.datesBetween(ClimateQueries.correspDates, "20100101","20170101");
    }

    

}

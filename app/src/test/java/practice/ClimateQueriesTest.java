package practice;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
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

    
}

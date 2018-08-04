package fibonacci;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class FibonacciRowTest {

    @DataProvider(name = "number length")
    public Object[][] getLength() {
        return new Object[][]{
                {1, new ArrayList<Long>(Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L))},
                {2, new ArrayList<Long>(Arrays.asList(13L, 21L, 34L, 55L, 89L))},
                {3, new ArrayList<Long>(Arrays.asList(144L, 233L, 377L, 610L, 987L))},
                {4, new ArrayList<Long>(Arrays.asList(1597L, 2584L, 4181L, 6765L))},
        };
    }

    @DataProvider(name = "range")
    public Object[][] getRange() {
        return new Object[][]{
                {new long[]{7, 23}, new ArrayList<Long>(Arrays.asList(8L, 13L, 21L))},
                {new long[]{144, 987}, new ArrayList<Long>(Arrays.asList(144L, 233L, 377L, 610L, 987L))},
                {new long[]{5, 5}, new ArrayList<Long>(Collections.singletonList(5L))},
                {new long[]{5, 5}, new ArrayList<Long>(Collections.singletonList(5L))},
                {new long[]{0, 10}, new ArrayList<Long>(Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L))},
        };
    }


    @Test(dataProvider = "number length")
    public void testFibonacciLength(int length, ArrayList<Long> expected) {
        ArrayList<Long> actual = FibonacciRow.fibonacci(length);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "range")
    public void testFibonacciRange(long[] ranges, ArrayList<Long> expected) {
        ArrayList<Long> actual = FibonacciRow.fibonacci(ranges[0], ranges[1]);
        assertEquals(actual, expected);
    }


    @Test(expectedExceptions = {NumberFormatException.class})
    public void testFibonacciLength_With_20_length() {
        FibonacciRow.fibonacci(20);
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void testFibonacciLength_With_Negative1_length() {
        FibonacciRow.fibonacci(-1);
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void testFibonacciRange_With_Start_4_End_2() {
        FibonacciRow.fibonacci(4, 2);
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void testFibonacciRange_With_Start_Negative2_End_2() {
        FibonacciRow.fibonacci(-2, 2);
    }
}
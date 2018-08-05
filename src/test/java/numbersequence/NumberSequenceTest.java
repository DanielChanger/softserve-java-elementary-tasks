package numbersequence;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static numbersequence.NumberSequence.numberSequenceCreator;
import static org.testng.Assert.assertEquals;
public class NumberSequenceTest {


    @DataProvider(name = "illegal args for creator")
    public static Object[][] getInvalidArgs() {
        return new Object[][]{
                {0, 0},
                {0, 2},
                {-3, 0},
                {0, -4},
                {-6, -8},
                {10000000000L, 0}};

    }

    @DataProvider(name = "valid args for initSequence")
    public static Object[][] getValidArgs() {
        return new Object[][]{
                {5, -12, new int[]{1, 2, 3, 4, 5}},
                {3, 4, new int[]{2, 3, 4}},
                {7, 10, new int[]{4, 5, 6, 7, 8, 9, 10}},
                {3, 100, new int[]{10, 11, 12}},
                {2, 4.6, new int[]{3, 4}},
                {12, 0, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}},
                {4, 20, new int[]{5, 6, 7, 8}},
                {6, 1000, new int[]{32, 33, 34, 35, 36, 37}},

        };
    }


    @Test(dataProvider = "illegal args for creator", expectedExceptions = IllegalArgumentException.class)
    public void testNumberSequenceCreator(int length, double minSquare) {
        numberSequenceCreator(length, minSquare);
    }

    @Test(dataProvider = "valid args for initSequence")
    public void testGetSequence(int length, double minSquare, int[] expected) {
        NumberSequence numberSequence = NumberSequence.numberSequenceCreator(length, minSquare);
        int[] actual = numberSequence.getSequence();
        assertEquals(actual, expected);
    }
}
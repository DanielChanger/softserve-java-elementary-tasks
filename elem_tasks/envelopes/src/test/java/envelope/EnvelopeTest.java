package envelope;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EnvelopeTest {

    @DataProvider(name = "invalid args for envelope creator")
    public static Object[][] getInvalidParams() {
        return new Object[][]{
                {0, 0}, // vertical and horizontal sides
                {12, 0},
                {0, 4},
                {-35, 0},
                {0, -10},
                {21, -1},
                {-7, 2},
                {-9, -15},
        };
    }

    @DataProvider(name = "valid args for isFitInto test")
    public static Object[][] getValidParamsForIsFitTest() {
        return new Object[][]{
                /*
                First two values are Envelope A's sides,
                next two values are Envelope B's sides
                and the last one is the expected value.
                 */
                {10, 20, 20, 10, false},
                {30, 45, 29.9, 44.9, false},
                {10, 20, 2, 1, false},
                {15, 20, 30, 40, true},
                {50.9, 20.1, 51, 20.15, true},
                {50.9, 20.1, 20.15, 51, true},
                {21, 1, 13, 24, true},
                {1, 2, 2.5, 0.5, false},
                {3, 5, 2, 6, false},
        };
    }

    @DataProvider(name = "valid args for compareTo test")
    public static Object[][] getValidParamsForCompareTo() {
        return new Object[][]{
                /*
                First two values are Envelope A's sides,
                next two values are Envelope B's sides
                and the last one is the expected value.
                 */
                {10, 20, 20, 10, 0},
                {30, 45, 29.9, 44.9, 1},
                {10, 20, 2, 1, 1},
                {15, 20, 30, 40, -1},
                {50.9, 20.1, 51, 20.15, -1},
                {50.9, 20.1, 20.15, 51, -1},
                {21, 1, 13, 24, -1},
                {1, 2, 2.5, 0.5, 0},
                {3, 5, 2, 6, 0},
        };
    }

    @Test(dataProvider = "invalid args for envelope creator", expectedExceptions = IllegalArgumentException.class)
    public void testEnvelopeCreator(double verticalSide, double horizontalSide) {
        Envelope.createEnvelope(verticalSide, horizontalSide);
    }

    @Test(dataProvider = "valid args for isFitInto test")
    public void testIsFitInto(double verticalSideA, double horizontalSideA,
                              double verticalSideB, double horizontalSideB,
                              boolean expected) {
        Envelope A = Envelope.createEnvelope(verticalSideA, horizontalSideA);
        Envelope B = Envelope.createEnvelope(verticalSideB, horizontalSideB);
        boolean actual = A.isFitInto(B);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "valid args for compareTo test")
    public void testCompareTo(double verticalSideA, double horizontalSideA,
                              double verticalSideB, double horizontalSideB,
                              int expected) {
        Envelope A = Envelope.createEnvelope(verticalSideA, horizontalSideA);
        Envelope B = Envelope.createEnvelope(verticalSideB, horizontalSideB);
        int actual = A.compareTo(B);
        assertEquals(actual, expected);
    }
}
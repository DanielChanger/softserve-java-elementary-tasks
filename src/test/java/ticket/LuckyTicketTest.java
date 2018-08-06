package ticket;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class LuckyTicketTest {
    static Method simple;
    static Method complex;

    @DataProvider(name = "invalid numbers")
    public static Object[][] getInvalidNumbers() {

        return new Object[][]{
                {"-000001", "999999"},
                {"a000001", "999999"},
                {"000010", "one hundred thousands"},
                {"014301", "-136134"},
                {"00b001", "234612"},
                {"234125", "Hello"},
                {"", "141251"},
                {"216726", ""},
                {"000001", "000000"},
        };
    }

    @DataProvider(name = "valid numbers")
    public static Object[][] getValidNumbers() {

        return new Object[][]{
                {"000001", "999999"},
                {"000001", "467545"},
                {"000010", "847535"},
                {"043164", "146724"},
                {"000001", "000001"},
                {"124663", "136713"},
        };
    }

    @DataProvider(name = "valid numbers for checking correctness of calculating")
    public static Object[][] getValidNumbersForCalcCheck() {
        return new Object[][]{
                {"000000", "999999", new int[]{55252, 25081}},
                {"000000", "000005", new int[]{1, 1}},
                {"000100", "000105", new int[]{0, 0}},
                {"999994", "999999", new int[]{1, 0}},
                {"422232", "422240", new int[]{1, 1}},
        };
    }


    @Test(dataProvider = "invalid numbers", expectedExceptions = {IllegalArgumentException.class, NullPointerException.class})
    public void testNumberOfTicketsWithInvalidValues(String numberMinimum, String numberMaximum) {
        LuckyTicket.numberOfTickets(numberMinimum, numberMaximum);
    }


    @Test(dataProvider = "valid numbers")
    @DisplayName("")
    public void testNumberOfTicketsWithValidValuesForExceptions(String numberMinimum, String numberMaximum) {
        Exception ex = null;
        try {
            LuckyTicket.numberOfTickets(numberMinimum, numberMaximum);
        } catch (Exception e) {
            ex = e;
        }
        assertNull(ex);
    }


    @BeforeMethod
    static void makeSimpleAndComplexMethodsAccessible() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        simple = LuckyTicket.class.getDeclaredMethod("simpleMethod", String.class, String.class);
        complex = LuckyTicket.class.getDeclaredMethod("complexMethod", String.class, String.class);
        simple.setAccessible(true);
        complex.setAccessible(true);
    }


    @Test(dataProvider = "valid numbers for checking correctness of calculating")
    public void testNumberOfTicketsWithValidValuesForCorrectCalculating(String numberMinimum, String numberMaximum, int[] expected) throws InvocationTargetException, IllegalAccessException {
        int[] actual = {(int) simple.invoke(null, numberMinimum, numberMaximum), (int) complex.invoke(null, numberMinimum, numberMaximum)};
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
        assertTrue(Arrays.equals(expected, actual));
    }
}
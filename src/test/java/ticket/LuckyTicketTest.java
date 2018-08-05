package ticket;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;

public class LuckyTicketTest {

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
                {"000001", "999999"},
                {"000000", "000005"},
                {"000100", "000105"},
                {"043164", "146724"},
                {"000001", "000001"},
                {"124663", "136713"},
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

    @Test(dataProvider = "valid numbers for checking correctness of calculating")
    public void testNumberOfTicketsWithValidValuesForCorrectCalculating(String numberMinimum, String numberMaximum) {

    }
}
package ticket;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.EclipseInterface;

import static org.testng.Assert.*;

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

    @DataProvider(name = "command-line invalid arguments")
    public static Object[][] getCMValidArgs() {

        return new Object[][]{
                {"999999"},
                {"847535", "643164", "146724"},

        };
    }

    @DataProvider(name = "command-line valid arguments")
    public static Object[][] getCMInvalidArgs() {

        return new Object[][]{
                {null},
                {"000001", "999999"},
                {"010101", "101010"},
                {"513625", "847535"},
                {"043164", "146724"},
        };
    }

    @Test(dataProvider = "invalid numbers", expectedExceptions = {IllegalArgumentException.class, NullPointerException.class})
    public void testNumberOfTicketsWithInvalidValues(String numberMinimum, String numberMaximum) {
        LuckyTicket.numberOfTickets(numberMinimum, numberMaximum);
    }


    @Test(dataProvider = "valid numbers")
    public void testNumberOfTicketsWithValidValues(String numberMinimum, String numberMaximum) {
        Exception ex = null;
        try {
            LuckyTicket.numberOfTickets(numberMinimum, numberMaximum);
        } catch (Exception e) {
            ex = e;
        }
        assertNull(ex);
    }

    @Test(dataProvider = "command-line invalid arguments", expectedExceptions = {Exception.class})
    public void testNumberOfTicketsMain_Invalid_Args(String[] args) {
        if (args.length == 1) {
            LuckyTicket.main(new String[]{args[0]});
        } else {
            LuckyTicket.main(new String[]{args[0]});
        }
    }

    @Test(dataProvider = "command-line valid arguments")
    public void testNumberOfTicketsMain_Valid_Args(String[] args) {
        Exception ex = null;
        try {
            if (args == null) {
                LuckyTicket.main(new String[0]);
            } else {
                LuckyTicket.main(new String[]{args[0], args[1]});
            }
        } catch (Exception e) {
            ex = e;
        }
        assertNull(ex);

    }
}
package numbertostring;

import java.util.HashMap;
import java.util.Map;


/**
 * <h1>Number converter</h1>
 *
 * <p>Converts a number from -999 999 999 999 to +999 999 999 999 to its string representation.</p>
 *
 * @author Daniel Changer.
 * @version 1.1.
 */
public class NumberToString {

    //Constants for common use
    private static final long TEN = 10;
    private static final long TWENTY = 20;
    private static final long ONE_HUNDRED = 100;
    private static final long ONE_THOUSAND = 1_000;
    private static final long ONE_MILLION = 1_000_000;
    private static final long ONE_BILLION = 1_000_000_000;
    private static final long ONE_TRILLION = 1_000_000_000_000L;

    //Maps of unique numbers
    private static final Map<Long, String> UNITS = new HashMap<>();
    private static final Map<Long, String> TENS = new HashMap<>();
    private static final Map<Long, String> HUNDREDS = new HashMap<>();

    static {
        UNITS.put(0L, "ноль");
        UNITS.put(1L, "один");
        UNITS.put(2L, "два");
        UNITS.put(3L, "три");
        UNITS.put(4L, "четыре");
        UNITS.put(5L, "пять");
        UNITS.put(6L, "шесть");
        UNITS.put(7L, "семь");
        UNITS.put(8L, "восемь");
        UNITS.put(9L, "девять");
        UNITS.put(10L, "десять");
        UNITS.put(11L, "одиннадцать");
        UNITS.put(12L, "двенадцать");
        UNITS.put(13L, "тринадцать");
        UNITS.put(14L, "четырнадцать");
        UNITS.put(15L, "пятнадцать");
        UNITS.put(16L, "шестнадцать");
        UNITS.put(17L, "семнадцать");
        UNITS.put(18L, "восемнадцать");
        UNITS.put(19L, "девятнадцать");

        TENS.put(2L, "двадцать");
        TENS.put(3L, "тридцать");
        TENS.put(4L, "сорок");
        TENS.put(5L, "пятьдесят");
        TENS.put(6L, "шестьдесят");
        TENS.put(7L, "семьдесят");
        TENS.put(8L, "восемьдесят");
        TENS.put(9L, "девяносто");

        HUNDREDS.put(1L, "сто");
        HUNDREDS.put(2L, "двести");
        HUNDREDS.put(3L, "триста");
        HUNDREDS.put(4L, "четыреста");
        HUNDREDS.put(5L, "пятьсот");
        HUNDREDS.put(6L, "шестьсот");
        HUNDREDS.put(7L, "семьсот");
        HUNDREDS.put(8L, "восемьсот");
        HUNDREDS.put(9L, "девятьсот");
    }


    /**
     * Method takes a number to be converted and compares it
     * with constant values to define.
     *
     * @param number number to be represented as a string
     * @return converted string number
     */
    public static String convert(long number) {
        String result;
        if (number < 0) {
            result = "минус " + convert(Math.abs(number));

        } else if (number < TWENTY) {
            result = UNITS.get(number);

        } else if (number < ONE_HUNDRED) {
            //divide by 10 to get number decades
            result = (TENS.get(number / TEN)
                //if number ends with zero - doesn't output it
                //else outputs units
                + (number % TEN > 0 ? " "
                + convert(number % TEN) : ""));

        } else if (number < ONE_THOUSAND) {
            //divide by 100 to get number hundreds
            result = (HUNDREDS.get(number / ONE_HUNDRED)
                //if number ends with zeroes - doesn't output 'em
                //else outputs decades and units
                + (number % ONE_HUNDRED > 0 ? " "
                + convert(number % ONE_HUNDRED) : ""));

        } else if (number < ONE_MILLION) {
            //divide by 1000 to get number thousands
            result = getEndingForThousands(convert((number / ONE_THOUSAND)))
                //if number ends with zeros - doesn't output 'em
                + (number % ONE_THOUSAND > 0 ? " "
                + convert(number % ONE_THOUSAND) : "");

        } else if (number < ONE_BILLION) {
            //divide by million to get number millions
            result = getEndingForMillions(convert((number / ONE_MILLION)))
                + " "
                //divide by million and then divide by thousand to get number thousands
                + getEndingForThousands(convert(((number % ONE_MILLION) / ONE_THOUSAND)))

                + (number % ONE_THOUSAND > 0 ? " "
                + convert(number % ONE_THOUSAND) : "");

        } else if (number < ONE_TRILLION) {
            //divide by billion to get number billions
            result = getEndingForBillions(convert((number / ONE_BILLION)))
                + " "
                //divide by billion and then divide by million to get number millions
                + getEndingForMillions(convert((number % ONE_BILLION) / ONE_MILLION))
                + " "
                //divide by billion, then by million and then divide by thousand to get number thousands
                + getEndingForThousands(convert(((number % ONE_BILLION) % ONE_MILLION) / ONE_THOUSAND))
                //if number ends with zeros - doesn't output 'em
                //else outputs hundreds and decades and units
                + (number % ONE_THOUSAND > 0 ? " "
                + convert(number % ONE_THOUSAND) : "");

        } else {
            return "This number is not supported";
        }

        return result.replaceAll(" {2,}", " "); // to avoid double whitespaces
    }


    /**
     * Method take string representation of a number of thousands
     * and depending on what is the ending of a parameter value
     * it decides what to append to make output correct
     *
     * @param str String representation of number of thousands
     * @return correct string interpretation of thousands
     */
    private static String getEndingForThousands(String str) {
        if (str.equals("ноль")) {
            return "";
        } else if (str.endsWith("один")) {
            return str.replace("один", "одна тысяча");

        } else if (str.endsWith("два")) {
            return str.replace("два", "две тысячи");

        } else if (str.endsWith("три") || str.endsWith("четыре")) {
            return str + " тысячи";

        } else {
            return str + " тысяч";
        }
    }


    /**
     * Method take string representation of a number of millions
     * and depending on what is the ending of a parameter value
     * it decides what to append to make correct output
     *
     * @param str String representation of number of millions
     * @return correct string interpretation of millions
     */
    private static String getEndingForMillions(String str) {
        if (str.equals("ноль")) {
            return "";

        } else if (str.endsWith("один")) {
            return str + " миллион";

        } else if (str.endsWith("два") || str.endsWith("три") || str.endsWith("четыре")) {
            return str + " миллиона";

        } else {
            return str + " миллионов";
        }
    }

    /**
     * Method take string representation of a number of billions
     * and depending on what is the ending of a parameter value
     * it decides what to append to make output correct
     *
     * @param str String representation of number of billions
     * @return correct string interpretation of billions
     */
    private static String getEndingForBillions(String str) {
        if (str.equals("ноль")) {
            return "";

        } else if (str.endsWith("один")) {
            return str + " миллиард";

        } else if (str.endsWith("два") || str.endsWith("три") || str.endsWith("четыре")) {
            return str + " миллиарда";

        } else {
            return str + " миллиардов";
        }
    }
}

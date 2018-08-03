package ticket;

import java.util.regex.Pattern;

/**
 * <h1>Lucky ticket.</h1>
 *
 * <p>This app outputs a number of lucky tickets within user-defined range and<br>
 * defines which method of counting lucky tickets finds more lucky tickets <br>
 * on a defined range.
 *
 * @author Daniel Changer.
 * @version 1.0.
 * @since 2018-07-26.
 */
public class LuckyTicket {

    private final static int LENGTH_OF_NUMBER = 6;


    /**
     * This method is an entry point of counting tickets. It validates parameters and calls
     * simpleMethod and complexMethod
     *
     * @param min Minimal user-defined number of ticket
     * @param max Maximum user-defined number of ticket
     * @return It returns a string, that says which method found more lucky tickets within a range, or
     * tells user about incorrect parameters (in this option methods simpleMethod and
     * complexMethod will not launch)
     */
    public static String numberOfTickets(String min, String max) throws IllegalArgumentException, NullPointerException {

        int counterSimple = simpleMethod(min, max);
        int counterComplex = complexMethod(min, max);
        if (counterSimple > counterComplex) {
            return "Simple method counted more lucky tickets than a complex one — Simple: "
                    + counterSimple
                    + " vs Complex: "
                    + counterComplex;
        } else if (counterSimple < counterComplex) {
            return "Complex method counted more lucky tickets than a simple one — Complex: "
                    + counterComplex
                    + " vs Simple: "
                    + counterSimple;
        } else {
            return "Simple and complex methods counted equivalent number of lucky tickets";
        }
    }

    private void validateParams(String min, String max) {
        Pattern pattern = Pattern.compile("[0-9]{6}");

        if (!pattern.matcher(min).matches() || !pattern.matcher(max).matches()) {
            throw new IllegalArgumentException("One or both parameters are incorrect. \n"
                    + "You should enter two numbers in a following + way: 000001, 101010, 242156 etc.");
        }
        if (Integer.parseInt(min) > Integer.parseInt(max)) {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum");
        }
    }

    /**
     * Simple method that counts lucky tickets within a range in a specific way: if sum of left 3
     * numbers equals to sum of right 3 numbers of a ticket number, then the ticket is lucky
     *
     * @param min Minimal user-defined number of ticket
     * @param max Maximum user-defined number of ticket
     * @return Number of found lucky tickets
     */
    private static int simpleMethod(String min, String max) {
        StringBuilder ticketNumber = new StringBuilder();
        int counter = 0;
        int sumOfLeftPart;
        int sumOfRightPart;
        for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {
            sumOfLeftPart = sumOfRightPart = 0;
            ticketNumber.append(i);
            while (ticketNumber.length() < LENGTH_OF_NUMBER) {
                ticketNumber.insert(0, 0);
            }
            for (int j = 0; j < LENGTH_OF_NUMBER / 2; j++) {
                sumOfLeftPart += Integer.parseInt(ticketNumber.charAt(j) + "");
                sumOfRightPart += Integer.parseInt(ticketNumber.charAt(j + 3) + "");
            }
            if (sumOfLeftPart == sumOfRightPart) {
                counter++;
            }
            ticketNumber.delete(0, 6);
        }

        return counter;
    }

    /**
     * Complex method that counts lucky tickets within a range in a specific way: if sum of even numbers
     * equals to sum of odd numbers numbers of a ticket number, then the ticket is lucky
     *
     * @param min Minimal user-defined number of ticket
     * @param max Maximum user-defined number of ticket
     * @return Number of found lucky tickets
     */
    private static int complexMethod(String min, String max) {
        StringBuilder ticketNumber = new StringBuilder();
        int counter = 0;
        int sumOfEven = 0;
        int sumOfOdd = 0;
        for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {
            sumOfEven = sumOfOdd = 0;
            ticketNumber.append(i);
            while (ticketNumber.length() < LENGTH_OF_NUMBER) {
                ticketNumber.insert(0, 0);
            }
            for (int j = 0; j < LENGTH_OF_NUMBER; j++) {
                if (Integer.parseInt(ticketNumber.charAt(j) + "") % 2 == 0) {
                    sumOfEven += Integer.parseInt(ticketNumber.charAt(j) + "");
                } else {
                    sumOfOdd += Integer.parseInt(ticketNumber.charAt(j) + "");
                }
            }
            if (sumOfEven == sumOfOdd) {
                counter++;
            }
            ticketNumber.delete(0, 6);
        }
        return counter;
    }

}
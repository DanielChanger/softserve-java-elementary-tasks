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
        Pattern pattern = Pattern.compile("[0-9]{6}");

        if (!pattern.matcher(min).matches() || !pattern.matcher(max).matches()) {
            throw new IllegalArgumentException("One or both parameters are incorrect. \n"
                    + "You should enter two numbers in a following + way: 000001, 101010, 242156 etc.");
        }
        if (Integer.parseInt(min) > Integer.parseInt(max)) {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum");
        }
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
        int sumOfLeftPart = 0;
        int sumOfRightPart = 0;
        for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {
            ticketNumber.append(i);
            while (ticketNumber.length() < 6) {
                ticketNumber.insert(0, 0);
            }
            //System.out.println(ticketNumber);
            for (int j = 0; j < 3; j++) {
                sumOfLeftPart += Integer.parseInt(ticketNumber.charAt(j) + "");
                sumOfRightPart += Integer.parseInt(ticketNumber.charAt(j + 3) + "");
            }
            if (sumOfLeftPart == sumOfRightPart) {
                counter++;
            }
            ticketNumber.delete(0, 6);
            sumOfLeftPart = sumOfRightPart = 0;
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
            ticketNumber.append(i);
            while (ticketNumber.length() < 6) {
                ticketNumber.insert(0, 0);
            }
            for (int j = 0; j < 6; j++) {
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
            sumOfEven = sumOfOdd = 0;
        }
        return counter;
    }

    /**
     * Method to test class.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            info();
        } else if (args.length != 2) {
            throw new IllegalArgumentException("You should have entered exactly two arguments.");
        } else {
            try {
                System.out.println(LuckyTicket.numberOfTickets(args[0], args[1]));
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void info() {
        System.out.println(
                "\tThis program counts lucky tickets within numerical limits defined by user.\n"
                        + "It counts using two methods at a time: simple and complex.\n"
                        + "At the and of the program it will show you two numbers of lucky tickets counted \n"
                        + "with two methods and define which method will count more tickets than another within \n"
                        + "a specific limit of numbers defined by users in command-line arguments. User have to enter\n "
                        + "two valid numbers numbers in a following way: 000001, 101010, 242156 etc.\n");
    }
}

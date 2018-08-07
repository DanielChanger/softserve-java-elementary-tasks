package fibonacci;

import java.util.ArrayList;

public class FibonacciRow {

    /**
     * Outputs fibonacci sequence with numbers, which length are defined
     * with a parameter lengthOfNumber
     *
     * @param lengthOfNumber length of fibonacci number to be output
     * @return fibonacci sequence
     * @throws NumberFormatException throws if length is less than 0 and
     *                               greater than 19 (system cannot handle greater numbers)
     */
    public static ArrayList<Long> fibonacci(int lengthOfNumber) throws NumberFormatException {
        if (lengthOfNumber < 0) {
            throw new NumberFormatException("Length of number cannot be negative");
        }
        if (lengthOfNumber >= 20) {
            throw new NumberFormatException("Program cannot handle more than 19 rank number");
        }
        ArrayList<Long> row = new ArrayList<>();
        long a = 0;
        long b = 1;

        while (Long.toString(a).length() <= lengthOfNumber) {
            if (Long.toString(a).length() == lengthOfNumber) {
                row.add(a);
            }
            if (Long.toString(b).length() == lengthOfNumber) {
                row.add(b);
            }
            a += b;
            b += a;
        }
        return row;
    }

    /**
     * Outputs fibonacci sequence with numbers within a range defined
     * with parameters start and end
     *
     * @param start the lowest boundary of fibonacci sequence
     * @param end   the highest boundary of fibonacci sequence
     * @return fibonacci sequence
     * @throws NumberFormatException
     */
    public static ArrayList<Long> fibonacci(long start, long end) throws NumberFormatException {
        if (start < 0 || end < 0) {
            throw new NumberFormatException("This algorithm is only for positive set of numbers");
        }
        if (start > end) {
            throw new NumberFormatException("Start argument should be more or equals to end argument");
        }
        ArrayList<Long> row = new ArrayList<>();
        long a = 0;
        long b = 1;
        while (a < start && b < start) {
            a += b;
            b += a;
        }
        if (a < start) {
            row.add(b);
            a += b;
            b += a;
        }

        while (b <= end || a <= end) {
            if (a <= end) {
                row.add(a);
            }
            if (b <= end) {
                row.add(b);
            }
            a += b;
            b += a;
        }
        return row;
    }



}

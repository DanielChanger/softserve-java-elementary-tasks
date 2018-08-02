package fibonacci;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciRow {

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



    public static void info() {System.out.println("");}


    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                FibonacciRow.info();
            } else if (args.length == 1 && args[0].matches("[-]?[0-9]+")) {
                ArrayList<Long> row = FibonacciRow.fibonacci(Integer.parseInt(args[0]));
                for (Long temp : row) {
                    System.out.print(temp + " ");
                }
            } else if (args.length == 2 && args[0].matches("[-]?[0-9]+") && args[1].matches("[-]?[0-9]+")) {
                ArrayList<Long> row =
                        FibonacciRow.fibonacci(Long.parseLong(args[0]), Long.parseLong(args[1]));
                for (Long temp : row) {
                    System.out.print(temp + " ");
                }
            } else {
                System.out.println(
                        "Arguments must be integers and there only\n"
                                + "from 0 to 2 number of arguments are allowed to enter!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

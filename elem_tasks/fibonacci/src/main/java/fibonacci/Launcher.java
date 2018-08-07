package fibonacci;

import java.util.ArrayList;

public class Launcher {
    public static void info() {
        System.out.println("This program outputs fibonacci numbers. If user inputs 1 argument,\n" +
            "then it will be considered as a length of numbers, that program have to output. If 2 args were passed,\n" +
            "then they are considered as range (for instance, from 0 to 1000, both inclusively) and program ought to\n" +
            "output fibonacci numbers within it.");
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                info();
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

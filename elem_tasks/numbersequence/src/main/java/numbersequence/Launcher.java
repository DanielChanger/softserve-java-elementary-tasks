package numbersequence;

import java.util.Arrays;

public class Launcher {

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void info() {
        System.out.println("Program outputs a sequence (with pre-defined by user length) of natural numbers,\n"
            + "which square is not less than a user-defined number. Application takes 2 args: length of sequence and\n"
            + "a number. Length cannot be <= 0, though, number is allowed to be any kind\n");
    }


    /**
     * Method to launch app.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                info();
            } else if (args.length != 2) {
                System.out.println("There must be exactly two arguments.");
            } else {
                NumberSequence numberSequence =
                    NumberSequence.createNumberSequence(
                        Integer.parseInt(args[0]), Double.parseDouble(args[1]));
                int[] sequence = numberSequence.getSequence();
                System.out.println(Arrays.toString(sequence).replaceAll("[\\[\\]]", ""));
            }
        } catch (NumberFormatException | OutOfMemoryError e) {
            System.out.println("Number is too large or argument just doesn't suit a numeric type");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}

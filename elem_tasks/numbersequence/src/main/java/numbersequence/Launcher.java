package numbersequence;

import java.util.Arrays;

public class Launcher {
    public static void info() {
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                info();
            } else if (args.length != 2) {
                System.out.println("There must be exactly two arguments.");
            } else {
                NumberSequence numberSequence =
                        NumberSequence.numberSequenceCreator(
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

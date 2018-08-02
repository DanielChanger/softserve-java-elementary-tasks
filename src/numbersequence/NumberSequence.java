package numbersequence;

import java.util.Arrays;

public class NumberSequence {
    private int[] sequence;
    private int length;
    private double minimalSquare;

    private NumberSequence(int length, double minimalSquare) {
        this.length = length;
        this.minimalSquare = minimalSquare;
        sequence = new int[length];
        initSequence();
    }

    public static NumberSequence numberSequenceCreator(int length, double minimalSquare)
            throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        return new NumberSequence(length, minimalSquare);
    }

    private void initSequence() {
        if (minimalSquare <= 0) {
            for (int i = 0; i < length; i++) {
                sequence[i] = i + 1;
            }
        } else {
            int startNum = (int) Math.sqrt(minimalSquare);
            for (int i = startNum, j = 0; j < length; i++) {
                if (Math.pow(i, 2) >= minimalSquare) {
                    sequence[j++] = i;
                }
            }
        }
    }

    public int[] getSequence() {
        return sequence;
    }

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("There must be exactly two arguments.");
            } else if (args[0].matches("^\\s*[-]?[0-9]+\\s*") && args[1].matches("^\\s*[-]?[0-9]+[.]?[0-9]*\\s*")) {
                NumberSequence numberSequence =
                        NumberSequence.numberSequenceCreator(
                                Integer.parseInt(args[0]), Double.parseDouble(args[1]));
                int[] sequence = numberSequence.getSequence();
                System.out.println(Arrays.toString(sequence).replaceAll("[\\[\\]]", ""));
            } else {
                System.out.println(
                        "Arguments must have a numeric type. First argument must be an integer,\n"
                                + "second can be either integer or with decimal part (separated with dot)");
            }
        } catch (NumberFormatException | OutOfMemoryError e) {
            System.out.println("Number is too large or too small");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}

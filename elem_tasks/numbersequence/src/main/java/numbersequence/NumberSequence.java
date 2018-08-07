package numbersequence;

public class NumberSequence {
    /**
     * sequence itself.
     */
    private int[] sequence;
    /**
     * length of sequence.
     */
    private int length;

    /**
     *
     */
    private double minimalSquare;

    private NumberSequence(int length, double minimalSquare) {
        this.length = length;
        this.minimalSquare = minimalSquare;
        sequence = new int[length];
        initSequence();
    }

    public static NumberSequence createNumberSequence(int length, double minimalSquare)
            throws IllegalArgumentException, OutOfMemoryError {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be negative or zero");
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


}

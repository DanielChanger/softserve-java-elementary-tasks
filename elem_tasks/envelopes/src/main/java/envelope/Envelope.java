package envelope;

/**
 * <h1>Envelopes analyzer.</h1>
 *
 * <p>This app aks user to enter two sides of envelope A and envelope B respectively. Then program
 * automatically defines, which envelope can fit another<br>
 * on a defined range.
 *
 * @author Daniel Changer.
 * @version 1.0.
 * @since 2018-07-26.
 */
public class Envelope implements Comparable<Envelope> {

    /**
     * Size of vertical side of an envelope.
     */
    private double verticalSide;

    /**
     * Size of horizontal side of an envelope.
     */
    private double horizontalSide;

    /**
     * Constructor of envelope.
     *
     * @param verticalSide   Size of vertical side of envelope.
     * @param horizontalSide Size of horizontal side of envelope.
     */
    private Envelope(double verticalSide, double horizontalSide) {
        this.verticalSide = verticalSide;
        this.horizontalSide = horizontalSide;
    }

    /**
     * @param verticalSide   vertical side of envelope
     * @param horizontalSide horizontal side of envelope
     * @return envelope object with user-defined horizontal and vertical sides
     * @throws IllegalArgumentException occurs if user tries to create envelope with sides <= 0
     */
    public static Envelope envelopeCreator(double verticalSide, double horizontalSide) throws IllegalArgumentException {
        if (verticalSide <= 0 || horizontalSide <= 0) {
            throw new IllegalArgumentException("Envelope cannot consist of negative or zero attributes");
        }
        return new Envelope(verticalSide, horizontalSide);
    }


    /**
     * @param envelope third-party envelope to try to fit into
     * @return if result < 0 then calling envelope can be fitted into envelope from parameters,
     * else if cannot.
     */
    public boolean isFitInto(Envelope envelope) {
        return this.compareTo(envelope) < 0;
    }


    /**
     * Method to compare two Envelope objects
     *
     * @param o Envelope object to be compared to
     * @return Returns 0 if envelopes equal to each other or they cannot fit into each other, 1 if envelope
     * that calls method is bigger than the one from parameter, and -1 if it's smaller.
     */
    @Override
    public int compareTo(Envelope o) {
        if ((horizontalSide > o.horizontalSide && verticalSide > o.verticalSide)
                || (horizontalSide > o.verticalSide
                && verticalSide > o.horizontalSide)) {
            return 1;

        } else if ((horizontalSide < o.horizontalSide && verticalSide < o.verticalSide)
                || (horizontalSide < o.verticalSide
                && verticalSide < o.horizontalSide)) {
            return -1;
        } else {
            return 0;
        }
    }
}

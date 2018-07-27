package envelope;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
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

  /** Size of vertical side of an envelope. */
  private double verticalSide;

  /** Size of horizontal side of an envelope. */
  private double horizontalSide;

  /**
   * Constructor of envelope.
   *
   * @param verticalSide Size of vertical side of envelope.
   * @param horizontalSide Size of horizontal side of envelope.
   */
  public Envelope(double verticalSide, double horizontalSide) {
    this.verticalSide = verticalSide;
    this.horizontalSide = horizontalSide;
  }

  private Envelope changeOrientation() {
    return new Envelope(horizontalSide, verticalSide);
  }

  /**
   * Returns size of envelope horizontal side.
   *
   * @return Size of vertical side of the envelope.
   */
  public double getHorizontalSide() {
    return horizontalSide;
  }

  /**
   * Sets new value of horizontal side of the envelope.
   *
   * @param horizontalSide new horizontal side value
   */
  public void setHorizontalSide(double horizontalSide) {
    this.horizontalSide = horizontalSide;
  }

  /**
   * Returns size of envelope vertical side.
   *
   * @return Size of vertical side of the envelope.
   */
  public double getVerticalSide() {
    return verticalSide;
  }

  /**
   * Sets new value of vertical side of the envelope.
   *
   * @param verticalSide new vertical side value.
   */
  public void setVerticalSide(double verticalSide) {
    this.verticalSide = verticalSide;
  }

  /**
   * Method for testing class.
   *
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    Scanner scanner;
    Pattern pattern = Pattern.compile("(y|yes)", Pattern.CASE_INSENSITIVE);
    String choice;
    Envelope envelopeA;
    Envelope envelopeB;
    Double[] sides;
    do {
      choice = null;
      scanner = null;
      sides = new Double[4];
      System.out.println("Envelope A");
      System.out.print("Vertical side: ");
      scanner = new Scanner(System.in);
      if (!scanner.hasNextDouble() || (sides[0] = scanner.nextDouble()) <= 0) {
        System.out.println(
            "Please, enter a positive double value using comma to separate a whole and a decimal part\n\n");
        continue;
      } else {
        System.out.print("Horizontal side: ");
        scanner = new Scanner(System.in);
        if (!scanner.hasNextDouble() || (sides[1] = scanner.nextDouble()) <= 0) {
          System.out.println(
              "Please, enter a positive double value using comma to separate a whole and a decimal part\n\n");
          continue;
        } else {
          System.out.println("\nEnvelope B");
          System.out.print("Vertical side: ");
          scanner = new Scanner(System.in);
          if (!scanner.hasNextDouble() || (sides[2] = scanner.nextDouble()) <= 0) {
            System.out.println(
                "Please, enter a positive double value using comma to separate a whole and a decimal part\n\n");
            continue;
          } else {
            System.out.print("Horizontal side: ");
            scanner = new Scanner(System.in);
          }
          if (!scanner.hasNextDouble() || (sides[3] = scanner.nextDouble()) <= 0) {
            System.out.println(
                "Please, enter a positive double value using comma to separate a whole and a decimal part\n\n");
            continue;
          } else {
            envelopeA = new Envelope(sides[0], sides[1]);
            envelopeB = new Envelope(sides[2], sides[3]);

            if (envelopeA.compareTo(envelopeB) == 0) {
              System.out.println("Envelopes equal or just cannot cannot be put in each other ");
            } else if (envelopeA.compareTo(envelopeB) < 0) {
              System.out.println("Envelope A can be put in envelope B");
            } else if (envelopeA.compareTo(envelopeB) > 0) {
              System.out.println("Envelope B can be put in envelope A");
            } else {
              System.out.println("Envelopes don't fit each other");
            }
          }
        }
      }

      System.out.print("\nDo you want to try again? ");
      scanner = new Scanner(System.in);
      choice = scanner.next();
      System.out.println("\n");
    } while (choice == null || pattern.matcher(choice).matches());
  }

  /**
   * Method to compare two envelope.Envelope objects
   *
   * @param o envelope.Envelope object to be compared to
   * @return Returns 0 if envelopes equal to each other or they cannot fit each other, 1 if envelope
   *     that calls method is bigger than the one from parameter, and -1 if it's smaller.
   */
  @Override
  public int compareTo(Envelope o) {
    if (horizontalSide == o.horizontalSide && verticalSide == o.verticalSide
        || horizontalSide == o.changeOrientation().horizontalSide
            && verticalSide == o.changeOrientation().verticalSide) {
      return 0;
    } else if ((horizontalSide >= o.horizontalSide && verticalSide >= o.verticalSide)
        || (horizontalSide >= o.changeOrientation().horizontalSide
            && verticalSide >= o.changeOrientation().verticalSide)) {
      return 1;

    } else if ((horizontalSide <= o.horizontalSide && verticalSide <= o.verticalSide)
        || (horizontalSide <= o.changeOrientation().horizontalSide
            && verticalSide <= o.changeOrientation().verticalSide)) {
      return -1;
    } else {
      return 0;
    }
  }

  /**
   * Method, which displays the rules of using this program, if there are no arguments passed from
   * the command-line.
   */
  public static void info() {
    System.out.println(
        "This app aks user to enter two sides of envelope A and envelope B respectively. \n"
            + "Then program automatically defines, which envelope can fit another.\n"
            + " Program asks user to enter a value, one at a time. \n"
            + "Value mustn't be negative and if it contains a whole and a decimal part,\n"
            + " it must be separated with a comma, not a dot ");
  }
}

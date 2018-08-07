package envelope;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Launcher {

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void printInfo() {
        System.out.println(
            "This program asks user to enter vertical and horizontal sides\n"
                + "for envelope A and envelope B both respectively."
                + "Then it tells if some of envelope can fit into another.\n"
                + "If user wants to repeat procedure with new envelopes he types y or yes (case insensitive)\n"
                + "after the question \"Would you like to try again?\"");
    }

    /**
     * Method to launch app.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        // locale for inputting double values with dot delimiter
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        final String agreement = "(?i)(y|yes)";

        /*
        Array for temporary saving sides of both of envelopes.
        vertical side of A envelope = sides[0]
        horizontal side of A envelope = sides[1]
        vertical side of B envelope = sides[2]
        horizontal side of B envelope = sides[3]
         */
        double sides[] = new double[4];

        do {

            try {
                for (int i = 0; i < sides.length; i++) {
                    switch (i) {
                        case 0:
                            System.out.print("\nEnvelope A\nVertical side: ");
                            break;
                        case 1:
                            System.out.print("\nHorizontal side: ");
                            break;
                        case 2:
                            System.out.print("\nEnvelope B\nVertical side: ");
                            break;
                        case 3:
                            System.out.print("\nHorizontal side: ");
                    }
                    sides[i] = scanner.nextDouble();

                }


                Envelope envelopeA;
                Envelope envelopeB;
                envelopeA = Envelope.createEnvelope(sides[0], sides[1]);
                envelopeB = Envelope.createEnvelope(sides[2], sides[3]);

                if (envelopeA.isFitInto(envelopeB)) {
                    System.out.println("\nEnvelope A can be put in envelope B\n");
                } else if (envelopeB.isFitInto(envelopeA)) {
                    System.out.println("\nEnvelope B can be put in envelope A\n");
                } else {
                    System.out.println("\nNeither of them can fit into each other\n");
                }

                System.out.print("\nWould you like to try again? ");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong arguments entered");
                printInfo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (scanner.next().matches(agreement));
        scanner.close();
    }
}

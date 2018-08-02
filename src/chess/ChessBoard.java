package chess;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Chess board.</h1>
 *
 * <p>This app is simply displays chess board with user-defined size.
 *
 * @author Daniel Changer.
 * @version 1.1.
 * @since 2018-07-24.
 */
public class ChessBoard {
    /**
     * Height of a chess field.
     */
    private int height;

    /**
     * Width of a chess field.
     */
    private int width;

    /**
     * Constructor for creating specific chess board with user-defined size.
     *
     * @param height count of board cells in a column.
     * @param width  count of board cells in a row.
     */
    private ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /**
     * Method to validate parameters and to build chess board. If parameters are invalid, then it
     * returns null
     *
     * @param height count of board cells in a column.
     * @param width  count of board cells in a row.
     */
    public static ChessBoard chessBoardBuilder(int height, int width)
            throws IllegalArgumentException {
        if (height > 0 && width > 0) {
            return new ChessBoard(height, width);
        } else {
            throw new IllegalArgumentException("Chess board is not created due to illegal arguments");
        }
    }

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void info() {
        System.out.println(
                "This program displays a chess board with custom size.\n"
                        + " You should enter two arguments in numerical representation:\n"
                        + " height and width of the board respectively\n"
                        + "Arguments must be more than 0 or chess board won't be created and exception will be thrown\n");
    }

    /**
     * This method displays chess board itself.
     */
    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }

    /**
     * Method to test class.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        try {
            Pattern pattern = Pattern.compile("^[+-]?\\d+");

            if (args.length == 0) {
                info();
            } else if (args.length != 2) {
                System.out.println("There must be exactly two arguments");
            } else if (pattern.matcher(args[0]).matches() && pattern.matcher(args[1]).matches()) {
                ChessBoard chessBoard =
                        ChessBoard.chessBoardBuilder(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                chessBoard.display();
            } else {
                System.out.println(
                        "Arguments must be integer numbers (Remember, that chess board doesn't have a zero or negative "
                                + "height or width, though, you are allowed to enter only positive whole numbers)\n");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Number is too big or too small");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}

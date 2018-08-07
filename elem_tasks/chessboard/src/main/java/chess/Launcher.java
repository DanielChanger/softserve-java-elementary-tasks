package chess;

import java.util.regex.Pattern;


public class Launcher {


    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void info() {
        System.out.println(
                "This program displays a chess board with custom size.\n"
                        + "You should enter two arguments in numerical representation:\n"
                        + "height and width of the board respectively\n"
                        + "Each argument must be more than 0 or chess board won't be created and exception will be thrown\n");
    }

    /**
     * Method to launch app.
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
                        ChessBoard.chessBoardCreator(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                System.out.println(chessBoard.getBoardRepresentation());
            } else {
                System.out.println(
                        "Arguments must be integer numbers (Remember, that chess board doesn't have a zero or negative "
                                + "height or width, though, you are allowed to enter only positive whole numbers)\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("You used too large number or incorrect input.");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }


}

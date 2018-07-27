package chess;

import java.util.regex.Pattern;

/**
 * <h1>Chess board.</h1>
 *
 * <p>This app is simply displays chess board with user-defined size.</p>
 *
 * @author Daniel Changer.
 * @version 1.0.
 * @since 2018-07-24.
 */
public class ChessBoard {
  /** Height of a chess field.*/
  private int height;

  /** Width of a chess field. */
  private int width;

  /** Default constructor for chess board. Creates a default chess board 8x8. */
  public ChessBoard() {
    this(8, 8);
  }

  /**
   * Constructor for creating specific chess board with user-defined size.
   *
   * @param height count of board cells in a column.
   * @param width count of board cells in a row.
   */
  public ChessBoard(int height, int width) {

    this.height = height;
    this.width = width;
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
            + "Only first two arguments will be significant, other will be ignored.\n"
            + "If at least one significant argument is wrong, board characteristics will \n"
            + "be set up to default (8x8)");
  }

  /** This method displays chess board itself. */
  public void display() {
    for (int i = 0; i < height; i++) {
      if (i % 2 == 0) {
        for (int j = 0; j < width; j++) {
          if (j % 2 == 0) {
            System.out.print("*");
          } else {
            System.out.print(" ");
          }
        }
      } else {
        for (int j = 0; j < width; j++) {
          if (j % 2 != 0) {
            System.out.print("*");
          } else {
            System.out.print(" ");
          }
        }
      }
      System.out.println();
    }
  }

  /**
   * Returns board height.
   *
   * @return The board height.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Allows to set a value to the board height.
   *
   * @param height The board height.
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Return the board height.
   *
   * @return The board width.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Allows to set a value to the board width.
   *
   * @param width The board width.
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Method to test class.
   *
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    try {
      Pattern pattern = Pattern.compile("[^0-9]+");

      if (args.length == 0) {
        info();
      } else if (args.length == 1
          || pattern.matcher(args[0]).find()
          || pattern.matcher(args[1]).find()) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.display();
      } else {

        ChessBoard chessBoard =
            new ChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        chessBoard.display();
      }

    } catch (Exception e) {
      System.out.println("Something went wrong");
    }
  }
}

package chess;

import java.util.Collection;

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
    private final int height;

    /**
     * Width of a chess field.
     */
    private final int width;

    /**
     * Look of the board itself
     */
    private final StringBuilder boardRepresentation;


    /**
     * Constructor for creating specific chess board with user-defined size.
     *
     * @param height count of board cells in a column.
     * @param width  count of board cells in a row.
     */
    private ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
        boardRepresentation = paintBoard();
    }

    /**
     * @return String representation of the board.
     */
    public String getBoardRepresentation() {
        return boardRepresentation.toString();
    }

    /**
     * Method to validate parameters and to build chess board. If parameters are invalid, then it
     * returns null
     *
     * @param height count of board cells in a column.
     * @param width  count of board cells in a row.
     */
    public static ChessBoard chessBoardCreator(int height, int width)
            throws IllegalArgumentException {
        if (height > 0 && width > 0) {
            return new ChessBoard(height, width);
        } else {
            throw new IllegalArgumentException("Chess board is not created due to illegal arguments");
        }
    }

    /**
     * This method creates chess board representation.
     *
     * @return Returns chess board representation
     */
    private StringBuilder paintBoard() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        board.append("*");
                    } else {
                        if(j == width - 1) {
                            break;
                        }
                        board.append(" ");
                    }

                } else {
                    if (j % 2 != 0) {
                        board.append("*");
                    } else {
                        board.append(" ");
                    }
                }
            }
            if(i != height - 1){
                board.append("\n");
            }
        }
        return board;
    }


}

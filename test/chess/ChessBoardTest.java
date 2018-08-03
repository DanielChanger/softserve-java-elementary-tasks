package chess;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class ChessBoardTest {

    public static class TestChessBoardCreator {
        @Parameters
        public static Object[][] getInvalidArgs() {
            return new Object[][]{
                    {0, 0},
                    {0, 53},
                    {13, 0},
                    {-21, 0},
                    {0, -12},
                    {-2, 5},
                    {5, -7},
                    {-12, -13},
            };
        }

        @Parameter
        public int height;
        @Parameter(1)
        public int width;

        @Test(expected = IllegalArgumentException.class)
        public void chessBoardCreator() {
            ChessBoard.chessBoardCreator(height, width);
        }
    }

    public static class TestChessBoardPaint {


        @Parameters
        public static Collection<Object[]> getValidArgs() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 1}, "*"},
                    {new int[]{2, 3}, "* * *\n" +
                            " * * *"},
//                    {new int[]{1,1}, "*"},
//                    {new int[]{1,1}, "*"},
//                    {new int[]{1,1}, "*"},
//                    {new int[]{1,1}, "*"},
//                    {new int[]{1,1}, "*"},
//                    {new int[]{1,1}, "*"},
            });
        }

        @Parameter
        public int[] values;
        @Parameter(1)
        public String expectedRepresentation;

        @Test
        public void getBoardRepresentation() {
            ChessBoard chessBoard = ChessBoard.chessBoardCreator(values[0], values[1]);
            String actual = chessBoard.getBoardRepresentation();
            assertEquals(expectedRepresentation, actual);
        }

    }
}
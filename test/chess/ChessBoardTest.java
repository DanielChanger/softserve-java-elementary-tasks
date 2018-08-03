package chess;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class ChessBoardTest {

    @RunWith(Parameterized.class)
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

    @RunWith(Parameterized.class)
    public static class TestChessBoardPaint {


        @Parameters
        public static Object[][] getValidArgs() {
            return new Object[][]{
                    {1, 1, "*"},

                    {2, 3, "* *\n" +
                            " * "},

                    {5, 5, "* * *\n" +
                            " * * \n" +
                            "* * *\n" +
                            " * * \n" +
                            "* * *"},

                    {3, 1, "*\n" +
                            " \n" +
                            "*"},

                    {2, 5, "* * *\n" +
                            " * * "},


                    {3, 4, "* * \n" +
                            " * *\n" +
                            "* * "},

                    {8, 8, "* * * * \n" +
                            " * * * *\n" +
                            "* * * * \n" +
                            " * * * *\n" +
                            "* * * * \n" +
                            " * * * *\n" +
                            "* * * * \n" +
                            " * * * *"}
            };
        }

        @Parameter
        public int height;
        @Parameter(1)
        public int width;
        @Parameter(2)
        public String expectedRepresentation;

        @Test
        public void getBoardRepresentation() {
            ChessBoard chessBoard = ChessBoard.chessBoardCreator(height, width);
            String actual = chessBoard.getBoardRepresentation();
            assertEquals(expectedRepresentation, actual);
        }

    }
}
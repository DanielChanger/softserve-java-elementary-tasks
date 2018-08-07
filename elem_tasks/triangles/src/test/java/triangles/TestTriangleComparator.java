package triangles;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.fail;
import static triangles.Triangle.createTriangle;

public class TestTriangleComparator {

    private static Object[][] validArgsForCompareTest() {
        return new Object[][] {
            {createTriangle("A", 3, 3, 4.7), createTriangle("A", 5, 4, 3), -1},
            {createTriangle("C", 8, 5, 5), createTriangle("V", 12, 12, 12), -1},
            {createTriangle("W", 37, 30, 13), createTriangle("w", 20, 13, 11), 1},
            {createTriangle("X", 17, 10, 9), createTriangle("t", 17, 10, 9), 0},
            {createTriangle("w", 44, 22, 65), createTriangle("q", 1, 2, 2.5), 1}};
    }


    @ParameterizedTest
    @DisplayName("Checks if compare method correctly compares two triangles by their areas")
    @MethodSource("validArgsForCompareTest")
    void testTriangleComparator(Triangle triangle1, Triangle triangle2, int expected) {
        int actual = new TrianglesComparator().compare(triangle1, triangle2);
        if (!((expected < 0 && actual < 0) || (expected == 0 && actual == 0) || (expected > 0 && actual > 0))) {
            fail("Comparing operation wasn't succeed");
        }
    }
}

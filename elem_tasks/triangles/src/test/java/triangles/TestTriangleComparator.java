package triangles;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.fail;
import static triangles.Triangle.triangleBuilder;

public class TestTriangleComparator {

    private static Object[][] validArgsForCompareTest() {
        return new Object[][]{
                {triangleBuilder("A", 3, 3, 4.7), triangleBuilder("A", 5, 4, 3), -1},
                {triangleBuilder("C", 8, 5, 5), triangleBuilder("V", 12, 12, 12), -1},
                {triangleBuilder("W", 37, 30, 13), triangleBuilder("w", 20, 13, 11), 1},
                {triangleBuilder("X", 17, 10, 9), triangleBuilder("t", 17, 10, 9), 0},
                {triangleBuilder("w", 44, 22, 65), triangleBuilder("q", 1, 2, 2.5), 1}};
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

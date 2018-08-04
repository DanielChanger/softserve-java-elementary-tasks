package triangles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {


    static Stream<Arguments> invalidArgsForCreatorProvider() {
        return Stream.of(
                Arguments.of("", 2, 2, 3),
                Arguments.of(null, 2, 3, 5),
                Arguments.of("A", 0, 0, 0),
                Arguments.of("B", 0, 3, 5),
                Arguments.of("C", 2, 0, 5),
                Arguments.of("D", 2, 3, 0),
                Arguments.of("E", -5, 1, 1),
                Arguments.of("F", 4, -3, 1),
                Arguments.of("G", 1, 6, -9),
                Arguments.of("G", -12, -13, 14),
                Arguments.of("G", 11, -5, -7),
                Arguments.of("G", -4, -6, -8),
                Arguments.of("", -1, -1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidArgsForCreatorProvider")
    void testTriangleBuilder(String name, double sideA, double sideB, double sideC) {

        assertThrows(IllegalArgumentException.class, () -> {
            Triangle.triangleBuilder(name, sideA, sideB, sideC);
        });
    }

    /*
    We need to test this method because method initArea is private,
    but we still need to know the results it calculates, so we examine the
    results that are returned by method getArea
    */
    @Test
    void testGetArea() {
    }

    @Test
    void testToString() {
    }
}
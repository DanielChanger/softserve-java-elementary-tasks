package triangles;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static triangles.Triangle.createTriangle;
class TriangleTest {

    private static Stream<Arguments> invalidArgsForCreator() {
        return Stream.of(
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

    private static Stream<Arguments> validArgsForInitAreaTest() {
        return Stream.of(
            Arguments.of(createTriangle("A", 3, 3, 4.7), 4.382),
            Arguments.of(createTriangle("B", 5, 4, 3), 6),
            Arguments.of(createTriangle("C", 8, 5, 5), 12),
            Arguments.of(createTriangle("D", 12, 12, 12), 62.353),
            Arguments.of(createTriangle("E", 37, 30, 13), 180),
            Arguments.of(createTriangle("F", 20, 13, 11), 66),
            Arguments.of(createTriangle("G", 17, 10, 9), 36),
            Arguments.of(createTriangle("H", 4, 12, 10), 18.734),
            Arguments.of(createTriangle("I", 1, 2, 2.5), 0.95)
        );
    }

    private static Stream<Arguments> validArgsForToStringTest() {
        return Stream.of(
            Arguments.of(createTriangle("A", 3, 3, 4.7), "[Triangle A]: 4.382 cm"),
            Arguments.of(createTriangle("B", 5, 4, 3), "[Triangle B]: 6 cm"),
            Arguments.of(createTriangle("C", 8, 5, 5), "[Triangle C]: 12 cm"),
            Arguments.of(createTriangle("D", 12, 12, 12), "[Triangle D]: 62.354 cm"),
            Arguments.of(createTriangle("E", 37, 30, 13), "[Triangle E]: 180 cm"),
            Arguments.of(createTriangle("F", 20, 13, 11), "[Triangle F]: 66 cm"),
            Arguments.of(createTriangle("G", 17, 10, 9), "[Triangle G]: 36 cm"),
            Arguments.of(createTriangle("H", 4, 12, 10), "[Triangle H]: 18.735 cm"),
            Arguments.of(createTriangle("I", 1, 2, 2.5), "[Triangle I]: 0.95 cm")
        );
    }



    @ParameterizedTest
    @DisplayName("Checks if triangle builder will throw and exception due to illegal parameters")
    @MethodSource("invalidArgsForCreator")
    void testTriangleBuilder(String name, double sideA, double sideB, double sideC) {
        assertThrows(IllegalArgumentException.class, () -> createTriangle(name, sideA, sideB, sideC));
    }

    /*
    We need to test this method because method initArea is private,
    but we still need to know the results it calculates, so we examine the
    results that are returned by method getArea
    */
    @ParameterizedTest
    @DisplayName("Checks if initArea method correctly calculates triangle area")
    @MethodSource("validArgsForInitAreaTest")
    void testGetArea(Triangle triangle, double expected) {
        double actual = triangle.getArea();
        double precision = 0.001;
        if (Math.abs(expected - actual) >= precision) {
            fail("Expected(" + expected + ") area differs from actual(" + actual + ")");
        }
    }

    @ParameterizedTest
    @DisplayName("Checks if toString method correctly outputs triangle with the defined format")
    @MethodSource("validArgsForToStringTest")
    void testToString(Triangle triangle, String expected) {
        String actual = triangle.toString();
        assertEquals(expected, actual);
    }
}
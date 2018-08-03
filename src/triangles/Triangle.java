package triangles;

import java.util.Locale;

public class Triangle {
    private String name;
    private double area;

    private Triangle(String name, double sideA, double sideB, double sideC) {
        this.name = name;
        area = initArea(sideA, sideB, sideC);
    }

    public static Triangle triangleBuilder(String name, double sideA, double sideB, double sideC)
            throws IllegalArgumentException {
        System.out.println(sideA + " " + sideB + " " + sideC);
        if (sideA > 0
                && sideB > 0
                && sideC > 0
                && sideA + sideB > sideC
                && sideA + sideC > sideB
                && sideB + sideC > sideA) {
            return new Triangle(name, sideA, sideB, sideC);
        } else {
            throw new IllegalArgumentException(
                    "Triangle sides must be positive numbers and need to suit the following rule:\n"
                            + "\"The sum of two triangle sides is always greater then the third side\"");
        }
    }

    private double initArea(double sideA, double sideB, double sideC) {
        double p = 0.5 * (sideA + sideB + sideC);
        return Math.pow(p * (p - sideA) * (p - sideB) * (p - sideC), 0.5);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "[Triangle %s]: %.2f cm", name, area);
    }


    public double getArea() {
        return area;
    }
}

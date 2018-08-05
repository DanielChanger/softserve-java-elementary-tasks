package triangles;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Triangle {
    private String name;
    private double area;

    private Triangle(String name, double sideA, double sideB, double sideC) {
        this.name = name;
        area = initArea(sideA, sideB, sideC);
    }

    public double getArea() {
        return area;
    }


    public static Triangle triangleBuilder(String name, double sideA, double sideB, double sideC)
            throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Triangle must have a name.");
        } else if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive numbers.");
        } else if (sideA + sideB <= sideC
                || sideA + sideC <= sideB
                || sideB + sideC <= sideA) {
            throw new IllegalArgumentException(
                    "Triangle sides must suit the following rule:\n"
                            + "\"The sum of two arbitrary triangle sides is always greater then the third side\"");
        } else {
            return new Triangle(name, sideA, sideB, sideC);
        }
    }

    private double initArea(double sideA, double sideB, double sideC) {
        double p = 0.5 * (sideA + sideB + sideC);
        return Math.pow(p * (p - sideA) * (p - sideB) * (p - sideC), 0.5);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMinimumFractionDigits(0);
        df.setMaximumFractionDigits(3);
//        String areaToString = Double.toString(area).replaceFirst("[.]0$", "");
        return String.format("[Triangle %s]: " + df.format(area) + " cm", name);
    }


    public static void showTrianglesReversedList(List<Triangle> triangles) {
        triangles.sort(Collections.reverseOrder(new TrianglesComparator()));
        System.out.println("============= Triangles list: =============");
        int i = 1;
        for (Triangle temp : triangles) {
            System.out.println(i++ + ". " + temp);
        }
    }
}

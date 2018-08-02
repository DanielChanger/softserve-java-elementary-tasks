package triangles;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Triangle {
    private String name;
    private double sideA;
    private double sideB;
    private double sideC;

    private Triangle(String name, double sideA, double sideB, double sideC) {
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
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

    public double getArea() {
        double p = 0.5 * (sideA + sideB + sideC);
        return Math.pow(p * (p - sideA) * (p - sideB) * (p - sideC), 0.5);
    }

    @Override
    public String toString() {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        Locale currentLocale = Locale.getDefault();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("###.##", otherSymbols);
        fmt.format("[Triangle %s]: " + df.format(getArea()) + " cm", name);
        return fmt.toString();
    }

    public static void main(String[] args) {
        LinkedList<Triangle> triangles = new LinkedList<>();
        Pattern pattern = Pattern.compile("(y|yes)", Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        Scanner scanner;
        do {

            System.out.println(
                    "Enter arguments in a following order: <name>, <sideA>, <sideB>, <sideC> "
                            + "(don't forget to separate them with comma like: myName, 2, 3.9 , 4.0)");
            scanner = new Scanner(System.in);
            String[] input = scanner.nextLine().split(",");
            try {
                triangles.add(
                        Triangle.triangleBuilder(
                                input[0].trim(),
                                Double.parseDouble(
                                        (input[1].trim().matches("[-]?\\d*([.]?[0-9]*)?")
                                                ? input[1]
                                                : "contains a letter")),
                                Double.parseDouble(
                                        (input[2].trim().matches("[-]?\\d*([.]?[0-9]*)?")
                                                ? input[2]
                                                : "contains a letter")),
                                Double.parseDouble(
                                        (input[3].trim().matches("[-]?\\d*([.]?[0-9]*)?")
                                                ? input[3]
                                                : "contains a letter"))));
            } catch (NumberFormatException nfe) {
                System.out.println(
                        "Don't use any characters to input values of sideA, sideB, sideC. Only digits!");
                matcher = pattern.matcher("yes");
                continue;
            } catch (IndexOutOfBoundsException iobe) {
                System.out.println("You need to separate every argument with comma");
                matcher = pattern.matcher("yes");
                continue;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                matcher = pattern.matcher("yes");
                continue;
            }
            System.out.println("Do you want to continue adding triangles");
            scanner = new Scanner(System.in);
            matcher = pattern.matcher(scanner.nextLine());

        } while (matcher.matches());

        triangles.sort(Collections.reverseOrder(new TrianglesComparator()));
        System.out.println("============= Triangles list: ===============");
        int i = 1;
        for (Triangle temp : triangles) {
            System.out.println(i++ + ". " + temp);
        }
        scanner.close();
    }
}

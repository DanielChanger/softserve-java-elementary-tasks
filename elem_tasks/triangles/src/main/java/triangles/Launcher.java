package triangles;

import java.util.LinkedList;
import java.util.Scanner;

public class Launcher {

    public static void info() {
        System.out.println("This program outputs triangles in a descend order by their area.\n" +
            "It asks user to input triangle attributes in following format\n" +
            "<name>, <sideA>, <sideB>, <sideC> separated with comma. After completing of entering\n" +
            "attributes of a triangle program asks user if he wants to continue adding triangles.\n" +
            "If he enters \"y\" or \"yes\" (input is case insensitive) then he is allowed to enter\n" +
            "attributes for next triangle. Else, adding ends up and programm outputs those triangles\n" +
            "in a descend order.");
    }

    public static void main(String[] args) {
        LinkedList<Triangle> triangles = new LinkedList<>();
        Scanner scanner;
        try {
            System.out.println(
                    "\nEnter arguments in a following order: <name>, <sideA>, <sideB>, <sideC>"
                            + "\n(don't forget to separate them with comma like: myName, 2, 3.9 , 4.0)\n");
            do {
                System.out.print("Enter new triangle attributes: ");

                scanner = new Scanner(System.in);
                String[] triangleInput = scanner.nextLine().split(",");
                if (triangleInput[0].isEmpty()) {
                    info();
                }

                triangles.add(
                        Triangle.triangleBuilder(
                                triangleInput[0].trim(),
                                Double.parseDouble(triangleInput[1]),
                                Double.parseDouble(triangleInput[2]),
                                Double.parseDouble(triangleInput[3])));


                System.out.println("Do you want to continue adding triangles");
                scanner = new Scanner(System.in);

            } while (scanner.next().matches("(?i)(y|yes)"));

            Triangle.showTrianglesReversedList(triangles);

            scanner.close();

        } catch (NumberFormatException e) {
            System.out.println(
                    "Don't use any characters to input values of sideA, sideB, sideC. Only digits!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You need to separate every argument with comma");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}

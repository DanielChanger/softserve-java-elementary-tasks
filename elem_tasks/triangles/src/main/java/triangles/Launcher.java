package triangles;

import java.util.LinkedList;
import java.util.Scanner;

public class Launcher {

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void printInfo() {
        System.out.println("\nThis program outputs triangles in a descend order by their area.\n" +
            "It asks user to input triangle attributes in following format\n" +
            "<name>, <sideA>, <sideB>, <sideC> separated with comma. After completing of entering\n" +
            "attributes of a triangle program asks user if he wants to continue adding triangles.\n" +
            "If he enters \"y\" or \"yes\" (input is case insensitive) then he is allowed to enter\n" +
            "attributes for next triangle. Else, adding ends up and programm outputs those triangles\n" +
            "in a descend order.");
    }

    /**
     * Method to launch app.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        LinkedList<Triangle> triangles = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println(
                "\nEnter arguments in a following order: <name>, <sideA>, <sideB>, <sideC>"
                    + "\n(don't forget to separate them with comma like: myName, 2, 3.9 , 4.0)\n");
            do {
                System.out.print("Enter new triangle attributes: ");


                String[] triangleInput = scanner.nextLine().split(",");
                if (triangleInput[0].isEmpty()) {
                    printInfo();
                }

                triangles.add(
                    Triangle.createTriangle(
                        triangleInput[0].trim(),
                        Double.parseDouble(triangleInput[1]),
                        Double.parseDouble(triangleInput[2]),
                        Double.parseDouble(triangleInput[3])));


                System.out.println("Do you want to continue adding triangles");
            } while (scanner.next().matches("(?i)(y|yes)"));

            Triangle.showTrianglesReversedList(triangles);

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

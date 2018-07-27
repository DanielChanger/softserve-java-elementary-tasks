package ticket;

import java.util.regex.Pattern;

/**
 *
 *
 * <h1>Lucky ticket.</h1>
 *
 * <p>This app outputs a number of lucky tickets within user-defined range and<br>
 * defines which method of counting lucky tickets finds more lucky tickets <br>
 * on a defined range.
 *
 * @author Daniel Changer.
 * @version 1.0.
 * @since 2018-07-26.
 */
public class LuckyTicket {

  /**
   * This method is an entry point of counting tickets. It validates parameters and calls
   * simpleMethod and complexMethod
   *
   * @param min Minimal user-defined number of ticket
   * @param max Maximum user-defined number of ticket
   * @return It returns a string, that says which method found more lucky tickets within a range, or
   *     tells user about incorrect parameters (in this option methods simpleMethod and
   *     complexMethod will not launch)
   */
  public static String numberOfTickets(String min, String max) {
    Pattern pattern = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9]");

    if (!pattern.matcher(min).matches() || !pattern.matcher(max).matches()) {
      return "One or both parameters are incorrect. \n"
          + "You should enter two numbers in a following + way: 000001, 101010, 242156 etc.";
    }
    int counterSimple = simpleMethod(min, max);
    int counterComplex = complexMethod(min, max);
    if (counterSimple > counterComplex) {
      return "Simple method counted more lucky tickets than a complex one — Simple: "
          + counterSimple
          + " vs Complex: "
          + counterComplex;
    } else if (simpleMethod(min, max) < complexMethod(min, max)) {
      return "Complex method counted more lucky tickets than a simple one — Complex: "
          + counterComplex
          + " vs Simple: "
          + counterSimple;
    } else {
      return "Simple and complex methods counted equivalent number of lucky tickets";
    }
  }

  /**
   * Simple method that counts lucky tickets within a range in a specific way: if sum of left 3
   * numbers equals to sum of right 3 numbers of a ticket number, then the ticket is lucky
   *
   * @param min Minimal user-defined number of ticket
   * @param max Maximum user-defined number of ticket
   * @return Number of found lucky tickets
   */
  private static int simpleMethod(String min, String max) {

    int counter = (Integer.parseInt(min) == 0) ? 1 : 0;
    int sumOfLeftPart = 0;
    int sumOfRightPart = 0;
    int[] firstPart = new int[3];
    int[] secondPart = new int[3];
    int index1 = 0;
    int index2 = 0;

    for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {
      if (Integer.toString(i).length() < 4) {
        continue;
      }
      for (int j = 0; j < Integer.toString(i).length(); j++) {
        if (index1 < Integer.toString(i).length() / 2) {
          firstPart[index1] = Integer.parseInt(Integer.toString(i).substring(j, j + 1));
          sumOfLeftPart += firstPart[index1++];
        } else {
          secondPart[index2] = Integer.parseInt(Integer.toString(i).substring(j, j + 1));
          sumOfRightPart += secondPart[index2++];
        }
      }
      if (sumOfLeftPart == sumOfRightPart) {
        counter++;
      }
      sumOfLeftPart = sumOfRightPart = 0;
      index1 = index2 = 0;
    }
    return counter;
  }

  /**
   * Simple method that counts lucky tickets within a range in a specific way: if sum of left 3
   * numbers equals to sum of right 3 numbers of a ticket number, then the ticket is lucky
   *
   * @param min Minimal user-defined number of ticket
   * @param max Maximum user-defined number of ticket
   * @return Number of found lucky tickets
   */
  private static int complexMethod(String min, String max) {
    int counter = 0;
    int sumOfEven = 0;
    int sumOfOdd = 0;
    int[] even = new int[3];
    int[] odd = new int[3];
    int index1 = 0;
    int index2 = 0;
    for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {

      for (int j = 0; j < Integer.toString(i).length(); j++) {
        if (j % 2 == 0) {
          even[index1] = Integer.parseInt(Integer.toString(i).substring(j, j + 1));
          sumOfEven += even[index1++];
        } else {
          odd[index2] = Integer.parseInt(Integer.toString(i).substring(j, j + 1));
          sumOfOdd += odd[index2++];
        }
      }
      if (sumOfEven == sumOfOdd) {
        counter++;
      }
      index1 = index2 = 0;
      sumOfEven = sumOfOdd = 0;
    }
    return counter;
  }

  /**
   * Method, which displays the rules of using this program, if there are no arguments passed from
   * the command-line.
   */
  public static void info() {
    System.out.println(
        "This program counts lucky tickets within numerical limits defined by user.\n"
            + " It counts using two methods at a time: simple and complex.\n"
            + " At the and of the program it will show you two numbers of lucky tickets counted \n"
            + "with two methods and define which method will count more tickets than another within \n"
            + "a specific limit of numbers defined by users in command-line arguments. User have to enter\n "
            + "two valid numbers numbers in a following way: 000001, 101010, 242156 etc.\n"
            + " Only two first arguments are significant other will be unnoticed.\n");
  }

  /**
   * Method to test class.
   *
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {

    if (args.length == 0) {
      info();
    } else if (args.length != 2) {
      System.out.println("You should have entered two or more arguments.");
    } else {
      System.out.println(numberOfTickets(args[0], args[1]));
    }
  }
}

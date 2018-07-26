package ticket;

import chess.ChessBoard;

import java.util.regex.Pattern;

public class LuckyTicket {

  public static String numberOfTickets(String min, String max) {
    if (min.length() != 6 || max.length() != 6) {
      return "One or both parameters are incorrect. You should enter two numbers in a following"
          + " way: 000001, 101010, 242156 etc.";
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

  private static int simpleMethod(String min, String max) {
    int counter = 0;
    int sum1 = 0, sum2 = 0;
    int[] firstPart = new int[3];
    int[] secondPart = new int[3];
    int index1 = 0, index2 = 0;
    for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {
      for (int j = 0; j < 6; j++) {
        if (index1 < 3) {
          firstPart[index1] = Integer.parseInt(Integer.toString(i).substring(j, j + 1));
          sum1 += firstPart[index1++];
        } else {
          secondPart[index2] = Integer.parseInt(Integer.toString(i).substring(j, j + 1));
          sum2 += secondPart[index2++];
        }
      }
      if (sum1 == sum2) {
        counter++;
      }
      sum1 = sum2 = 0;
      index1 = index2 = 0;
    }
    return counter;
  }

  private static int complexMethod(String min, String max) {
    int counter = 0;
    int sum1 = 0, sum2 = 0;
    int[] even = new int[3];
    int[] odd = new int[3];
    int index1 = 0, index2 = 0;
    for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {

      for (int j = 0; j < 6; j++) {
        if (j % 2 == 0) {
          even[index1] = Integer.parseInt(Integer.toString(i).substring(j, j + 1));
          sum1 += even[index1++];
        } else {
          odd[index2] = Integer.parseInt(Integer.toString(i).substring(j, j + 1));
          sum2 += odd[index2++];
        }
      }
      if (sum1 == sum2) {
        counter++;
      }
      index1 = index2 = 0;
      sum1 = sum2 = 0;
    }
    return counter;
  }

  public static void info() {
    System.out.println(
        "This program counts lucky tickets within numerical limits defined by user.\n"
            + " It counts using two methods at a time: simple and complex.\n"
            + " At the and of the program it will show you two numbers of lucky tickets counted \n"
            + "with two methods and define which method will count more tickets than another within \n"
            + "a specific limit of numbers defined by users in command-line arguments. User have to enter "
            + "two valid numbers numbers in a following way: 000001, 101010, 242156 etc."
            + " Only two first arguments are significant other will be unnoticed.");
  }

  public static void main(String[] args) {
    try {
      Pattern pattern = Pattern.compile("[^0-9]+");
      if (args.length == 0) {
        info();
      } else if (args.length != 2
          || pattern.matcher(args[0]).find()
          || pattern.matcher(args[1]).find()) {
        System.out.print("You should have entered two or more arguments");
      } else {
        System.out.println(numberOfTickets("000001", "000002"));
      }

    } catch (Exception e) {
      System.out.println("Something went wrong");
    }
  }
}

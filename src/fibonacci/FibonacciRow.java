package fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciRow {
  public static ArrayList<Long> fibonacci(int lengthOfRow) {
    ArrayList<Long> row = new ArrayList<>();
    long a = 0, b = 1;
    for (long i = 1; i <= lengthOfRow; i++) {
      row.add(a);
      row.add(b);
      a += b;
      b += a;
    }
    return row;
  }

  public static ArrayList<Long> fibonacci(int start, int end) {
    ArrayList<Long> row = new ArrayList<>();
    long a = 0, b = 1;
    for (int i = 1; i <= end; i++) {
      if (a > start && b <= end ) {
        row.add(a);
        row.add(b);
      }
      a += b;
      b += a;
    }
    return row;
  }

  public static void main(String[] args) {
    ArrayList<Long> row = FibonacciRow.fibonacci(30);
    for (Long temp : row) {
      System.out.print(temp + " ");
    }

    System.out.println();

    row = FibonacciRow.fibonacci(8, 40);
    for (Long temp : row) {
      System.out.print(temp + " ");
    }
  }
}

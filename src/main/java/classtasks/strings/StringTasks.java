package classtasks.strings;

import java.util.regex.Pattern;

public class StringTasks {
    public static void main(String[] args) {
        //    String str1 = "IT";
        //    String str2 = "IT Academy";
        //    System.out.println(str2.contains(str2));

        //    Scanner scanner = new Scanner(System.in);
        //    String[] FIO = scanner.nextLine().split(" ");
        //    System.out.println(FIO[0] + " " + FIO[1].substring(0, 1) + ". " + FIO[2].substring(0, 1) +
        // ".");
        //    System.out.println(FIO[1]);
        //    for (String temp : FIO) {
        //      System.out.print(temp + " ");
        //    }

        //    System.out.println();
        //
        //    String[] names = new String[5];
        //    names[0] = "Danielisimusishka";
        //    names[1] = "John";
        //    names[2] = "Li";
        //    names[3] = "Bill";
        //    names[4] = "A23";
        //
        //    Pattern pattern = Pattern.compile("[a-zA-Z]{3,16}$");
        //    for (String temp : names) {
        //      if (pattern.matcher(temp).matches()) {
        //        System.out.println(temp + " is correct name");
        //      } else {
        //        System.out.println(temp + " is incorrect name");
        //      }
        //    }

        //   Scanner scanner = new Scanner(System.in);
        //    String[] words = scanner.nextLine().split(" ");
        //
        //    int max = 0;
        //    String pointer = new String("");
        //    ArrayList<String> maxWords = new ArrayList<>();
        //    boolean flag = true;
        //    StringBuilder secondWord = new StringBuilder(words[1]);
        //    for (String temp : words) {
        //      if (temp.length() > max) {
        //        max = temp.length();
        //        pointer = temp;
        //        maxWords.clear();
        //      } else if (temp.length() == max) {
        //        if (flag) {
        //          maxWords.add(pointer);
        //          flag = false;
        //        }
        //          maxWords.add(temp);
        //      }
        //    }
        //
        //    String res = (maxWords.size() > 0 ? Arrays.toString(maxWords.toArray()) : pointer);
        //    System.out.println(
        //        "The longest strings: "
        //            + res
        //            + "\n"
        //            + "Its size: "
        //            + max
        //            + "\nSecond word is "
        //            + "\""
        //            + secondWord.reverse()
        //            + "\"\n\n");

        //        String str = "I  am learning  Java   Core";
        //
        //        String[] array = str.split("\\s+");
        //        String res = "";
        //        Pattern pattern = Pattern.compile("(am|have|has|are)", Pattern.CASE_INSENSITIVE);
        //        for (String temp : array) {
        //          if (temp.matches("(am)")) {
        //            res += "\b'm ";
        //            continue;
        //          }
        //          if (temp.matches("(are)")) {
        //            res += "\b're ";
        //            continue;
        //          }
        //          if (temp.matches("(is|has)")) {
        //            res += "\b's ";
        //            continue;
        //          }
        //          if (temp.matches("(have)")) {
        //            res += "\b've ";
        //            continue;
        //          }
        //          res += temp + " ";
        //        }
        //        System.out.println(res);

        Pattern pattern = Pattern.compile("^[$][0-9]+(.|,)?[0-9]{2}");
        System.out.println(pattern.matcher("$0,00").matches());

        //        String str = "After creating the content can not be changed.";
        //        byte[] res = str.getBytes();
        //        System.out.println(Arrays.toString(res));
        //        StringBuilder strBuild = new StringBuilder();
        //        str = String.valueOf("123.151");
        //        System.out.println(str);

        //new E();
    }

    int a = method();

    int method() {
        System.out.println("method of base class");
        return 0;
    }

    StringTasks() {
        System.out.println("Constructor of base class");
    }

}

class E extends StringTasks {
    int b = method2();

    int method2() {
        System.out.println("method of derived class");
        return 0;
    }

    E() {
        System.out.println("Constructor of derived class");
    }
}
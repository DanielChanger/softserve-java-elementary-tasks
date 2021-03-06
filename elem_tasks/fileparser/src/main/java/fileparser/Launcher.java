package fileparser;

import java.io.IOException;
import java.nio.file.Paths;

public class Launcher {

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void info() {
        System.out.println("This program checks how many occurrences of string in a file\n"
            + "or changes all user-defined strings to others. Application takes 0, 2 or 3 arguments. If there were 0 of"
            + "arguments passed, then outputs \"how-to\" information. If 2 args were passed, then the 1st arg is considered\n"
            + "being a file path and the 2nd is a string, which occurrences are going to be counted. Else, if user passes 3\n"
            + "args, then it will be considered to suit to the following scheme:\n"
            + "<file path>, <string to replace>, <string to replace with>.");
    }

    /**
     * Method to launch app.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            info();
        } else if (args.length == 2) {
            try {
                FileParser fileParser = FileParser.createFileParser(Paths.get(args[0]));
                System.out.println(fileParser.getFileText());
                System.out.println(fileParser.getRepeatsOfString(args[1]));
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        } else if (args.length == 3) {
            try {
                FileParser fileParser = FileParser.createFileParser(Paths.get(args[0]));
                fileParser.replaceString(args[1], args[2]);
                System.out.println(fileParser.getFileText());
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        } else {
            System.out.println(
                "There must be 2 or 3 arguments.\n"
                    + "If you want to count a number of string occurrences in a file,\n"
                    + "then enter path to file and a string to count respectively.\n"
                    + "Else, if you want to replace all occurrences of string in a file\n"
                    + "with another string, then type path to file, string to search, string to replace with");
        }


    }
}

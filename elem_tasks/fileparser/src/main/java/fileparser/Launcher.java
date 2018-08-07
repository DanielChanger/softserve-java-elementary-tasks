package fileparser;

import java.io.IOException;
import java.nio.file.Paths;

public class Launcher {
    public static void info() {
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                info();
            } else if (args.length == 2) {

                FileParser fileParser;
                fileParser = FileParser.fileParserCreator(Paths.get(args[0]));
                System.out.println(fileParser.getFileText());
                System.out.println(fileParser.repeatsOfString(args[1]));

            } else if (args.length == 3) {
                FileParser fileParser;
                fileParser = FileParser.fileParserCreator(Paths.get(args[0]));
                fileParser.replaceString(args[1], args[2]);
                System.out.println(fileParser.getFileText());
            } else {
                System.out.println(
                        "There must be 2 or 3 arguments.\n"
                                + "If you want to count a number of string occurrences in a file,\n"
                                + "then enter path to file and a string to count respectively.\n"
                                + "Else, if you want to replace all occurrences of string in a file\n"
                                + "with another string, then type path to file, string to search, string to replace with");
            }

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}

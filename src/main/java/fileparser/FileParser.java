package fileparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    private final Path path;

    private FileParser(Path path) {
        this.path = path;
    }

    public File getFile() {
        return path.toFile();
    }

    int repeatsOfString(String stringToSearch) throws IOException {
        String text = getFileText();
        int counterOfWord = 0;
        Pattern pattern = Pattern.compile("\\W*" + stringToSearch + "\\W*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            counterOfWord++;
        }
        return counterOfWord;
    }

    void replaceWord(String stringToSearch, String stringToReplaceWith) throws IOException {
        String text = getFileText().replaceAll(stringToSearch, stringToReplaceWith);
        writeToFile(text);
    }

    public static FileParser fileParserCreator(Path path) throws IOException {
        try {
            return new FileParser(path.toRealPath());
        } catch (NoSuchFileException x) {
            throw new NoSuchFileException("File not found.");
        } catch (IOException x) {
            throw new IOException("Undefined file error.");
        }
    }

    public String getFileText() throws IOException {
        StringBuilder buffer = new StringBuilder();
        List<String> lines = Files.readAllLines(path);
        for (String temp : lines) {
            buffer.append(temp).append("\n");
        }
        return buffer.toString();
    }

    private void writeToFile(String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
        writer.write(text);
        writer.flush();
        writer.close();
    }

    public static void info() {
        System.out.println();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            FileParser.info();
        } else if (args.length == 2) {
            System.out.println();
        } else if (args.length == 3) {

        } else {
            System.out.println(
                    "There must be 2 or 3 arguments.\n"
                            + "If you want to count a number of string occurrences in a file,\n"
                            + "then enter path to file and a string to count respectively.\n"
                            + "Else, if you want to replace all occurrences of string in a file\n"
                            + "with another string, then type path to file, string to search, string to replace with");
        }
        try {
            FileParser fileParser;
            fileParser = FileParser.fileParserCreator(Paths.get("src\\fileparser\\file.txt"));
            System.out.println(fileParser.getFileText());
            System.out.println(fileParser.repeatsOfString("might be"));
            fileParser.replaceWord("would be", "might be");
            System.out.println(fileParser.getFileText());
            System.out.println(fileParser.repeatsOfString("might be"));
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}

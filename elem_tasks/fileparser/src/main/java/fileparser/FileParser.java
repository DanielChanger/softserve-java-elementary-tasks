package fileparser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <h1>File parser</h1>
 *
 * <p>This app counts string occurrences in a file or replace all instances of defined string in a file with another.</p
 *
 * @author Daniel Changer.
 * @version 1.1.
 */
public class FileParser {

    /**
     * File path
     */
    private final Path path;

    /**
     * @param path path of existing file
     */
    private FileParser(Path path) {
        this.path = path;
    }

    /**
     * Method for validating passed parameters and creating
     * an instance of file parser if parameters are correct
     *
     * @param path path of file
     * @return instance of file parser
     * @throws IOException throws if path of file is not valid or doesn't
     *                     exists or null were passed as an argument
     */
    public static FileParser createFileParser(Path path) throws IOException {
        try {
            return new FileParser(path.toRealPath());
        } catch (IOException | NullPointerException | InvalidPathException x) {
            throw new IOException("File not found.");
        }
    }

    /**
     * Method to obtain text from file
     *
     * @return text from file
     * @throws IOException if I/O trouble happens
     */
    public String getFileText() throws IOException {
        StringBuilder text = new StringBuilder();
        List<String> lines = Files.readAllLines(path);

        for (String temp : lines) {
            text.append(temp).append("\n");
        }

        return text.toString();
    }

    /**
     * Method to return number of passed in parameters string in the text
     *
     * @return count of string occurrences in text
     * @throws IOException if I/O trouble happens
     */
    public int getRepeatsOfString(String stringToSearch) throws IOException {
        String text = getFileText();
        Pattern pattern = Pattern.compile(stringToSearch);
        Matcher matcher = pattern.matcher(text);

        int counterOfString = 0;
        while (matcher.find()) {
            counterOfString++;
        }

        return counterOfString;
    }

    /**
     * Method to replace all instances of one string with another
     *
     * @throws IOException if I/O trouble happens
     */
    public void replaceString(String stringToSearch, String stringToReplaceWith) throws IOException {
        String text = getFileText().replaceAll(stringToSearch, stringToReplaceWith);
        writeToFile(text);
    }


    /**
     * Method for re-writing file content
     *
     * @throws IOException
     */
    private void writeToFile(String text) throws IOException {
        try (FileWriter writer = new FileWriter(path.toFile())) {
            writer.write(text);
        }
    }
}

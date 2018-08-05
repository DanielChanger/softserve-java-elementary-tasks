package fileparser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    private final Path path;

    private FileParser(Path path) {
        this.path = path;
    }

    int repeatsOfString(String stringToSearch) throws IOException {
        String text = getFileText();
        int counterOfWord = 0;
        Pattern pattern = Pattern.compile(stringToSearch);
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
        } catch (IOException | NullPointerException x) {
            throw new IOException("File not found.");
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


}

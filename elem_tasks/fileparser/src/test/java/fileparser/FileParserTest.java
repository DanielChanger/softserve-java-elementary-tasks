package fileparser;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FileParserTest {

    private static Object[][] getInvalidPaths() {
        return new Object[][] {
            {"asdgas", IOException.class},
            {" ", InvalidPathException.class},
            {"C:\\Users\\Daniel Changer\\Desktop\\Softserve\\Elementary Tasks\\elem_tasks\\envelopes\\src\\main\\resources\\file.txt", IOException.class},
            {"C:\\Users\\Daniel Changer\\Desktop\\Softserve\\Elementary Tasks\\elem_tasks\\fileparser\\src\\test\\testFile.txt1", IOException.class},
            {"1235", IOException.class},
            {"PATH", IOException.class},
            {null, NullPointerException.class},
        };
    }


    private static Object[][] getStringsToSearch() {
        return new Object[][] {
            {" был ", 2},
            {" в ", 9},
            {"эмират", 1},
            {"государство", 1},
            {"Айдын", 11},
            {"были организованы", 1},
            {"династия", 2},
            {"Меня нет в этом тексте", 0}
        };
    }

    @ParameterizedTest
    @MethodSource("getInvalidPaths")
    void testFileParserCreator(String path, Class expected) {
        Exception exception = null;
        try {
            FileParser.createFileParser(Paths.get(path));
        } catch (IOException | NullPointerException | InvalidPathException e) {
            exception = e;
        }
        if (exception == null) {
            fail(expected.toString() + " is expected to be thrown");
        }

//        assertThrows(Exception.class, () -> FileParser.fileParserCreator(Paths.get(path)));
    }

    @Test
    void testGetFileTextFromTestFileTxt() throws IOException {
        FileParser fileParser = FileParser.createFileParser(Paths.get("src\\test\\resources\\testFile2.txt"));

        String expected = "Запущенная в январе 2001 года Джимми Уэйлсом и Ларри Сэнгером,\n" +
            "Википедия сейчас является самым крупным и наиболее популярным\n" +
            "справочником в Интернете. По объёму сведений и тематическому\n" +
            " охвату Википедия считается самой полной энциклопедией из когда-либо создававшихся\n" +
            " за всю историю человечества. В 2015 году число зарегистрированных\n" +
            " участников русской Википедии превысило 1,7 млн. Одним из основных достоинств\n" +
            " Википедии как универсальной энциклопедии является возможность представления информации\n" +
            " на родном языке пользователя. На май 2018 года разделы Википедии есть на 301 языке,\n" +
            "   а также на 493 языках в инкубаторе. Она содержит более 40 миллионов статей. Интернет-сайт\n" +
            "    Википедии является пятым по посещаемости сайтом в мире.\n";

        String actual = fileParser.getFileText();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getStringsToSearch")
    void repeatsOfString(String stringToSearch, int expected) throws IOException {
        FileParser fileParser = FileParser.createFileParser(Paths.get("src\\test\\resources\\testFile.txt"));
        int actual = fileParser.getRepeatsOfString(stringToSearch);
        assertEquals(expected, actual);
    }


    @Test
    void testReplaceString_Text_With_Sentence() throws IOException {
        FileParser fileParser = FileParser.createFileParser(Paths.get("src\\test\\resources\\testFile3.txt"));
        String expected = "In literary theory, a sentence is any object that can be \"read\", whether this object is a work\n" +
            "of literature, a street sign, an arrangement of buildings on a city block, or styles of clothing.\n" +
            "It is a coherent set of signs that transmits some kind of informative message.\n" +
            "This set of symbols is considered in terms of the informative message's content,\n" +
            "rather than in terms of its physical form or the medium in which it is represented.\n" +
            "\n" +
            "Within the field of literary criticism, \"sentence\" also refers to the original information content\n" +
            "of a particular piece of writing; that is, the \"sentence\" of a work is that primal symbolic arrangement\n" +
            "of letters as originally composed, apart from later alterations, deterioration, commentary, translations,\n" +
            "parasentence, etc. Therefore, when literary criticism is concerned with the determination of a \"sentence\",\n" +
            "it is concerned with the distinguishing of the original information content from whatever has been added to\n" +
            "or subtracted from that content as it appears in a given sentenceual document (that is, a physical representation of sentence).\n" +
            "\n" +
            "Since the history of writing predates the concept of the \"sentence\", most sentences were not written with this\n" +
            "concept in mind. Most written works fall within a narrow range of the types described by sentence theory.\n" +
            "The concept of \"sentence\" becomes relevant if and when a \"coherent written message is completed and needs\n" +
            "to be referred to independently of the circumstances in which it was created.\"\n";

        fileParser.replaceString("text", "sentence");
        String actual = fileParser.getFileText();
        assertEquals(actual, expected);
    }

    @AfterAll
    static void tearDown() throws IOException {
        FileParser fileParser = FileParser.createFileParser(Paths.get("src\\test\\resources\\testFile3.txt"));
        fileParser.replaceString("sentence", "text");
    }
}
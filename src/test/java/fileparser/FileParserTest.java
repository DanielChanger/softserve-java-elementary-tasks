package fileparser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileParserTest {


    private static Object[][] getInvalidPaths() {
        return new Object[][]{
                {"asdgas"},
                {"afhasfh"},
                {"sdhasg"},
                {"sdag"},
                {null},
                {"asdg"}
        };
    }


    private static Object[][] getStringsToSearch() {
        return new Object[][]{
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
    void testFileParserCreator(String path) {
        assertThrows(Exception.class, () -> FileParser.fileParserCreator(Paths.get(path)));
    }

    @Test
    void testGetFileTextFromTestFileTxt() throws IOException {
        FileParser fileParser = FileParser.fileParserCreator(Paths.get("src\\test\\resources\\testFile2.txt"));

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
        FileParser fileParser = FileParser.fileParserCreator(Paths.get("src\\test\\resources\\testFile.txt"));
        int actual = fileParser.repeatsOfString(stringToSearch);
        assertEquals(expected, actual);
    }

    @Test
    void testReplaceWord() throws IOException {
        System.out.println(Integer.parseInt("-1"));
    }


}
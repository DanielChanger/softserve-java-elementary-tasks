package numbertostring;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberToStringTest {

    @DataProvider(name = "numbers")
    public Object[][] providerForConverter() {
        return new Object[][]{
                {0, "ноль"},
                {-21, "минус двадцать один"},
                {50, "пятьдесят"},
                {120, "сто двадцать"},
                {-762, "минус семьсот шестьдесят два"},
                {1235, "одна тысяча двести тридцать пять"},
                {-7600, "минус семь тысяч шестьсот"},
                {65436, "шестьдесят пять тысяч четыреста тридцать шесть"},
                {-21561, "минус двадцать одна тысяча пятьсот шестьдесят один"},
                {978_697, "девятьсот семьдесят восемь тысяч шестьсот девяносто семь"},
                {-230_000, "минус двести тридцать тысяч"},
                {1_256_111, "один миллион двести пятьдесят шесть тысяч сто одиннадцать"},
                {-8_000_001, "минус восемь миллионов один"},
                {1_256_111, "один миллион двести пятьдесят шесть тысяч сто одиннадцать"},
                {41_052_230, "сорок один миллион пятьдесят две тысячи двести тридцать"},
                {-87_009_666, "минус восемьдесят семь миллионов девять тысяч шестьсот шестьдесят шесть"},
                {
                        666_666_666,
                        "шестьсот шестьдесят шесть миллионов шестьсот шестьдесят шесть тысяч шестьсот шестьдесят шесть"
                },
                {
                        -999_999_999,
                        "минус девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять"
                },
                {
                        69_969_969_969L,
                        "шестьдесят девять миллиардов девятьсот шестьдесят девять миллионов девятьсот шестьдесят девять тысяч девятьсот шестьдесят девять"
                },
                {
                        -12_175_864_003L,
                        "минус двенадцать миллиардов сто семьдесят пять миллионов восемьсот шестьдесят четыре тысячи три"
                },
                {
                        214_100_256_111L,
                        "двести четырнадцать миллиардов сто миллионов двести пятьдесят шесть тысяч сто одиннадцать"
                },
                {
                        -101_202_303_404L,
                        "минус сто один миллиард двести два миллиона триста три тысячи четыреста четыре"
                },
                {
                        999_999_999_999L,
                        "девятьсот девяносто девять миллиардов"
                                + " девятьсот девяносто девять миллионов девятьсот"
                                + " девяносто девять тысяч девятьсот девяносто девять"
                },
                {1_000_000_000_000L, "This number is not supported"},
        };
    }

    @Test(dataProvider = "numbers")
    public void testConvert(final long number, final String expected) {
        final String actual = NumberToString.convert(number).replaceAll(" \b", "");
        assertEquals(actual, expected);
    }
}

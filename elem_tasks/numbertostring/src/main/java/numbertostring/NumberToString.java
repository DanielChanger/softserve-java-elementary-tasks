package numbertostring;

import java.util.Map;
import java.util.TreeMap;

public class NumberToString {
    private static final Map<Long, String> UNITS = new TreeMap<Long, String>();
    private static final Map<Long, String> TENS = new TreeMap<Long, String>();
    private static final Map<Long, String> HUNDREDS = new TreeMap<Long, String>();

    static {
        UNITS.put(0L, "ноль");
        UNITS.put(1L, "один");
        UNITS.put(2L, "два");
        UNITS.put(3L, "три");
        UNITS.put(4L, "четыре");
        UNITS.put(5L, "пять");
        UNITS.put(6L, "шесть");
        UNITS.put(7L, "семь");
        UNITS.put(8L, "восемь");
        UNITS.put(9L, "девять");
        UNITS.put(10L, "десять");
        UNITS.put(11L, "одиннадцать");
        UNITS.put(12L, "двенадцать");
        UNITS.put(13L, "тринадцать");
        UNITS.put(14L, "четырнадцать");
        UNITS.put(15L, "пятнадцать");
        UNITS.put(16L, "шестнадцать");
        UNITS.put(17L, "семнадцать");
        UNITS.put(18L, "восемнадцать");
        UNITS.put(19L, "девятнадцать");

        TENS.put(2L, "двадцать");
        TENS.put(3L, "тридцать");
        TENS.put(4L, "сорок");
        TENS.put(5L, "пятьдесят");
        TENS.put(6L, "шестьдесят");
        TENS.put(7L, "семьдесят");
        TENS.put(8L, "восемьдесят");
        TENS.put(9L, "девяносто");

        HUNDREDS.put(1L, "сто");
        HUNDREDS.put(2L, "двести");
        HUNDREDS.put(3L, "триста");
        HUNDREDS.put(4L, "четыреста");
        HUNDREDS.put(5L, "пятьсот");
        HUNDREDS.put(6L, "шестьсот");
        HUNDREDS.put(7L, "семьсот");
        HUNDREDS.put(8L, "восемьсот");
        HUNDREDS.put(9L, "девятьсот");
    }

    private static String correctEndingForThousands(String str) {
        if (str.equals("ноль")) {
            return "";
        }
        if (str.endsWith("один")) {
            return str.replace("один", "одна тысяча");
        }
        if (str.endsWith("два")) {
            return str.replace("два", "две тысячи");
        }
        if (str.endsWith("три") || str.endsWith("четыре")) {
            return str + " тысячи";
        }
        return str + " тысяч";
    }

    private static String correctEndingForMillions(String str) {
        if (str.equals("ноль")) {
            return "";
        }
        if (str.endsWith("один")) {
            return str + " миллион";
        }
        if (str.endsWith("два") || str.endsWith("три") || str.endsWith("четыре")) {
            return str + " миллиона";
        }
        return str + " миллионов";
    }

    private static String correctEndingForBillions(String str) {
        if (str.equals("ноль")) {
            return "";
        }
        if (str.endsWith("один")) {
            return str + " миллиард";
        }
        if (str.endsWith("два") || str.endsWith("три") || str.endsWith("четыре")) {
            return str + " миллиарда";
        }
        return str + " миллиардов";
    }

    public static String convert(long i) {
        if (i < 0) {
            return "минус " + convert(Math.abs(i));
        }
        if (i < 20) {
            return UNITS.get(i);
        }
        if (i < 100) {
            return (TENS.get(i / 10) + ((i % 10 > 0) ? " " + convert(i % 10) : "")).replaceAll(" {2,}", " ");
        }
        if (i < 1000) {
            return (HUNDREDS.get(i / 100) + ((i % 100 > 0) ? " " + convert(i % 100) : "")).replaceAll(" {2,}", " ");
        }
        if (i < 1_000_000) {
            return (correctEndingForThousands(convert((i / 1000)))
                    + ((i % 1000 > 0) ? " " + convert(i % 1000) : "")).replaceAll(" {2,}", " ");
        }
        if (i < 1_000_000_000) {
            return (correctEndingForMillions(convert((i / 1_000_000)))
                    + " "
                    + correctEndingForThousands(convert(((i % 1_000_000) / 1000)))
                    + ((i % 1000 > 0) ? " " + convert(i % 1000) : "")).replaceAll(" {2,}", " ");
        }
        if (i < 1_000_000_000_000L) {
            return (correctEndingForBillions(convert((i / 1_000_000_000)))
                    + " "
                    + correctEndingForMillions(convert((i % 1_000_000_000) / 1_000_000))
                    + " "
                    + correctEndingForThousands(convert(((i % 1_000_000_000) % 1_000_000) / 1000))
                    + ((i % 1000 > 0) ? " " + convert(i % 1000) : ""))
                    .replaceAll(" {2,}", " ");
        }
        return "This number is not supported";
    }
}

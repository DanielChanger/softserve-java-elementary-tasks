package numbertostring;

public class Launcher {

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void info() {
        System.out.println(
            "This program takes a number in range of -+999,999,999,999, \n"
                + "then converts it to words and outputs it");
    }

    /**
     * Method to launch app.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            info();
        } else if (args.length != 1) {
            System.out.println("You should have entered exactly one numeric argument.");
        } else {
            try {
                System.out.println(NumberToString.convert(Long.parseLong(args[0])));
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument");
            }
        }
    }
}

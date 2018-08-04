package ticket;

public class Launcher {
    /**
     * Method to launch app.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            info();
        } else if (args.length != 2) {
            throw new IllegalArgumentException("You should have entered exactly two arguments.");
        } else {
            try {
                System.out.println(LuckyTicket.numberOfTickets(args[0], args[1]));
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void info() {
        System.out.println(
                "\tThis program counts lucky tickets within numerical limits defined by user.\n"
                        + "It counts using two methods at a time: simple and complex.\n"
                        + "At the and of the program it will show you two numbers of lucky tickets counted \n"
                        + "with two methods and define which method will count more tickets than another within \n"
                        + "a specific limit of numbers defined by users in command-line arguments. User have to enter\n "
                        + "two valid numbers numbers in a following way: 000001, 101010, 242156 etc.\n");
    }
}



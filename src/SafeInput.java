import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * SafeInput - A collection of static methods for input validation.
 */
public class SafeInput {
    /**
     * Gets a String that matches a given RegEx pattern from the user
     * @param pipe Scanner to use for input
     * @param prompt message to the user about what to enter
     * @param regEx regular expression pattern to match
     * @return a String that matches the RegEx pattern supplied
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retVal = "";
        boolean done = false;

        do {
            System.out.print(prompt + " ");
            retVal = pipe.nextLine();

            if (Pattern.matches(regEx, retVal)) {
                done = true;
            } else {
                System.out.println("Input must match the pattern: " + regEx);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets an integer value within a specified range
     * @param pipe Scanner to use for input
     * @param prompt message to the user about what to enter
     * @param low low end of inclusive range
     * @param high high end of inclusive range
     * @return an integer within the inclusive range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");

            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // Clear the newline from the buffer

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range [" + low + "-" + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer, not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a yes or no confirmation from the user
     * @param pipe Scanner to use for input
     * @param prompt message to the user about what to enter
     * @return true for yes, false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retVal = false;
        boolean done = false;
        String response = "";

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                done = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                done = true;
                retVal = false;
            } else {
                System.out.println("You must enter Y or N");
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a non-zero length string from the user
     * @param pipe Scanner to use for input
     * @param prompt message to the user about what to enter
     * @return a String of non-zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retVal = "";
        boolean done = false;

        do {
            System.out.print(prompt + " ");
            retVal = pipe.nextLine();

            if (retVal.length() > 0) {
                done = true;
            } else {
                System.out.println("You must enter at least one character");
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets an integer value from the user with no constraints
     * @param pipe Scanner to use for input
     * @param prompt message to the user about what to enter
     * @return an integer value
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + " ");

            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // Clear the newline from the buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer, not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a double value from the user with no constraints
     * @param pipe Scanner to use for input
     * @param prompt message to the user about what to enter
     * @return a double value
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + " ");

            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // Clear the newline from the buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double, not: " + trash);
            }
        } while (!done);

        return retVal;
    }
}
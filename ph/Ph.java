/*
    Filename: Ph.java
    Problem: Class
    Description: Write a PH checker
    Author: Joshua Rodriguez
    Email: ewized@gmail.com
    Date: 02/24/2014
*/
import java.util.Scanner;

public class Ph {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            check(input());
        }
        catch (Exception e) {
            out(e.getMessage());
        }
    }

    public static void out(Object msg) {
        System.out.println(msg);
    }

    /** Ask the user for the input. */
    private static int input() throws Exception {
        int result;
        try {
            out("Enter the Ph lever to check?");
            result = s.nextInt();
        }
        catch (Exception e) {
            throw new Exception("You can only use real numbers.");
        }

        return result;
    }

    /** Validate the input */
    private static void check(int level) throws Exception {
        if (level > 14 || level < 0)
            throw new Exception("Input is out of bounds");

        if (level == 7)
            out("The PH Level is a neutral.");
        else if (level > 7)
            out("The PH level is a base/alkalinity.");
        else
            out("The PH level is an acid.");
    }
}

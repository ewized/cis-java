import java.util.*;

public class ExceptionHandler {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Double> numbers = new ArrayList<Double>();
    static boolean debug = false;

    public static void main(String[] args) {
        // Debug mode enable
        if (args.length >= 1) {
            debug = args[0].equals("debug");
            System.out.println("===== DEBUG MODE ON =====");
        }


        System.out.println("-------------------------");
        System.out.println("-- Number Adder v5.8.4 --");
        System.out.println("-- by Joshua Rodriguez --");
        System.out.println("-------------------------");

        int trys = 0;
        Double check = 0.0;
        do {
            check = getInput();
            if (check != null) {
                numbers.add(check);
                trys = 0;
            }
            else {
                trys++;
                scan = new Scanner(System.in);
            }
        } while (trys != 2);

        printArray(numbers);
    }

    /** Ask the user and return the double */
    public static Double getInput() {
        try {
            System.out.print("Enter a number to be added: ");
            return scan.nextDouble();
        } catch (Exception e) {
            System.out.println();
            System.out.println("You did not enter a number, try one more time.");
            return null;
        }
    }

    /** Add the list */
    public static void printArray(ArrayList<Double> list) {
        double add = 0.0;

        for (Double next : list) {
            if (debug) System.out.printf("DEBUG: %s \n", next);
            add += next;
        }

        System.out.printf("The total of the numbers is %s.", add);
    }
}
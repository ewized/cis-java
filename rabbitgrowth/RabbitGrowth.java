/*
    Name: Joshua Rodriguez
    Problem: P4.16 pg 191
    Description: Implement a program that prompts the user to
            enter the number of growth cycles. Then prints the
            fibonacci number.
 */
import java.util.Scanner;

public class RabbitGrowth {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int pos;
            System.out.print("Enter a number to see its fibonacci counter part: ");
            pos = in.nextInt();
            String result = String.format(
                    "The fibonacci counter part for %s is %s.",
                    pos,
                    fib(pos)
            );
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("You must enter a number!");
        }
    }

    // Fibs
    private static int fib(int pos) {
        int newFibNum = 1, fibOne = 1, fibTwo = 1;
        for (int i = 2; i < pos; i++) {
            newFibNum = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = newFibNum;
        }

        return pos == 0 ? 0 : newFibNum;
    }
}

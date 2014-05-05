/**
    Name: Joshua Rodriguez
    Problem: P6.24
    Description: Make a ticket shop to buy tickets, for
            seats using a 2D array.
    Date: Today
    Email: 3/17/2014
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class TicketSeat {
    private static Scanner in = new Scanner(System.in);
    private final static int SIZE = 10;
    private static int[][] seats = new int[][] {
       {10,10,10,10,10,10,10,10,10,10},
       {10,10,10,10,10,10,10,10,10,10},
       {10,10,10,10,10,10,10,10,10,10},
       {10,10,20,20,20,20,20,20,10,10},
       {10,10,20,20,20,20,20,20,10,10},
       {10,10,20,20,20,20,20,20,10,10},
       {20,20,30,30,40,40,30,30,20,20},
       {20,30,30,40,50,50,40,30,30,20},
       {30,40,50,50,50,50,50,50,40,30}
    };

    /** The entry point to this awesome program. */
    public static void main(String[] args) {
        ask();
    }

    /** Ask the oldest question in the universe. */
    private static int ask() {
        int option = -1;
        do {
            try {
                System.out.println();
                System.out.println("0. End the program with the force.");
                System.out.println("1. View the seats.");
                System.out.println("2. Buy a seat ticket.");
                System.out.println("3. Buy a ticket.");
                System.out.println();
                System.out.print("Enter the option: ");
                option = in.nextInt();
                if (option > 3) throw new Exception();

                option(option);
            } catch (Exception e) {
                System.out.println("Enter a correct option.");
                System.exit(0);
            }
        } while(option > 0 || option == -1);
        return option;
    }

    /** Which of option should I chose. */
    private static void option(int option) {
        if (option == 1) print(seats);
        if (option == 2) buySeat(seats);
        if (option == 3) buyPrice(seats);
    }

    /** Buy a ticket. */
    private static void buySeat(int[][] seats) {
        try {
            int row = 0, col = 0, price = 10;
            // Ask the questions.
            System.out.print("Which row do you want: ");
            row = in.nextInt();

            if (row < 0 || row > SIZE) throw new Exception("Enter a number from 0 and 9");

            System.out.print("Which col do you want: ");
            col = in.nextInt();

            if (col < 0 || col > SIZE) throw new Exception("Enter a number from 0 and 8");

            // Buy the ticket if you can.
            price = seats[row][col];

            if (price == 0) throw new Exception("The seat is taken!");

            System.out.println(String.format(
                "You are buying a ticket at row %s and col %s for %s dollars.",
                row,
                col,
                price
            ));
            seats[row][col] = 0;

        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Buy a seat with the given price. */
    private static void buyPrice(int[][] seats) {
        try {
            int row = 0, col = 0, price = -1;
            boolean found = true;
            // Ask the questions.
            System.out.print("Enter a price of a seat: ");
            price = in.nextInt();

            // Buy the ticket if you can.
            for (int x = 0; x < SIZE; x++) {
                for (int y = 0; y < SIZE-1; y++) {
                    col = x;
                    row = y;
                    int newSeat = seats[row][col];
                    if (newSeat == price) {
                        found = false;
                        break;
                    }
                }
                if (!found) break;
            }

            if (found) throw new Exception(String.format("No seat found for $%s.", price));

            System.out.println(String.format(
                "You are buying a ticket at row %s and col %s for %s dollars.",
                row,
                col,
                price
            ));
            seats[row][col] = 0;

        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Print out the array. */
    private static void print(int[][] seats) {
        for (int x = 0; x < SIZE-1; x++) {
            for (int y = 0; y < SIZE; y++) {
                System.out.print((seats[x][y] == 0 ? "00" : seats[x][y]) + " ");
            }
                System.out.println();
        }
    } 
}
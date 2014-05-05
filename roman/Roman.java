/*
    Name: Joshua Rodriguez
    Problem: P5.21
    Description: Make a roman number translator.
    Email: ewized@gmail.com
    Date: 3/17/2014
*/
import java.util.Scanner;

public class Roman {
    /** Entry point to the program. */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;

        try {
            System.out.print("Enter a number to make roman numbers: ");
            number = in.nextInt();

            // Is it bigger then the needed.
            if (number > 3999) throw new Exception();
            // Is it smaller?
            if (number < 1) throw new Exception();

            print(number);
        } catch (Exception e) {
            System.out.println("Enter a number between 3999 and 1, come on man!");
        }
    }

    /** Print the number into roman numbers. */
    public static void print(int number) {
        String roman = "";

        while (number >= 1000) {
            roman += "M";
            number -= 1000;
        }
         
        while (number >= 900) {
            roman += "CM";
            number -= 900;
        }
         
        while (number >= 500) {
            roman += "D";
            number -= 500;
        }
         
        while (number >= 400) {
            roman += "CD";
            number -= 400;
        }
         
        while (number>= 100) {
            roman += "C";
            number -= 100;
        }
         
        while (number >= 90) {
            roman += "XC";
            number -= 90;
        }
         
        while (number >= 50) {
            roman += "L";
            number -= 50;
        }
         
        while (number >= 40) {
            roman += "XL";
            number -= 40;
        }
         
        while (number >= 10) {
            roman += "X";
            number -= 10;
        }
         
        while (number >= 9) {
            roman += "IX";
            number -= 9;
        }
         
        while (number >= 5) {
            roman += "V";
            number -= 5;
        }
         
        while (number >= 4) {
            roman += "IV";
            number -= 4;
        }
         
        while (number >= 1) {
            roman += "I";
            number -= 1;
        }

        System.out.println(String.format("The number %s in roman is %s.", number, roman));
    }
}
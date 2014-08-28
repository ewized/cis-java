/*
    Filename: Unitconverter.java
    Problem: P3.24
    Description: Converts units aka the unit converter
    Author: Joshua Rodriguez
    Email: ewized@gmail.com
    Date: 02/24/2014
*/
import java.util.Scanner;

public class Unitconverter {
    public static void main(String[] args) {
        // Awesomesaus
        final Scanner scan = new Scanner(System.in);
        final double INCHES = 12;
        final double FEET = 3.28;
        final double MILES = 0.00062;
        final double MILLIMETERS = 1000;
        final double CENTIMETERS = 100;
        final double METERS = 1;
        final double KILOMETERS = 0.001;
        String from, to;
        double number;

        // Ask questions
        out("");
        out("==========================");
        out("Google may be better :P");
        out("==========================");
        out("");
        out("What do you want to convert from? (fl, oz, gal, lb, in, ft, mi)");
        from = scan.nextLine();
        out("What do you want to convert to? (ml, l, g, kg, mm, cm, m, km)");
        to = scan.nextLine();
        out("Enter the number to convert?");
        number = scan.nextDouble();

        // Do the math
        // Output the results
        // flow oz
        if (from.equalsIgnoreCase("fl")) {
            if (to.equalsIgnoreCase("ml")) {
                out(String.format("The result is %s.", number*29.5735));
            }
            else if (to.equalsIgnoreCase("l")) {
                out(String.format("The result is %s.", number*.0295735));
            }
            else {
                out(String.format("Can not convert %s to %s.", from, to));
            }
        }
        // gal
        else if (from.equalsIgnoreCase("gal")) {
            if (to.equalsIgnoreCase("ml")) {
                out(String.format("The result is %s.", number*29.5735*128));
            }
            else if (to.equalsIgnoreCase("l")) {
                out(String.format("The result is %s.", number*.295735*129));
            }
            else {
                out(String.format("Can not convert %s to %s.", from, to));
            }
        }
        // oz
        else if (from.equalsIgnoreCase("oz")) {
            if (to.equalsIgnoreCase("g")) {
                out(String.format("The result is %s.", number*28.3495));
            }
            else if (to.equalsIgnoreCase("kg")) {
                out(String.format("The result is %s.", number*.0283495));
            }
            else {
                out(String.format("Can not convert %s to %s.", from, to));
            }
        }
        // lb
        else if (from.equalsIgnoreCase("lb")) {
            if (to.equalsIgnoreCase("g")) {
                out(String.format("The result is %s.", number*28.3495*16));
            }
            else if (to.equalsIgnoreCase("kg")) {
                out(String.format("The result is %s.", number*.0283495*16));
            }
            else {
                out(String.format("Can not convert %s to %s.", from, to));
            }
        }
        // in
        else if (from.equalsIgnoreCase("in")) {
            if (to.equalsIgnoreCase("mm")) {
                out(String.format("The result is %s.", number*25.4));
            }
            else if (to.equalsIgnoreCase("km")) {
                out(String.format("The result is %s.", number*2.54));
            }
            else if (to.equalsIgnoreCase("m")) {
                out(String.format("The result is %s.", number*.0254));
            }
            else if (to.equalsIgnoreCase("cm")) {
                out(String.format("The result is %s.", number*.00254));
            }
            else {
                out(String.format("Can not convert %s to %s.", from, to));
            }
        }
        // ft
        else if (from.equalsIgnoreCase("ft")) {
            if (to.equalsIgnoreCase("mm")) {
                out(String.format("The result is %s.", number*25.4*12));
            }
            else if (to.equalsIgnoreCase("km")) {
                out(String.format("The result is %s.", number*2.54*12));
            }
            else if (to.equalsIgnoreCase("m")) {
                out(String.format("The result is %s.", number*.0254*12));
            }
            else if (to.equalsIgnoreCase("cm")) {
                out(String.format("The result is %s.", number*.00254*12));
            }
            else {
                out(String.format("Can not convert %s to %s.", from, to));
            }
        }
        // mi
        else if (from.equalsIgnoreCase("mi")) {
            if (to.equalsIgnoreCase("mm")) {
                out(String.format("The result is %s.", number*25.4*63360));
            }
            else if (to.equalsIgnoreCase("km")) {
                out(String.format("The result is %s.", number*2.54*63360));
            }
            else if (to.equalsIgnoreCase("m")) {
                out(String.format("The result is %s.", number*.0254*63360));
            }
            else if (to.equalsIgnoreCase("cm")) {
                out(String.format("The result is %s.", number*.00254*63360));
            }
            else {
                out(String.format("Can not convert %s to %s.", from, to));
            }
        }
        // When all else fails
        else {
            out(String.format("Can not convert %s.", from));
        }
    }

    /** Simple short hand system.out.println */
    public static void out(Object message) {
        System.out.println(message);
    }
} 

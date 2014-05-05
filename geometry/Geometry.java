/*
    Name: Joshua Rodriguez
    Problem: Problem 5.9 Page 239
    Description: Write methods that compute the volume and surface
            area of a sphere with radius r, a circular base with radius,
            and a cone with a circular base with radius and height.
            Then write a program that prompts the user for the values
            or r and h, calls the six methods, and prints the results.
*/
import java.util.Scanner;

public class Geometry {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double radius, height;

        // Ask the user and check what they entered.
        try {
            System.out.print("Enter a radius:");
            radius = in.nextDouble();
            System.out.print("Enter a height:");
            height = in.nextDouble();
        } catch (Exception e) {
            System.out.println("Enter a double!");
            return;
        }

        // Print the results out.
        System.out.println("Sphere Volume: " + sphereVolume(radius));
        System.out.println("Sphere Surface Area: " + sphereSurface(radius));
        System.out.println("Cylinder Volume: " + cylinderVolume(radius, height));
        System.out.println("Cylinder Surface Area: " + cylinderSurface(radius, height));
        System.out.println("Cone Volume: " + coneVolume(radius, height));
        System.out.println("Cone Surface Area: " + coneSurface(radius, height));
    }

    /** Gets the volume of a sphere */
    public static double sphereVolume(double r) {
        return 4.0/3 * Math.PI * Math.pow(r, 3);
    }

    /** Gets the surface area of a sphere */
    public static double sphereSurface(double r) {
        return 4 * Math.PI * Math.pow(r, 2);
    }

    /** Gets the volume of the cylinder. */
    public static double cylinderVolume(double r, double h) {
        return Math.PI * Math.pow(r, 2) * h;
    }

    /** Gets the cylinder surface area. */
    public static double cylinderSurface(double r, double h) {
       return 2 * (Math.PI * Math.pow(r, 2)) + 2 * (Math.PI * r )* h;
    }

    /** Gets the volume of a cone. */
    public static double coneVolume(double r, double h) {
        return Math.PI * Math.pow(r, 2) * h/3;
    }

    /** Gets the surface area of a cone. */
    public static double coneSurface(double r, double h) {
        return Math.PI * r * (r + Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2)));
    }
}
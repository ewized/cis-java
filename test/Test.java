import java.util.*;

public class Test {
    private static Scanner in = new Scanner(System.in);
    private static Random rand = new Random(System.currentTimeMillis());

    /** The entry point to this awesome program. */
    public static void main(String[] args) {
        while (true) {
          System.out.print("Enter a number: ");
          System.out.println(rand.nextInt(in.nextInt()));
      }
    }
}
import java.util.*;

public class Bowl {

    public static abstract class Rice {
        @Override
        public String toString() {
            return "rice";
        }
    }

    public static class Snap extends Rice {
        @Override
        public String toString() {
            return "snap";
        }
    }

    public static class Crackle extends Rice {
        @Override
        public String toString() {
            return "crackle";
        }
    }

    public static class Pop extends Rice {
        @Override
        public String toString() {
            return "pop";
        }
    }

    public static void main(String[] args) {
        ArrayList<Rice> milk = new ArrayList<Rice>() {{
            long start = System.currentTimeMillis();
            //add(new Rice()); We are abstract
            for (int i = 0 ; i < 1000000; i++) {
                add(new Pop());
            }
            System.out.printf("The process lasted %s (ms)\n", System.currentTimeMillis()-start/100);

            long start2 = System.currentTimeMillis();
            //add(new Rice()); We are abstract
            for (int i = 0 ; i < 1000000; i++) {
                Pop p = new Pop();
                add(p);
            }
            System.out.printf("The process lasted %s (ms)\n", System.currentTimeMillis()-start2/100);
        }};

        for (Rice rice : milk) {
           // System.out.println(rice);
        }
    }
}
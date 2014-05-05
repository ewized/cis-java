/*
    name: Joshua Rodriguez
    email: ewized@gmail.com
    file: Filters.java
    problem: chapter 9 number 17 page 459
    description:
*/
import java.util.*;

public class Filters {

    // Interface to accept filters
    public interface Filter {
        public boolean accept(Object o);
    }

    // Short word filter that implements Filter
    public static class ShortWord implements Filter {
        // We should only accept words that are less than 5
        public boolean accept(Object word) {
            return ((String)word).length() < 5;
        }
    }

    // Main Driver/Tester
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        Filter shortWord = new Filters.ShortWord();

        // Ask user for input
        String input;
        do {
            try {
                System.out.println("Enter a word to be checked (type stop to end):");
                input = scan.nextLine();
                words.add(input);
            } catch (Exception e) {
                System.out.println("You did not enter a word, using previous values.");
                input = "stop";
            }
        } while(!input.equalsIgnoreCase("stop"));

        // print out the accepted words;
        System.out.println("Printing accepted words:");
        for (String word : collectAll(words, shortWord)) {
            System.out.println(word);
        }
    }

    // A method that creates returns an array of accepted words
    public static ArrayList<String> collectAll(ArrayList<String> list, Filter filter) {
        ArrayList<String> temp = new ArrayList<String>();

        for (String word : list) {
            if (filter.accept(word)) {
                temp.add(word);
            }
        }

        return temp;
    }
}
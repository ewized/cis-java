/*
    Name: Joshua Rodriguez
    Problem: P4.11 pg 190
    Description: Write a program that reads a word and prints
            the number of syllables in the word. For this
            exercise, assume that syllables are determined
            as follows: Each sequence of adjacent vowels
            'a e i o u y', except for last 'e' in a word, is
            a syllable. However, if that algorithm yields a
            a count of '0', change it to '1'.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vowels {
    // Create a list and predefine it with the vowels.
    private static final List<Character> vowels = new ArrayList<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('y');
    }};

    public static void main(String[] args) {
        // Make Scanner final to use in side of a class.
        final Scanner in = new Scanner(System.in);

        // Fill up the list of words to use.
        List<String> words = new ArrayList<String>() {{
            String word;
            do {
                System.out.print("Enter a word to test (Enter nothing to end): ");
                word = in.nextLine();
                if (!word.equals("")) add(word);
            } while (!word.equals(""));
        }};

        // Loop through the output.
        for (String word : words) {
            int counter = 0;

            // Count the vowels and ignore the last letter.
            for (int i = 0; i < word.length(); i++) {
                if (vowels.contains(word.toCharArray()[i]) && i+1 != word.length())
                    counter++;
            }

            // Out put each result and the count.
            System.out.println(word + ": " + (counter == 0 ? 1 : counter));
        }
    }
}

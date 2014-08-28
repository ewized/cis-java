import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("test.json"));
        System.out.println(in.toString());
    }
}

..import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter("output.txt");
            int c;

            System.out.println("Input text (End of input - Ctrl + Z):");

            while ((c = reader.read()) != -1) {
                writer.write(c);
            }

            reader.close();
            writer.close();

            System.out.println("The text was successfully written to the file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

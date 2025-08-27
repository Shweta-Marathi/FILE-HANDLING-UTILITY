import java.io.*;
import java.util.Scanner;

public class TextFileOperations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "sample.txt";

        try {
            // 1. Write user input to file
            System.out.println("Enter text to write into file (type 'exit' to stop):");
            FileWriter writer = new FileWriter(fileName);
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("exit")) break;
                writer.write(line + "\n");
            }
            writer.close();
            System.out.println("File written successfully.");

            // 2. Read file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("\nFile Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // 3. Append text
            System.out.println("\nEnter a line to append:");
            String appendLine = sc.nextLine();
            FileWriter appender = new FileWriter(fileName, true);
            appender.write(appendLine + "\n");
            appender.close();
            System.out.println("File modified successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}

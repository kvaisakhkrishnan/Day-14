import java.io.*;
import java.util.*;
public class HashingFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name with a set of numbers: ");
        String fileName = scanner.nextLine();

        HashTable hashTable = new HashTable(10);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String num : numbers) {
                    int number = Integer.parseInt(num);
                    hashTable.insert(number);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter a number to search: ");
        int searchNumber = scanner.nextInt();

        hashTable.searchAndRemove(searchNumber);

        System.out.println("\nAfter searching and removing the number:");
        hashTable.display();

        System.out.println("\nSaving the numbers in slots to a file...");
        hashTable.saveToFile("output.txt");

        scanner.close();
    }
}
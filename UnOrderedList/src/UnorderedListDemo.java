import java.io.*;
import java.util.Scanner;
public class UnorderedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnorderedList<String> wordList = new UnorderedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/vaisakhkrishnank/IdeaProjects/UnOrderedList/src/wordList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    wordList.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter a word to search or add/remove from the list: ");
        String userInput = scanner.next();

        if (wordList.search(userInput)) {
            wordList.remove(userInput);
            System.out.println("Word found and removed from the list.");
        } else {
            wordList.add(userInput);
            System.out.println("Word not found. Added to the list.");
        }

        wordList.display();
        wordList.saveToFile("wordList.txt");

        scanner.close();
    }
}
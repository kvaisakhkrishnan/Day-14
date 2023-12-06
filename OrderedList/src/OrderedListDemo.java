import java.io.*;
import java.util.Scanner;
public class OrderedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OrderedList<Integer> numberList = new OrderedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/vaisakhkrishnank/IdeaProjects/OrderedList/src/numberList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    numberList.insert(num);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter a number to search, add, or remove from the list: ");
        int userInput = scanner.nextInt();

        if (numberList.search(userInput)) {
            numberList.remove(userInput);
            System.out.println("Number found and removed from the list.");
        } else {
            numberList.insert(userInput);
            System.out.println("Number not found. Added to the list.");
        }

        numberList.display();
        numberList.saveToFile("numberList.txt");

        scanner.close();
    }
}
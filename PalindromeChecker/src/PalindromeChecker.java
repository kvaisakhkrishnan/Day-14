import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindrome(String input) {
        // Create a deque to store characters
        Deque<Character> deque = new ArrayDeque<>();

        // Process the string from left to right and add each character to the rear of the deque
        for (char ch : input.toCharArray()) {
            deque.offerLast(ch);
        }

        // Compare characters from both ends of the deque
        while (!deque.isEmpty()) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false; // If characters from both ends are not equal, it's not a palindrome
            }
        }

        return true; // If all characters matched, it's a palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take a string as input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Check if the string is a palindrome
        boolean result = isPalindrome(input);

        // Output the result
        System.out.println("Is the string a palindrome? " + result);
    }
}
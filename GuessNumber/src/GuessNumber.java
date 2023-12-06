import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N (2^n): ");
        int n = scanner.nextInt();
        int N = (int) Math.pow(2, n);

        System.out.println("Think of a number between 0 and " + (N - 1));
        int guessedNumber = guessNumber(0, N - 1);

        System.out.println("The guessed number is: " + guessedNumber);

        scanner.close();
    }

    public static int guessNumber(int low, int high) {
        Scanner scanner = new Scanner(System.in);

        if (low <= high) {
            int mid = (low + high) / 2;

            System.out.print("Is the number between " + low + " and " + mid + "? (true/false): ");
            boolean response = scanner.nextBoolean();

            if (response) {
                return guessNumber(low, mid);
            } else {
                return guessNumber(mid + 1, high);
            }
        } else {
            System.out.println("Invalid input or number not found.");
            return -1;
        }
    }
}

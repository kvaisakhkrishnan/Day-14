import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankingCashCounterSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingCashCounter cashCounter = new BankingCashCounter();

        while (true) {
            System.out.println("\nBanking Cash Counter Simulation:");
            System.out.println("1. Enqueue customer");
            System.out.println("2. Dequeue customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.next();
                    System.out.print("Enter transaction type (Deposit/Withdraw): ");
                    String transactionType = scanner.next();
                    System.out.print("Enter transaction amount: $");
                    int amount = scanner.nextInt();
                    Customer customer = new Customer(name, transactionType, amount);
                    cashCounter.enqueue(customer);
                    break;

                case 2:
                    cashCounter.dequeue();
                    break;

                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
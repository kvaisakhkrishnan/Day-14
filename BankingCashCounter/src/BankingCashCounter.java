import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BankingCashCounter {
    private int cashBalance;
    private Queue<Customer> queue;

    public BankingCashCounter() {
        this.cashBalance = 0;
        this.queue = new LinkedList<>();
    }

    public void enqueue(Customer customer) {
        queue.offer(customer);
    }

    public void dequeue() {
        if (!queue.isEmpty()) {
            Customer customer = queue.poll();
            processTransaction(customer);
        } else {
            System.out.println("Queue is empty. No customers to dequeue.");
        }
    }

    private void processTransaction(Customer customer) {
        int amount = customer.getAmount();
        String transactionType = customer.getTransactionType();

        if (transactionType.equalsIgnoreCase("deposit")) {
            cashBalance += amount;
            System.out.println("Deposited $" + amount + ". Current Cash Balance: $" + cashBalance);
        } else if (transactionType.equalsIgnoreCase("withdraw")) {
            if (amount <= cashBalance) {
                cashBalance -= amount;
                System.out.println("Withdrawn $" + amount + ". Current Cash Balance: $" + cashBalance);
            } else {
                System.out.println("Insufficient funds. Unable to withdraw $" + amount);
            }
        } else {
            System.out.println("Invalid transaction type for customer: " + customer.getName());
        }
    }
}
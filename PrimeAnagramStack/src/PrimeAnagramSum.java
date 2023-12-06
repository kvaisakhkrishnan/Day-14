import java.util.Arrays;
import java.util.EmptyStackException;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class PrimeAnagramSum {

    public static void main(String[] args) {
        Stack stack = new Stack();

        for (int i = 0; i < 1001; i++) {
            if (isPrime(i)) {
                for (int j = 0; j < 1001; j++) {
                    if (isPrime(j) && i != j && isAnagram(i, j)) {
                        stack.push(i);
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram(int n1, int n2) {
        char[] arr1 = String.valueOf(n1).toCharArray();
        char[] arr2 = String.valueOf(n2).toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}

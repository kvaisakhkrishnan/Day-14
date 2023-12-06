import java.util.Arrays;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node head;
    Node tail;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int dequeue() throws Exception {
        if (head == null) {
            throw new Exception();
        }
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class PrimeAnagramQueue {

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();

        for (int i = 0; i < 1001; i++) {
            if (isPrime(i)) {
                for (int j = 0; j < 1001; j++) {
                    if (isPrime(j) && i != j && isAnagram(i, j)) {
                        queue.enqueue(i);
                        break;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
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

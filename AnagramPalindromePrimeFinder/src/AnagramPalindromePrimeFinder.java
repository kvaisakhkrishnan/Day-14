import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramPalindromePrimeFinder {

    public static void main(String[] args) {
        int startRange = 0;
        int endRange = 1000;

        System.out.println("Prime numbers between " + startRange + " and " + endRange + ":");
        List<Integer> primeNumbers = findPrimes(startRange, endRange);

        System.out.println("\nPrime numbers that are Anagram and Palindrome:");
        findAndPrintAnagramPalindromePrimes(primeNumbers);
    }

    public static List<Integer> findPrimes(int start, int end) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }

        return primeNumbers;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // Found a divisor, not a prime number
            }
        }

        return true; // No divisors found, it's a prime number
    }

    public static void findAndPrintAnagramPalindromePrimes(List<Integer> primeNumbers) {
        for (int prime : primeNumbers) {
            if (isPalindrome(prime) && hasAnagram(prime, primeNumbers)) {
                System.out.println(prime);
            }
        }
    }

    public static boolean isPalindrome(int num) {
        String numStr = Integer.toString(num);
        String reversedNumStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedNumStr);
    }

    public static boolean hasAnagram(int num, List<Integer> primeNumbers) {
        String numStr = Integer.toString(num);
        char[] numArray = numStr.toCharArray();
        Arrays.sort(numArray);

        for (int prime : primeNumbers) {
            if (prime != num) {
                String primeStr = Integer.toString(prime);
                char[] primeArray = primeStr.toCharArray();
                Arrays.sort(primeArray);

                if (Arrays.equals(numArray, primeArray)) {
                    return true;
                }
            }
        }

        return false;
    }
}

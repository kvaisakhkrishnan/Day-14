import java.util.*;

public class PrimeNumberProgram {
    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        List<Integer> anagramPrimes = new ArrayList<>();
        List<Integer> nonAnagramPrimes = new ArrayList<>();

        for (int prime : primes) {
            if (isAnagramPrime(prime, primes)) {
                anagramPrimes.add(prime);
            } else {
                nonAnagramPrimes.add(prime);
            }
        }

        int[][] primeArray = new int[2][];
        primeArray[0] = anagramPrimes.stream().mapToInt(i -> i).toArray();
        primeArray[1] = nonAnagramPrimes.stream().mapToInt(i -> i).toArray();

        System.out.println("Anagram Primes: " + Arrays.toString(primeArray[0]));
        System.out.println("Non-Anagram Primes: " + Arrays.toString(primeArray[1]));
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramPrime(int prime, List<Integer> primes) {
        // Implement logic to check if the prime is an anagram prime
        // Hint: Use the concept of multiplying the characters of the prime
        return true;
    }
}
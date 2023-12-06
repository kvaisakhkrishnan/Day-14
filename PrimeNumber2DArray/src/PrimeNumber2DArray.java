import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber2DArray {

    public static void main(String[] args) {
        // Define the range and the size of each sub-range
        int startRange = 0;
        int endRange = 1000;
        int subRangeSize = 100;

        // Calculate the number of sub-ranges
        int numSubRanges = (endRange - startRange) / subRangeSize + 1;

        // Create a 2D array to store prime numbers
        List<List<Integer>> primeNumbers2DArray = new ArrayList<>();

        // Initialize the 2D array
        for (int i = 0; i < numSubRanges; i++) {
            primeNumbers2DArray.add(new ArrayList<>());
        }

        // Find prime numbers and store them in the 2D array
        for (int num = startRange; num <= endRange; num++) {
            if (isPrime(num)) {
                int subRangeIndex = (num - startRange) / subRangeSize;
                primeNumbers2DArray.get(subRangeIndex).add(num);
            }
        }

        // Print the prime numbers in the 2D array
        for (int i = 0; i < numSubRanges; i++) {
            System.out.println("Prime numbers in range " + (startRange + i * subRangeSize) + " to "
                    + (startRange + (i + 1) * subRangeSize - 1) + ": " + primeNumbers2DArray.get(i));
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
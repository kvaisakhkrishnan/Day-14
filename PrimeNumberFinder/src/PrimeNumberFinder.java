public class PrimeNumberFinder {

    public static void main(String[] args) {
        int startRange = 0;
        int endRange = 1000;

        System.out.println("Prime numbers between " + startRange + " and " + endRange + ":");
        findAndPrintPrimes(startRange, endRange);
    }

    public static void findAndPrintPrimes(int start, int end) {
        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; 
            }
        }

        return true;
    }
}

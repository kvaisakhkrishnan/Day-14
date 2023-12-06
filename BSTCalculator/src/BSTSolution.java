import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BSTCalculator {

    private static final int MOD = 1000000007;
    private static final int MOD_10_8 = (int) Math.pow(10, 8) + 7;

    private static Map<Integer, Integer> memoization = new HashMap<>();

    public static void calculateBSTNumbers(List<Integer> numbers) {
        for (int numNodes : numbers) {
            int result = calculateTotalBSTCombinations(numNodes);
            System.out.println(result);
        }
    }

    private static int calculateTotalBSTCombinations(int numNodes) {
        if (memoization.containsKey(numNodes)) {
            return memoization.get(numNodes);
        }
        if (numNodes == 0 || numNodes == 1) {
            return 1;
        }

        long combinations = 0;
        for (int j = 1; j <= numNodes; j++) {
            combinations = (combinations + ((long) calculateTotalBSTCombinations(j - 1)
                    * calculateTotalBSTCombinations(numNodes - j)) % MOD_10_8) % MOD_10_8;
        }

        memoization.put(numNodes, (int) combinations);
        return (int) combinations;
    }
}

public class BSTSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/vaisakhkrishnank/IdeaProjects/BSTCalculator/src/in_bst.txt"))) {
            int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < numbersCount; i++) {
                int numbersItem = Integer.parseInt(bufferedReader.readLine().trim());
                numbers.add(numbersItem);
            }

            BSTCalculator.calculateBSTNumbers(numbers);
        }
    }
}

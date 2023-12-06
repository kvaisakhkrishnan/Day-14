import java.util.*;
public class Driver {
    public static void main(String[] args) {
        Words words = new Words();
        int count = 0;
        System.out.print("Enter No Of Words: ");
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        for(int i = 0; i < count; i += 1){
            System.out.print("Enter Words: ");
            String word = scanner.next();
            words.addWords(word);
        }
        words.mergeSort(words.words, words.words.size());
        words.displayWords();
    }
}

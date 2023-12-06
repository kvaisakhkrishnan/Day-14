import java.util.ArrayList;

public class Words {
    ArrayList<String> words;
    public Words(){
        words = new ArrayList<>();
    }
    public void addWords(String word){
        words.add(word);
    }
    public void mergeSort(ArrayList<String> listOfWords, int size) {
        if (size < 2) {
            return;
        }

        int sizeEach = size / 2;
        ArrayList<String> leftArray = new ArrayList<>();
        ArrayList<String> rightArray = new ArrayList<>();

        for (int i = 0; i < sizeEach; i++) {
            leftArray.add(listOfWords.get(i));
        }
        for (int i = sizeEach; i < size; i++) {
            rightArray.add(listOfWords.get(i));
        }

        mergeSort(leftArray, leftArray.size());
        mergeSort(rightArray, rightArray.size());

        int i = 0, j = 0, k = 0;

        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i).compareTo(rightArray.get(j)) <= 0) {
                listOfWords.set(k, leftArray.get(i));
                i++;
            } else {
                listOfWords.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        while (i < leftArray.size()) {
            listOfWords.set(k, leftArray.get(i));
            i++;
            k++;
        }

        while (j < rightArray.size()) {
            listOfWords.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
    public void displayWords(){
        for(String word : this.words){
            System.out.println(word);
        }
    }
}

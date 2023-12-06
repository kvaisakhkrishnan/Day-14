public class Driver {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        AnagramChecker anagramChecker = new AnagramChecker();
        if (anagramChecker.areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}

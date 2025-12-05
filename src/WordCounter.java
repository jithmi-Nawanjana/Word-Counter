import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String trimmedSentence = sentence.trim();

        if (trimmedSentence.isEmpty()) {
            System.out.println("Number of words: 0");
            System.out.println("Number of characters: 0");
            scanner.close();
            return;
        }

        int wordCount = countWords(trimmedSentence);
        int characterCount = trimmedSentence.length();

        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of characters: " + characterCount);
        scanner.close();
    }

    private static int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }
}


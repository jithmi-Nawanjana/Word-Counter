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
            System.out.println("Number of vowels: 0");
            System.out.println("Number of consonants: 0");
            System.out.println("Number of sentences: 0");
            System.out.println("Longest word: N/A");
            scanner.close();
            return;
        }

        int wordCount = countWords(trimmedSentence);
        int characterCount = trimmedSentence.length();
        int vowelCount = countVowels(trimmedSentence);
        int consonantCount = countConsonants(trimmedSentence);
        int sentenceCount = countSentences(trimmedSentence);
        String longestWord = findLongestWord(trimmedSentence);

        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of characters: " + characterCount);
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Longest word: " + longestWord);
        scanner.close();
    }

    private static int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }

    private static int countVowels(String text) {
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    private static int countConsonants(String text) {
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch) && !isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isVowel(char ch) {
        char lower = Character.toLowerCase(ch);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    private static int countSentences(String sentence) {
        int count = 0;
        for (char ch : sentence.toCharArray()) {
            if (ch == '.' || ch == '!' || ch == '?') {
                count++;
            }
        }
        return count > 0 ? count : 1;
    }

    private static String findLongestWord(String sentence) {
        String longest = "";
        for (String token : sentence.split("\\s+")) {
            String word = token.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");
            if (word.isEmpty()) {
                continue;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest.isEmpty() ? "N/A" : longest;
    }
}


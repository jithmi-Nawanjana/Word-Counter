import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            runMenu(scanner);
        }
    }

    private static void runMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    handleWordCount(scanner);
                    break;
                case "2":
                    handleDetailedAnalysis(scanner);
                    break;
                case "3":
                    handleFileWordCounter(scanner);
                    break;
                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

            if (running) {
                System.out.println();
            }
        }
    }

    private static void printMenu() {
        System.out.println("Word Counter Menu");
        System.out.println("1. Word Count");
        System.out.println("2. Detailed Analysis");
        System.out.println("3. File Word Counter");
        System.out.println("4. Exit");
    }

    private static void handleWordCount(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            System.out.println("Number of words: 0");
            System.out.println("Number of characters: 0");
            return;
        }

        int wordCount = countWords(trimmed);
        int characterCount = trimmed.length();

        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of characters: " + characterCount);
    }

    private static void handleDetailedAnalysis(Scanner scanner) {
        System.out.print("Enter text to analyze: ");
        String input = scanner.nextLine();
        printDetailedStatistics(input.trim());
    }

    private static void handleFileWordCounter(Scanner scanner) {
        System.out.print("Enter a text file path: ");
        String filePath = scanner.nextLine().trim();

        try {
            String fileContents = readTextFromFile(filePath);
            printDetailedStatistics(fileContents.trim());
        } catch (IOException e) {
            System.out.println("Unable to read file: " + e.getMessage());
        }
    }

    private static void printDetailedStatistics(String text) {
        if (text.isEmpty()) {
            printEmptyDetailedStats();
            return;
        }

        int wordCount = countWords(text);
        int characterCount = text.length();
        int vowelCount = countVowels(text);
        int consonantCount = countConsonants(text);
        int sentenceCount = countSentences(text);
        String longestWord = findLongestWord(text);
        WordFrequency mostFrequentWord = findMostFrequentWord(text);

        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of characters: " + characterCount);
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Longest word: " + longestWord);
        String frequencyLabel = mostFrequentWord.count == 1 ? " time" : " times";
        System.out.println("Most frequent word: " + mostFrequentWord.word
                + " (" + mostFrequentWord.count + frequencyLabel + ")");
    }

    private static void printEmptyDetailedStats() {
        System.out.println("Number of words: 0");
        System.out.println("Number of characters: 0");
        System.out.println("Number of vowels: 0");
        System.out.println("Number of consonants: 0");
        System.out.println("Number of sentences: 0");
        System.out.println("Longest word: N/A");
        System.out.println("Most frequent word: N/A (0 times)");
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
            String word = cleanWord(token);
            if (word.isEmpty()) {
                continue;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest.isEmpty() ? "N/A" : longest;
    }

    private static WordFrequency findMostFrequentWord(String sentence) {
        Map<String, WordFrequency> frequencyMap = new LinkedHashMap<>();
        for (String token : sentence.split("\\s+")) {
            String cleaned = cleanWord(token);
            if (cleaned.isEmpty()) {
                continue;
            }
            String normalized = cleaned.toLowerCase();
            WordFrequency frequency = frequencyMap.get(normalized);
            if (frequency == null) {
                frequencyMap.put(normalized, new WordFrequency(cleaned, 1));
            } else {
                frequency.increment();
            }
        }

        WordFrequency result = new WordFrequency("N/A", 0);
        for (WordFrequency frequency : frequencyMap.values()) {
            if (frequency.count > result.count) {
                result = frequency;
            }
        }
        return result;
    }

    private static String cleanWord(String token) {
        return token.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");
    }

    private static String readTextFromFile(String filePath) throws IOException {
        if (filePath.isEmpty()) {
            throw new IOException("No file path provided.");
        }

        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IOException("File not found: " + path);
        }
        if (!Files.isRegularFile(path)) {
            throw new IOException("Path does not point to a file: " + path);
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (content.length() > 0) {
                    content.append(System.lineSeparator());
                }
                content.append(line);
            }
        }
        return content.toString();
    }

    private static class WordFrequency {
        private final String word;
        private int count;

        private WordFrequency(String word, int count) {
            this.word = word;
            this.count = count;
        }

        private void increment() {
            this.count++;
        }
    }
}


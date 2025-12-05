# Word Counter

Stage 4 turns the Java Word Counter project into a file-based tool. Provide a
path to a text file and the application will read it before reporting:

- Number of words
- Number of characters (spaces between words are included)
- Number of vowels
- Number of consonants (letters that are not vowels)
- Number of sentences (`.`, `!`, or `?` delimiters; defaults to 1 when none)
- Longest word (punctuation trimmed off the ends)
- Most frequent word (case-insensitive; earliest word wins if there is a tie)

This stage layers file handling (via `Files.newBufferedReader`) and exception
handling on top of the loops, conditionals, and string manipulation from the
previous stages.

## Getting Started

1. Ensure you have a Java Development Kit (JDK 11+) available on your PATH.
2. Compile the program:

```
javac src/WordCounter.java
```

3. Run the program:

```
java -cp src WordCounter
```

The program will prompt for the text file path and validate it before running
any statistics. Invalid paths and unreadable files are reported with a clear
error message.

### Example

Create a file named `sample.txt` with the following contents, then run the
program and provide the file path when prompted.

Input:

```
java is good and java is powerful
```

Output:

```
Enter a text file path: sample.txt
Number of words: 7
Number of characters: 33
Number of vowels: 12
Number of consonants: 15
Number of sentences: 1
Longest word: powerful
Most frequent word: java (2 times)
```

The project now covers `split`, `trim`, `length`, loops, conditionals,
`HashMap`-style counting, file I/O with `BufferedReader`, and exception handling.

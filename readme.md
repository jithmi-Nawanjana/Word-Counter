# Word Counter

Stage 5 transforms the Java Word Counter project into a menu-driven console
application. Select an option and the program will perform the appropriate
analysis:

- Number of words
- Number of characters (spaces between words are included)
- Number of vowels
- Number of consonants (letters that are not vowels)
- Number of sentences (`.`, `!`, or `?` delimiters; defaults to 1 when none)
- Longest word (punctuation trimmed off the ends)
- Most frequent word (case-insensitive; earliest word wins if there is a tie)

Menu options:

1. **Word Count** – basic word/character totals for a user-entered sentence.
2. **Detailed Analysis** – full statistics for on-the-fly input.
3. **File Word Counter** – read a text file, then run the full analysis.
4. **Exit** – close the application.

This stage emphasizes app structure, modular design, code reuse, file handling,
and exception handling on top of the string-processing concepts from earlier
stages.

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

Choose a menu option when prompted. Invalid selections are handled gracefully,
and the menu reappears until you choose to exit. File-based analysis validates
the path and reports helpful errors if the file cannot be read.

### Example

Create a file named `sample.txt` with the following contents:

```
java is good and java is powerful
```

Sample session:

```
Word Counter Menu
1. Word Count
2. Detailed Analysis
3. File Word Counter
4. Exit
Choose an option: 1

Enter a sentence: I love Java programming
Number of words: 4
Number of characters: 23

Word Counter Menu
1. Word Count
2. Detailed Analysis
3. File Word Counter
4. Exit
Choose an option: 3

Enter a text file path: sample.txt
Number of words: 7
Number of characters: 33
Number of vowels: 12
Number of consonants: 15
Number of sentences: 1
Longest word: powerful
Most frequent word: java (2 times)

Word Counter Menu
1. Word Count
2. Detailed Analysis
3. File Word Counter
4. Exit
Choose an option: 4

Goodbye!
```

The project now covers `split`, `trim`, `length`, loops, conditionals,
`HashMap`-style counting, file I/O with `BufferedReader`, exception handling,
and a modular menu-driven app structure.

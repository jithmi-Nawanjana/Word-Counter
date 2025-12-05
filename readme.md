# Word Counter

Stage 3 adds a most-frequent-word statistic to the Java Word Counter project.
The application reads a sentence from standard input, then reports:

- Number of words
- Number of characters (spaces between words are included)
- Number of vowels
- Number of consonants (letters that are not vowels)
- Number of sentences (`.`, `!`, or `?` delimiters; defaults to 1 when none)
- Longest word (punctuation trimmed off the ends)
- Most frequent word (case-insensitive; earliest word wins if there is a tie)

These additions practice loops, conditionals, string manipulation, and
`HashMap`-based counting logic.

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

### Example

Input:

```
java is good and java is powerful
```

Output:

```
Number of words: 7
Number of characters: 33
Number of vowels: 12
Number of consonants: 15
Number of sentences: 1
Longest word: powerful
Most frequent word: java (2 times)
```

The project now covers `split`, `trim`, `length`, loops, conditionals, and
`HashMap`-style counting.

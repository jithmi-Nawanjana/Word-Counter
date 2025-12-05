# Word Counter

# Word Counter

Stage 2 adds richer statistics to the Java Word Counter project. The
application reads a sentence from standard input, then reports:

- Number of words
- Number of characters (spaces between words are included)
- Number of vowels
- Number of consonants (letters that are not vowels)
- Number of sentences (`.`, `!`, or `?` delimiters; defaults to 1 when none)
- Longest word (punctuation trimmed off the ends)

These additions practice loops, conditionals, and general string manipulation.

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
I love Java programming
```

Output:

```
Number of words: 4
Number of characters: 23
Number of vowels: 8
Number of consonants: 12
Number of sentences: 1
Longest word: programming
```

The project now covers `split`, `trim`, `length`, loops, and conditionals.

# Word Counter

Stage 1 of the Java Word Counter project. The application reads a sentence
from standard input, then prints how many words and characters it contains.
Character counts include spaces between words (leading/trailing spaces are
ignored).

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
```

This stage practices `String` functions such as `split`, `trim`, and `length`.

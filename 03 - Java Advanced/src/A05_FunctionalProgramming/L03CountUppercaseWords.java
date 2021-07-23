package A05_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class L03CountUppercaseWords {

//    Write a program that reads one line of text from the console. Print the count of words that start with a
//    Uppercase letter, after that print all these words in the same order, like you found them in the text.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Predicate<String> isUppercaseWord = word ->
                Character.isAlphabetic(word.charAt(0)) ?
                Character.isUpperCase(word.charAt(0)) :
                        Character.isAlphabetic(word.charAt(1));

        List<String> capitalWords = Arrays.stream(words)
                .filter(isUppercaseWord)
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());

        capitalWords.forEach(System.out::println);

    }
}

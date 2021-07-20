package A04_StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class E04CountCharacterTypes {

//    Write a program that reads a list of words from the file (input.txt from the Resources - Exercises)
//    and finds the count of vowels, consonants and punctuation marks. Assume that:
//•	a, e, i, o, u are vowels, only lower case
//•	All others are consonants
//•	Punctuation marks are (!,.?)
//•	Do not count whitespace.

    public static void main(String[] args) throws IOException {
        String filePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/input.txt";
        String outputFilePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/output.txt";


        String text = Files.readString(Path.of(filePath)).replaceAll("\r\n", " ");
        int[] countData = new int[3];
        String vowels = "aeiou";
        String punctuation = "!,.?";

        for (char symbol : text.toCharArray()) {
            if(vowels.contains(symbol + "")){
                countData[0]++;
            }else if(punctuation.contains(symbol + "")){
                countData[2]++;
            }else if(symbol != ' '){
                countData[1]++;
            }
        }

        PrintWriter printer = new PrintWriter(outputFilePath);
        printer.printf("Vowels: %d\n" +
                        "Consonants: %d\n" +
                        "Punctuation: %d\n",
                countData[0], countData[1],countData[2]);

        printer.close();
    }
}

package A04_StreamsFilesAndDirectories;

import java.io.File;

public class E08GetFolderSize {
//    Write a program that traverses a folder and calculates its size in bytes. Use Folder Exercises Resources
//    in Resources.

    public static void main(String[] args) {
        String filePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/Exercises Resources";

        File[] files = new File(filePath).listFiles();

        int sum = 0;
        for(File file : files){
            sum += file.length();
        }

        System.out.println("Folder size: " +sum);
    }
}

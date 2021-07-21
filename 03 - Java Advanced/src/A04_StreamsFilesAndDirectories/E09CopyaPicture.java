package A04_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E09CopyaPicture {

//    Write a program that makes a copy of a .jpg file using FileInputStream, FileOutputStream, and byte[] buffer.
//    Set the name of the new file as picture-copy.jpg.

    public static void main(String[] args) throws IOException {
        String filePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/img.jpg";
        String filePathOutput = "src/A04_StreamsFilesAndDirectories/Resources/ex/Pale-Blue-Dot.jpeg";

        FileInputStream inputStream = new FileInputStream(filePath);

        byte[] image = inputStream.readAllBytes();

        FileOutputStream outputStream = new FileOutputStream(filePathOutput);

        outputStream.write(image);

        outputStream.close();
    }
}

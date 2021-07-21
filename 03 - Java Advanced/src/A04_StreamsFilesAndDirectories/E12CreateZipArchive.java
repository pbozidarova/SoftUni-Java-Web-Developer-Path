package A04_StreamsFilesAndDirectories;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class E12CreateZipArchive {

//    Write a program that reads three .txt files and creates a zip archive named files.zip. Use FileOutputStream,
//    ZipOutputStream, and FileInputStream .

    public static void main(String[] args) throws IOException {
        String filePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/zip.zip";
        String filePathIn = "src/A04_StreamsFilesAndDirectories/Resources/ex/output.txt";

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(filePath));

        FileInputStream fileInputStream = new FileInputStream(filePathIn);

        zipOutputStream.putNextEntry(new ZipEntry("output.txt"));
        zipOutputStream.write(fileInputStream.readAllBytes());
        zipOutputStream.close();
    }
}

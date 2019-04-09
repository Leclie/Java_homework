package task11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/task11/file");
        Main.copyFile(file);
    }

    public static void copyFile(File file) throws IOException {
        long sum = 0;

        try(FileInputStream inputStream = new FileInputStream(file)){

            System.out.println("Введите имя файла");
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();
            String pathName = fileName;

            File copyFile = new File(pathName);

            while(inputStream.available() > 0){
                ++sum;
                int data = inputStream.read();
                Main.writeByte(fileName, true, Charset.forName("UTF-8"), data);
            }
            System.out.println("количество скопированных байт = " + sum);
        }

    }

    public static void writeByte(String fileName, boolean append, Charset charset, int data) throws IOException{
        try(FileOutputStream outputStream = new FileOutputStream(fileName, append)){
            outputStream.write(data);
        }
    }
}

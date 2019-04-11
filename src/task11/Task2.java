package task11;

import java.io.*;
import java.util.Scanner;

public class Task2 {

    public void work(){
        System.out.println("1. Разбить");
        System.out.println("2. Склеить");
        int answer = new Scanner(System.in).nextInt();
        try {
            if (answer == 1){ toBreak(); }
            else { toGlue(); }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ДЕЛЕНИЕ ФАЙЛА НА 2
    private void toBreak() throws IOException {
        System.out.println("Какой файл разделить?");
        String answer = new Scanner(System.in).nextLine();
        File file = new File("D:\\JAVA\\Java_homework\\src\\task11\\" + answer);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            System.out.println("Введите количество байт:");
            long countOfBytes = file.length() - new Scanner(System.in).nextInt();
            String fileName1 = "D:\\JAVA\\Java_homework\\src\\task11\\" + answer + ".1";
            String fileName2 = "D:\\JAVA\\Java_homework\\src\\task11\\" + answer + ".2";
            while (fileInputStream.available() > countOfBytes){
                int data = fileInputStream.read();
                Main.writeByte(fileName1, true, data);
            }
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                Main.writeByte(fileName2, true, data);
            }
        }
    }

    // СКЛЕИВАНИЕ ДВУХ ФАЙЛОВ
    private void toGlue() throws IOException {
        System.out.println("Введите 1 файл");
        Scanner scanner1 = new Scanner(System.in);
        String firstFile = scanner1.nextLine();
        File file1 = new File("D:\\JAVA\\Java_homework\\src\\task11\\" + firstFile);


        System.out.println("Введите 2 файл");
        Scanner scanner2 = new Scanner(System.in);
        String secondFile = scanner2.nextLine();
        File file2 = new File("D:\\JAVA\\Java_homework\\src\\task11\\" + secondFile);



        String newFileName = "D:\\JAVA\\Java_homework\\src\\task11\\" + firstFile + secondFile;
        try (FileInputStream fileInputStream = new FileInputStream(file1)) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                Main.writeByte(newFileName, true, data);
            }
        }
        try (FileInputStream fileInputStream = new FileInputStream(file2)) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                Main.writeByte(newFileName, true, data);
            }
        }

        scanner1.close();
        scanner2.close();
    }

    // МЕТОД ДЛЯ ЗАПИСИ В ФАЙЛ
    private void writeByte(String fileName, boolean append, int data) throws IOException{
        try(FileOutputStream outputStream = new FileOutputStream(fileName, append)){
            outputStream.write(data);
        }
    }
}

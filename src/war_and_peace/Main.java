// ВЫПОЛНЕНО ТОЛЬКО 1, 2 ЗАДАНИЯ
package war_and_peace;

import sun.plugin.javascript.navig.LinkArray;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\JAVA\\Java_homework\\resources\\wp.txt");
        Scanner scanner = new Scanner(file);
        int wordCount = 0;
        Zadanie2 zadanie2 = new Zadanie2();

        while(scanner.hasNext()){
            String text = scanner.nextLine();
            String[] lines = text.toLowerCase().replaceAll("\\p{Punct}", " ").trim().split(" ");
            for (String word : lines) {
                if(word.length() > 0){
                    // ЗАДАНИЕ 1
                    ++wordCount;

                    // ЗАДАНИЕ 2
                    zadanie2.work(word);
                }
            }
        }
        // ЗАДАНИЕ 1
        System.out.println("Количество слов: " + wordCount);
        // ЗАДАНИЕ 2
        zadanie2.out();

        scanner.close();
    }
}

// ВЫПОЛНЕНО ТОЛЬКО 1, 2 ЗАДАНИЯ
package war_and_peace;

import sun.plugin.javascript.navig.LinkArray;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File file = new File("D:\\JAVA\\lessons-master\\resources\\wp.txt");
        Scanner scanner = new Scanner(file);
//        int wordCount = 0;
//        Zadanie2 zadanie2 = new Zadanie2();
//        Zadanie3 zadanie3 = new Zadanie3();




        ArrayList<String> allText = new ArrayList<>();
        while(scanner.hasNext()){
            String text = scanner.nextLine();
            String[] lines = text.toLowerCase().replaceAll("\\p{Punct}", " ").trim().split(" ");
            for (String word : lines) {
                if(word.length() > 0){
                    // ЗАДАНИЕ 1
//                    ++wordCount;

                    // ЗАДАНИЕ 2
//                    zadanie2.work(word);

                    // ЗАДАНИЕ 3
//                    zadanie3.setWord(word);

                    allText.add(word);
                }
            }
        }
        // ЗАДАНИЕ 1
//        System.out.println("Количество слов: " + wordCount);
        // ЗАДАНИЕ 2
//        zadanie2.out();

        // ЗАДАНЕИ 3
//        zadanie3.out();


        int parts = allText.size() / Runtime.getRuntime().availableProcessors();
        ArrayList<Thread> threads = new ArrayList<>();
        int predIndex = 0;
        int sledIndex = parts;
        int processorsCount = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < processorsCount; ++i){
            if (processorsCount - i == 1){
                sledIndex = allText.size() - 1;
                threads.add(new Thread(new Zadanie3(allText.subList(predIndex, sledIndex))));
            }
            threads.add(new Thread(new Zadanie3(allText.subList(predIndex, sledIndex))));
            predIndex += parts;
            sledIndex += parts;
        }

        for (int i = 0; i < processorsCount; ++i){
            threads.get(i).start();
        }

        for(Thread x : threads){
            x.join();
        }
        Zadanie3.outt();

        scanner.close();

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("src/war_and_peace/top.txt"), true)){
            byte[] bytes = Zadanie3.getHashMap().toString().getBytes();
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
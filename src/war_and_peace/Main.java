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
        ArrayList<Integer> count = new ArrayList<>();
        ArrayList<String> wordc = new ArrayList<>();
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        while(scanner.hasNext()){
            String text = scanner.nextLine();
            String[] lines = text.toLowerCase().replaceAll("\\p{Punct}", " ").trim().split(" ");
            for (String word : lines) {
                if(word.length() > 0){
                    ++wordCount;


                    if(map.containsKey(word.length())){
                        if(!map.get(word.length()).contains(word)){
                            ArrayList<String> a = new ArrayList<>(map.get(word.length()));
                            a.add(word);
                            map.put(word.length(), a);
                        }

                    }else{
                        ArrayList<String> list = new ArrayList<>();
                        list.add(word);
                        map.put(word.length(), list);
                    }
                }
            }
        }
        System.out.println("Количество слов: " + wordCount);
        for(int i = 1; i < map.size(); ++i){
            System.out.println("Количество букв " + (i+1) + ":");
            ArrayList<String> b = new ArrayList<>();
            b = map.get((i+1));
            System.out.println(b);
            System.out.println();
        }

        scanner.close();

    }

}

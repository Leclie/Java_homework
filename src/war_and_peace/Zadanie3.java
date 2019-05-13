package war_and_peace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.max;

public class Zadanie3 implements Runnable {
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<Integer> counts = new ArrayList<>();
    private ArrayList<String> topWords = new ArrayList<>();
    private List<String> text;
    private static HashMap<Integer, String> hashMap = new HashMap<>();

    Zadanie3(List<String> text){
        this.text = text;
    }

    public static HashMap<Integer, String> getHashMap() {
        return hashMap;
    }

    public void setWord(String word){
        if(!words.contains(word)){
            words.add(word);
            counts.add(1);
        }else {
            addCount(word);
        }
    }

    private void addCount(String word){
        int index = words.indexOf(word);
        Integer element = counts.get(index);
        counts.set(index, ++element);
    }

    public void out(){
        int max = max(counts);
        for (int i = 0; i < 100; ++i){
            topWords.add(words.get(counts.indexOf(max)));
            do{
                --max;
            }while(!counts.contains(max));
        }
    }

    @Override
    public void run() {
        for (String word : text){
            setWord(word);
        }
        out();
        synchronized (hashMap){
            for (Integer i = 0; i < 100; ++i){
                hashMap.put(i, topWords.get(i));
            }
        }
    }

    public static void outt(){
        System.out.println(hashMap);
    }
}

package war_and_peace;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.max;

public class Zadanie3 {
    private ArrayList<String> words;
    private ArrayList<Integer> counts;
    private String[] topWords;

    Zadanie3(){
        words = new ArrayList<>();
        counts = new ArrayList<>();
        topWords = new String[10];
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
        for (int i = 0; i < 10; ++i){
            topWords[i] = words.get(counts.indexOf(max));
            do{
                --max;
            }while(!counts.contains(max));
        }
        System.out.println("Топ 10 слов:");
        System.out.println(Arrays.toString(topWords));
    }
}

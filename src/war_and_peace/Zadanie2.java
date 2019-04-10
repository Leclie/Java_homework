package war_and_peace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Zadanie2 {
    private Map<Integer, ArrayList<String>> map = new HashMap<>();

    public void work(String word){
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


    // ВЫВОД В КОНСОЛЬ
    public void out(){
        for(int i = 1; i < map.size(); ++i){
            System.out.println("Количество букв " + (i+1) + ":");
            System.out.println(map.get((i+1)));
            System.out.println();
        }
    }
}

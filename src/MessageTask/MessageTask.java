package lesson9.enums;

import lesson9.enums.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lesson9.enums.MessagePriority.HIGH;
import static lesson9.enums.MessagePriority.LOW;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритела
        // Ответ в консоль

        int low = 0, medium = 0, high = 0, urgent = 0;

        for ( Message m : messageList ) {
            switch(m.getPriority()){
                case LOW:
                    ++low; break;
                case MEDIUM:
                    ++medium; break;
                case HIGH:
                    ++high; break;
                case URGENT:
                    ++urgent; break;
            }
        }
        System.out.println("LOW = " + low);
        System.out.println("MEDIUM = " + medium);
        System.out.println("HIGH = " + high);
        System.out.println("URGENT = " + urgent);
    }

    public static void main(String[] args) {
        ArrayList<Message> a = new ArrayList<>();
        MessagePriority b = LOW, c = HIGH;
        a.add(new Message(123, c));
        a.add(new Message(123, c));
        a.add(new Message(234, b));
        a.add(new Message(123, b));
        a.add(new Message(567, b));
        a.add(new Message(567, b));
        a.add(new Message(0, b));
        a.add(new Message(1, b));
        MessageTask.removeOther(a, c);
    }

    public static void countEachCode(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого кода сообщения
        // Ответ в консоль

        ArrayList<Message> buffer = new ArrayList<>(messageList);
        for(int i = 0; i < buffer.size(); ++i){
            Integer a = buffer.get(i).getCode();
            int count = 1;
            for(int j = i+1; j < buffer.size(); ++j){
                if(a == buffer.get(j).getCode()){
                    ++count;
                    buffer.remove(j);
                }
            }
            System.out.println("количество записей с кодом " + buffer.get(i).getCode() + " = " + count);
        }
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // Подсчитать количество уникальных сообщений
        // Ответ в консоль
        ArrayList<Message> buffer = new ArrayList<>(messageList);
        int count = 0;
        for(int i = 0; i < buffer.size(); ++i){
            boolean r = true;
            for(int j = i+1; j < buffer.size(); ++j){
                if(buffer.get(i).equals(buffer.get(j))){
                    buffer.remove(j);
                    r = false;
                }
            }
            if(r){
                ++count;
            }
        }
        System.out.println("количество уникальных сообщений = " + count);
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // вернуть только неповторяющиеся сообщения и в том порядке, в котором они
        // встретились в первоначальном списке
        // Например, было
//        [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        // на выходе:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        for(int i = 0; i < messageList.size(); ++i){
            Integer a = messageList.get(i).getCode();
            for(int j = i+1; j < messageList.size(); ++j){
                if(a == messageList.get(j).getCode()){
                    messageList.remove(j);
                }
            }
        }
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции каждое сообщение с заданным приоритетом
        // вывод до удалеия и после удаления

        System.out.println(messageList.toString());

        for(int i = 0; i < messageList.size(); ++i){
            if(messageList.get(i).getPriority() == priority){
                messageList.remove(i);
                --i;
            }
        }

        System.out.println(messageList.toString());
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        // вывод до удалеия и после удаления

        System.out.println(messageList.toString());

        for(int i = 0; i < messageList.size(); ++i){
            if(messageList.get(i).getPriority() != priority){
                messageList.remove(i);
                --i;
            }
        }

        System.out.println(messageList.toString());
    }


}

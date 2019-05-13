package May6;

import task11.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Restaurant {
    private static int id = 0;

    public static int getId() {
        return id;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Visitor> visitorArrayList1 = new ArrayList<>();
        ArrayList<Visitor> visitorArrayList2 = new ArrayList<>();
        ArrayList<Visitor> visitorArrayList3 = new ArrayList<>();

        Thread thread1 = new Thread(new Cashbox(visitorArrayList1));
        Thread thread2 = new Thread(new Cashbox(visitorArrayList2));
        Thread thread3 = new Thread(new Cashbox(visitorArrayList3));

        thread1.start();
        thread2.start();
        thread3.start();
        ArrayList<StringBuilder> stringBuilderArrayList = new ArrayList<>(3);
        stringBuilderArrayList.add(new StringBuilder());
        stringBuilderArrayList.add(new StringBuilder());
        stringBuilderArrayList.add(new StringBuilder());
        int ran = new Random().nextInt()/10000000;
        if (ran < 0){ ran *=-1; }
        try {
            while (id<10){
                Thread.sleep(ran);
                // Выбор самой маленькой очереди
                Visitor newVisitor = new Visitor(id);
                if (visitorArrayList1.size() < visitorArrayList2.size()){
                    if (visitorArrayList1.size() < visitorArrayList3.size()){
                        visitorArrayList1.add(newVisitor);
                        stringBuilderArrayList.get(0).append(" " + newVisitor.getId());
                    }else{
                        visitorArrayList3.add(newVisitor);
                        stringBuilderArrayList.get(2).append(" " + newVisitor.getId());
                    }
                } else if (visitorArrayList2.size() < visitorArrayList3.size()){
                    visitorArrayList2.add(newVisitor);
                    stringBuilderArrayList.get(1).append(" " + newVisitor.getId());
                }else {
                    visitorArrayList3.add(newVisitor);
                    stringBuilderArrayList.get(2).append(" " + newVisitor.getId());
                }
                id++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.join();
        thread2.join();
        thread3.join();

        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/May6/text.txt"), true);
        for (StringBuilder stringBuilder : stringBuilderArrayList){
            byte[] bytes = (stringBuilder.toString() + '\n').getBytes();
            fileOutputStream.write(bytes);
        }

    }
}

class Visitor{
    private int id;

    public Visitor(int id) {
        if (id < 0){
            id *=-1;
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Cashbox implements Runnable{
    private volatile ArrayList<Visitor> visitorArrayList;

    public Cashbox(ArrayList<Visitor> visitorArrayList) {
        this.visitorArrayList = visitorArrayList;
    }

    @Override
    public void run() {
        try {
            synchronized (visitorArrayList) {
                while (Restaurant.getId()<10) {
                    if (!visitorArrayList.isEmpty()) {
                        System.out.println("Обслуживается клиент " + visitorArrayList.get(0).getId() + " в потоке " + Thread.currentThread().getName());
                        int ran = new Random().nextInt()/1000000;
                        if (ran < 0){ ran *=-1; }
                        Thread.sleep(ran);
                        System.out.println("Завершено обслуживание клиента " + visitorArrayList.get(0).getId() + " в потоке " + Thread.currentThread().getName());
                        visitorArrayList.remove(0);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
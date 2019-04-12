package task12;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Server {
    String port;
    Connection connection;
    ArrayList<String> users;


    public Server(String port) {
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port))){
            System.out.println("Сервер запустился");
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                // ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ
                users.add(connection.readCommand().getUser());
                workCommand(connection.readCommand());
            }
        }
    }

    public void workCommand(Command command){
        String com = command.getCommand();
        System.out.println("Выполняется" + command.getCommand());
        switch (com){
            case "list_user":
                listUser();
                break;
            case "server_time":
                serverTime();
                break;
            case "ping":
                ping();
                break;
        }
    }

    private void listUser(){
        System.out.println("Список пользователей:" + users);
        System.out.println(users);
    }

    private void serverTime(){
        Date date = new Date();
        System.out.println("Текущее время:");
        System.out.println(date.toString());
    }

    private void ping(){

    }


    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream inputStream = Client.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Server server = new Server(properties.getProperty("port"));
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

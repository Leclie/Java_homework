package task12;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;

public class Client {

    private String server;
    private String port;
    private Connection connection;

    public Client(String server, String port){
        this.server = server;
        this.port = port;
    }

    public void start(){
        while (true) {
            System.out.println("Введите имя");
            Scanner scanner1 = new Scanner(System.in);
            String user = scanner1.nextLine();

            System.out.println("Введите номер команды");
            System.out.println("1. Вывод всех пользователей сервера");
            System.out.println("2. Вывод времени");
            Scanner scanner2 = new Scanner(System.in);
            int com = scanner2.nextInt();
            Command command = null;
            switch (com) {
                case 1:
                    command = new Command(user, "list_user");
                    break;
                case 2:
                    command = new Command(user, "server_time");
                    break;
            }
            connect(command);
            scanner1.close();
            scanner2.close();
        }
    }

    public void connect(Command command){
        try {
            connection = new Connection(new Socket(server, Integer.parseInt(port)));
            connection.sendCommand(command);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (InputStream inputStream = Client.class.getClassLoader().getResourceAsStream("config.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);
            String server = properties.getProperty("server");//"127.0.0.1";
            String port = properties.getProperty("port"); //8090;
            System.out.println(server + " " + port);
            Client messageClient = new Client(server, port);
            messageClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package task12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private Socket socket;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public void sendCommand(Command command) throws IOException {
        objectOutputStream.writeObject(command);
        objectOutputStream.flush();
    }

    public Command readCommand() throws IOException, ClassNotFoundException {
        return (Command) objectInputStream.readObject();
    }
    
    public void close() throws Exception {
        // закрытие ресурсов
        objectOutputStream.close();
        objectInputStream.close();
    }
}

package task12;

import java.io.Serializable;

public class Command implements Serializable {
    String user;
    String command;

    public Command(String user, String command){
        this.user = user;
        this.command = command;
    }

    public String getUser() {
        return user;
    }

    public String getCommand() {
        return command;
    }
}

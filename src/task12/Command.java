package task12;

public class Command {
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

package advance.socket.tcp;

import java.io.PrintWriter;

public class Commands {
    String command;
    PrintWriter out;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public Commands(String command, PrintWriter out){
        this.command = command;
        this.out = out;
    }

}

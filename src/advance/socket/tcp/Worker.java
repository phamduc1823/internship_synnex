package advance.socket.tcp;

import java.util.Queue;

public class Worker extends Thread{
    Queue<Commands> commandsQueue;

    public Worker(Queue<Commands> commandsQueue) {
        this.commandsQueue = commandsQueue;
    }

    @Override
    public void run() {
        while (true) {
            Commands commands = commandsQueue.poll();
            if (commands != null) {
                commands.getOut().println("success");
                commands.getOut().flush();
            }
        }
    }
}

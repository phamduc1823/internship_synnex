package advance.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        };

        long delay = 1000;
        Timer timer = new Timer("Timer");
        timer.schedule(timerTask,0, delay);
    }
}

package exercise.sen_message_thread;

import java.util.LinkedList;
import java.util.Queue;

class ProducerThreads extends Thread {
    private final Queue<String> producerQueue;
    private final int size;

    public ProducerThreads(Queue<String> producerQueue, int size) {
        this.producerQueue = producerQueue;
        this.size = size;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (producerQueue) {
                while (producerQueue.size() == size) {
                    try {
                        producerQueue.wait();
                        System.out.println("Queue is full! wait consumer send message ...");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                String text = "Text: " + i;
                System.out.println("Creating message: " + text);
                producerQueue.offer(text);
                producerQueue.notify();
                i++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class ConsumerThreads extends Thread {
    private final Queue<String> consumerQueue;

    public ConsumerThreads(Queue<String> consumerQueue) {
        this.consumerQueue = consumerQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (consumerQueue) {
                while (consumerQueue.isEmpty()) {
                    try {
                        consumerQueue.wait();
                        System.out.println("Queue is empty! wait producer create message ...");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                String message = consumerQueue.poll();
                System.out.println("Consuming message: " + message);
                consumerQueue.notify();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

public class SenMessageThread {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        ProducerThreads producer = new ProducerThreads(queue, 5);
        ConsumerThreads consumer = new ConsumerThreads(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

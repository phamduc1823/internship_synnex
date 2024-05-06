package advance.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class QueueArrayDeque{
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(3);
        queue.add(1);
        queue.add(2);
        queue.add(4);

        System.out.println("Queue: " + queue);

        int accessedNumber = queue.peek();
        System.out.println("Truy cập phần tử: " + accessedNumber);

        int removedNumber = queue.poll();
        System.out.println("Loại bỏ phần tử: " + removedNumber);

        System.out.println("Cập nhật Queue: " + queue);
    }
}

class QueuePriority{
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("Queue: " + queue);

        int accessedNumber = queue.peek();
        System.out.println("Truy cập phần tử: " + accessedNumber);

        int removedNumber = queue.poll();
        System.out.println("Loại bỏ phần tử: " + removedNumber);

        System.out.println("Cập nhật Queue: " + queue);
    }
}

class QueueLinkedList{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue);

        int accessedNumber = queue.peek();
        System.out.println("Truy cập phần tử: " + accessedNumber);

        int removedNumber = queue.poll();
        System.out.println("Loại bỏ phần tử: " + removedNumber);

        System.out.println("Cập nhật Queue: " + queue);
    }
}

public class QueueInJava {
    // LinkedList triển khai Queue
    Queue<String> animal1 = new LinkedList<>();

    // Array triển khai Queue
    Queue<String> animal2 = new ArrayDeque<>();

    // Priority Queue triển khai Queue
    Queue<String> animal3 = new PriorityQueue<>();
}

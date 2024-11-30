package Stack_and_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class main_customQueue {
    public static void main(String[] args) throws Exception{
        custom_queue queue = new dynamic_customQueue(5);
        queue.insert(5);
        queue.insert(3);
        queue.insert(9);
        queue.insert(19);
        queue.insert(34);
        queue.insert(35);

        System.out.println("front element of queue");
        System.out.println(queue.front());

        queue.display();

        System.out.println("poping from queue");
        System.out.println(queue.remove());
    }
}

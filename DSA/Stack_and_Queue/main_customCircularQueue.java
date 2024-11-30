package Stack_and_Queue;

public class main_customCircularQueue{
    public static void main(String[] args) throws Exception {
        custom_circularQueue Cqueue = new dynamic_circularQueue(5);
        Cqueue.insert(5);
        Cqueue.insert(3);
        Cqueue.insert(9);
        Cqueue.insert(19);
        Cqueue.insert(34);
        Cqueue.insert(35);

        System.out.println("front element of Cqueue");
        System.out.println(Cqueue.front());

        Cqueue.display();

        System.out.println("poping from Cqueue");
        System.out.println(Cqueue.remove());

    }
}



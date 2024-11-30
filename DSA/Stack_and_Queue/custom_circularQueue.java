package Stack_and_Queue;

public class custom_circularQueue {
    protected int[] data;
    private static final int defaultSize = 10;

    public custom_circularQueue(){
        this(defaultSize);
    }
    public custom_circularQueue(int size){
        this.data = new int[size];
    }
    protected int end = 0;
    protected int front = 0 ;
    private int size  = 0;

    public boolean isFull(){
        return size == data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean insert(int num){
        if(isFull()){
            System.out.println("Circular queue is full");
            return false;
        }
        data[end++] = num;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("Circular queue is empty");
        }
        int removed  = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }
    public int front() throws Exception {
          if(isEmpty()){
              throw new Exception("Circular queue is empty");
          }
          return data[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Circular queue is empty");
            return;
        }
        int i =front;
        do{
            System.out.print(data[i++] + " -> ");
            i %= data.length;
        } while(i != end);
        System.out.println("END");
    }
}

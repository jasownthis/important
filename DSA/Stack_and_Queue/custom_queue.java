package Stack_and_Queue;

public class custom_queue {
    protected int[] data;
    private static final int defaultSize = 10;
    int end = 0;
    public custom_queue(){
        this(defaultSize);
    }
    public custom_queue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return end == data.length;
    }
    public boolean isEmpty(){
        return end ==0;
    }
    public boolean insert(int num){
        if(isFull()){
            System.out.println("Queue is full");
            return false;
        }
        data[end++] = num;
        return true;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot remove from empty queue");
        }
        int removed = data[0];
        for(int i = 1; i < end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }

        return data[0];
    }
    public void display(){
        for(int i = 0 ; i< data.length ; i++){
            System.out.print(data[i]+" <- ");
        }
        System.out.println("END");
    }
}

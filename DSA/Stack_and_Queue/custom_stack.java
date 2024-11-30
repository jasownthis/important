package Stack_and_Queue;

public class custom_stack {
    protected int[] data;
    private static final int defaultSize = 10;
    int ptr = -1;

    public custom_stack(){
        this(defaultSize);
    }
    public custom_stack(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return ptr == data.length - 1;
    }
    public boolean isEmpty(){
        return ptr == -1;
    }
    public boolean push(int num){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        data[++ptr] = num;
        return true;
    }
    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is empty, cannot do pop");
        }
        return data[ptr--];
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        return data[ptr];
    }
    public void display(){
        for(int i = 0 ; i < data.length; i++){
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
}

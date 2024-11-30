package Stack_and_Queue;

public class dynamic_circularQueue extends custom_circularQueue{

    public dynamic_circularQueue(){
        super();
    }
    public dynamic_circularQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int num){
        if(this.isFull()){
            int[]  temp = new int[data.length * 2];
            for(int i = 0 ; i < data.length ; i++){
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(num);
    }
}

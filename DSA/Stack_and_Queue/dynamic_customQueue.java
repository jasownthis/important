package Stack_and_Queue;

public class dynamic_customQueue extends custom_queue {

    public dynamic_customQueue(){
        super();
    }
    public dynamic_customQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int num){
        if(this.isFull()){
            int[] temp = new int[data.length * 2];
            for(int i = 0 ; i < data.length ; i++){
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.insert(num);
    }
}

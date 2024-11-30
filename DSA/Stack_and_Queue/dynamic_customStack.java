package Stack_and_Queue;

public class dynamic_customStack extends custom_stack {
    public dynamic_customStack(){
        super();
    }

    public dynamic_customStack(int size){
        super(size);
    }

    @Override
    public boolean push(int num){
        if(this.isFull()){
            int[] temp = new int[data.length * 2];
            for(int i = 0 ; i<data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.push(num);
    }
}

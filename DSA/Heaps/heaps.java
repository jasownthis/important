package Heaps;
import java.util.*;

public class heaps<T extends Comparable<T>>{
    private ArrayList<T> list;
    public heaps(){
        list = new ArrayList<>();
    }

    public void swap(int first , int second){
        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second, temp);
    }

    public int parent(int indexOfChild){ return (indexOfChild - 1) / 2; }
    public int left(int indexOfParent){ return (indexOfParent * 2) + 1; }
    public int right(int indexOfParent){ return (indexOfParent * 2) + 2; }

    public void insert(T value){
        list.add(value);
        upHeap(list.size() -1);
    }

    void upHeap(int index){
        if(index == 0) return;
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p)) < 0){
            swap(index, p);
            upHeap(p);
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty()) throw new Exception("removing from empty list");
        T temp = list.get(0);
        T last = list.remove(list.size() -1);
        if(!list.isEmpty()){
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }

    void downHeap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) min = left;
        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) min = right;
        if(min != index){
            swap(min, index);
            downHeap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data =  new ArrayList<>();
        while(!list.isEmpty()) data.add(this.remove());
        return data;
    }
}

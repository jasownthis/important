package Heaps;
import java.util.*;
public class heapMain {
    public static void main(String[] args) throws Exception{
        heaps<Integer> heap = new heaps<>();
        heap.insert(45);
        heap.insert(32);
        heap.insert(22);
        heap.insert(12);
        heap.insert(5);

        ArrayList list = heap.heapSort();
        System.out.println(list);
    }
}

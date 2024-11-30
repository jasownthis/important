package Mathematic_in_DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class pegion_hole_sort {
    public static ArrayList<Integer> pegionHoleSort(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }

            if(max < arr[i]){
                max = arr[i];
            }
        }

        int range  = (max - min) + 1;
        ArrayList<Integer>[] list = new ArrayList[range];
        for(int j = 0 ; j < range; j++){
            list[j] = new ArrayList<>();
        }

        for(int val : arr){
            int index =  val - min;
            list[index].add(val);
        }

        ArrayList<Integer> sortedList = new ArrayList<>();
        for(ArrayList hole: list){
            sortedList.addAll(hole);
        }
        return sortedList;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,2,3,7,7,1,6};
        ArrayList<Integer> ans = pegionHoleSort(arr);
        System.out.println(ans);
    }
}

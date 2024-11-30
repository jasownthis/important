package Recursion;

import java.util.*;

public class subseq {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(subseqIterDuplication(arr));
    }

    static List<List<Integer>> subseqIter (int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int n : arr){
            int len = outer.size();
            for(int i =0 ; i< len; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(n);
                outer.add(internal);
            }
        }
        return outer;
    }
    /* if arr = [1,2,2] ,
        then output be like: [[], [1], [2], [1, 2], [2], [1, 2], [2, 2], [1, 2, 2]]

        -> In order to overcome duplication , we need to check whether arr[i] and arr[i-1] are not same.
     */
    static List<List<Integer>> subseqIterDuplication (int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length ; i++){
            start = 0;
            if( i > 0 && arr[i] == arr[i-1]){
                start = end +1;
            }
            end = outer.size() -1;
            int len = outer.size();
            for(int j = start ; j< len; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

}

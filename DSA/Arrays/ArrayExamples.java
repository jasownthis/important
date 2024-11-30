package Arrays;

import java.util.Arrays;

public class ArrayExamples {
    /* <===================== two pointer Method ==========================>
        1. opposite direction
        2. Equi - Direction (similar to sliding window) */

    //opposite method
    static String targetSum(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1 ;
        int[] ans = new int[2];

        while (start < end) {
            int sum = arr[start] + arr[end];
            if( sum == target ){
                ans[0] = start;
                ans[1] = end;
                break;
            }
            else if( sum < target){
                start ++ ;
            }
            else{
                end --;
            }
        }
        return Arrays.toString(ans);
    }

    //Equi - Directional method
    static int maxSub(int[] arr, int k){
        int start = 0 , end = 0;
        int maxSum = 0, windowSum = 0;
        while(end < k){
            windowSum += arr[end++];
        }
        maxSum = windowSum;
        while(end < arr.length){
            windowSum += arr[end++] - arr[start++];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
    //<==================== end of two pointer method =====================>

    /* <==================== simple Sorting ============================>
        1. Selection sort
        2. bubble sort
        3. insertion sort
    */

    // Selection sort
    static int[] selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0 ; i < n-1 ; i++){
            int min = i;
            for(int j = i+1 ; j < n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp =  arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    //bubble sort
    static int[] bubbleSort(int[] arr){
        boolean swap;
        int n = arr.length;
        for(int i =0 ; i < n-1 ; i++){
            swap = false;
            for (int j = 0 ; j < n- i -1; j++){
                if(arr[j] > arr[j+1]){
                    swap = true;
                    int temp  =  arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!swap){
                break;
            }
        }
        return arr;
    }

    //insertion sort
    static int[] insertionSort(int[] arr){
        int n = arr.length;

        for(int i = 0 ; i < n;  i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }
    // <======================= end of simple sort ========================>

    /* <================= Kadane's algorithm ========================>
        this algorithm is the optimal version of finding the maximum sum subarray
        time complexity : O(n)
        space complexity : O(1)
     */

    // Kadane's algorithm
    static int[] KadaneAlgorithm(int[] arr){
        int maxi = Integer.MIN_VALUE;
        int sum =0 , start = 0;
        int[] ans = new int[2];
        int n = arr.length;
        for(int i = 0; i<n; i++){
            if(sum ==0){
                start = i;
            }
            sum += arr[i];
            if(sum > maxi){
                maxi = sum;
                ans[0] = start;
                ans[1] = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        return ans;
    }
    // <================== end of Kadane's Algorithm ==============>

    /* <================ Array Rotation ==============>
        1. one left rotate
        2. Rotate array by D elements
     */

    // one left rotate
    static int[] oneLeftRotate(int[] arr){
        int n = arr.length;
        int temp = arr[0];
        for(int i = 1 ; i<n ; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        return arr;
    }

    // Rotate array by D elements
    static int[] rotateByDElements(int[] arr, int d){
        int n = arr.length;
        d = d%n;
        reverseForDElement(arr, 0, d-1);
        reverseForDElement(arr, d, n-1);
        reverseForDElement(arr, 0, n-1);
        return arr;
    }

    static int[] reverseForDElement(int[] arr , int i , int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
    // <================== end of array rotation =====================>



    /* Meeting room problem II
        The problem presents a scenario where we have an array of meeting time intervals, each represented by
        a pair of numbers [start_i, end_i]. These pairs indicate when a meeting starts and ends. The goal is to find the
        minimum number of conference rooms required to accommodate all these meetings without any overlap.
        In other words, we want to allocate space such that no two meetings occur in the same room simultaneously.
     */
    public int meetingRoom(int[][] intervals){
        int n = 100001;
        int[] delta = new int[n];
        for(int[] interval : intervals){
            delta[interval[0]]++;
            delta[interval[1]]--;
        }

        int res = delta[0];
        for(int i =1; i < n; i++){
            delta[i] = delta[i] + delta[i-1];
            res = Math.max(res, delta[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        // pointer MT1
        int[] arrMT1 = {2,7,8,10};
        int target = 9;
        System.out.println(targetSum(arrMT1, target));

        //pointer MT2
        int[] arrMT2 = {9,9,-1,-2,1,3,-1,2};
        int k = 4;
        System.out.println(maxSub(arrMT2, k));

        // sort MT 1
        int[] arrSMT1 = {5,4,3,2,1};
        System.out.println(Arrays.toString(selectionSort(arrSMT1)));

        // sort MT 2
        int[] arrSMT2 = {5,4,3,2,1};
        System.out.println(Arrays.toString(bubbleSort(arrSMT2)));

        //sort MT 3
        int[] arrSMT3 = {5,4,3,2,1};
        System.out.println(Arrays.toString(insertionSort(arrSMT3)));

        // Kadane's algorithm
        int[] arrKDN = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(Arrays.toString(KadaneAlgorithm(arrKDN)));

        //Rotation MT 1
        int[] arrRMT1 = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(oneLeftRotate(arrRMT1)));

        //Rotation MT 2
        int[] arrRMT2 = {1,2,3,4,5,6,7};
        int d = 9;
        System.out.println(Arrays.toString(rotateByDElements(arrRMT2, d)));
    }
}

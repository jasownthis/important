package sortingLevel2;

import java.util.Arrays;

public class Sorting_level_II {

    /* Sorting level II :
        1. Merge Sort
        2. Quick sort
        3. Inversion count
        4. Cycle sort (when the array nums are in range of 1 to n and continuous)
           Hint :
                1. range from 1 to n
                2. space O(1)
                3. time O(n)
     */

    // <============== Quick sort ==============>
    public static void Quick_sort(int[] nums, int low, int high){
        if(low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s)/2 ;
        int pivot = nums[m];
        while(s <= e){
            while(nums[s] < pivot){
                s++;
            }
            while(nums[e] > pivot){
                e--;
            }
            if(s <= e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        Quick_sort(nums, low, e);
        Quick_sort(nums, s, high);
    }
    // <========== End of Quick sort ===========>


    // <============== Merge sort ==============>
    public static void Merge_sort(int[] nums, int low, int high){
        if(high - low == 1) {
            return;
        }
        int mid = (low+high)/2;
        Merge_sort(nums, low, mid);
        Merge_sort(nums, mid, high);
        Merge(nums, low, mid , high);
    }
    public static void Merge(int[] nums, int l, int m , int h){
        int[] mix = new int[h - l];
        int k = 0;
        int i = l;
        int j = m;
        while(i<m && j<h){
            if(nums[i] <= nums[j]){
                mix[k] = nums[i];
                i++;
            }
            else{
                mix[k] = nums[j];
                j++;
            }
            k++;
        }

        while(i<m){
           mix[k] = nums[i];
           i++;
           k++;
        }
        while(j<h){
            mix[k] = nums[j];
            j++;
            k++;
        }
        for(int c = 0 ; c < mix.length ; c++){
            nums[l+c] = mix[c];
        }
    }
    // <========== End of Merge sort ===========>


    // <============== Inversion count ==========>
    public static int inversion_count(int[] nums, int low, int high){
        int count = 0;
        if(high - low == 1) {
            return count;
        }
        int mid = (low+high)/2;
        count+=inversion_count(nums, low, mid);
        count+=inversion_count(nums, mid, high);
        count+=counter(nums, low, mid , high);
        return count;
    }

    public static int counter(int[] nums, int l, int m , int h){
        int counter = 0;
        int[] mix = new int[h - l];
        int k = 0;
        int i = l;
        int j = m+1;
        while(i<m && j<h){
            if(nums[i] <= nums[j]){
                mix[k] = nums[i];
                i++;
            }
            else{
                mix[k] = nums[j];
                counter+= (m-l+1);
                j++;
            }
            k++;
        }

        while(i<m){
            mix[k] = nums[i];
            i++;
            k++;
        }
        while(j<h){
            mix[k] = nums[j];
            j++;
            k++;
        }

        return counter;
    }
    // <========== End of Inversion count ==========>


    // <============== Cycle sort ================>
    public static void Cycle_sort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] -1;
            if(arr[i] != arr[correct]){
                swap(arr, i , correct);
            }
            else{
                i++;
            }
        }
    }
    public static void swap(int[] arr, int s, int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
    // <========== End of Cycle sort =============>


    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
//        // <====== Quick sort ==========>
//        Quick_sort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//
//        // <====== Merge sort ===========>
//        Merge_sort(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));
//
//        // <====== Inversion count ======>
//        int count = inversion_count(arr, 0, arr.length);
//        System.out.println(count);

        //<========= Cycle sort ==========>
        Cycle_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}


/* Sorting level II interview and practice questions (cyclic sort)

    video link : https://www.youtube.com/watch?v=JfinxytTYFQ

    questions:
        1. Missing number : https://leetcode.com/problems/missing-number/description/
        2. Find all disappeared numbers from array : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
        3. Find the duplicate number : https://leetcode.com/problems/find-the-duplicate-number/description/
        4. Find all duplicate in array : https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
        5. Set Mismatch : https://leetcode.com/problems/set-mismatch/description/
        6. Find missing positive : https://leetcode.com/problems/first-missing-positive/description/
*/

class Trie {
    class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        public Node() {
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int level=0; level<prefix.length(); level++){
            int idx = prefix.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
}



















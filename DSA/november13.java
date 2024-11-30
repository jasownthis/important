import java.util.*;
public class november13 {

    /* k-th smallest number

    private static int kthSmallestElement(int[] nums, int k){
        int maximum = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            maximum = Math.max(maximum, nums[i]);
        }

        int[] frequency = new int[maximum+1];
        for(int i : nums){
            frequency[i]++;
        }

        int count = 0;
        for(int i = 0; i <= maximum; i++){
            if(frequency[i] != 0){
                count += frequency[i];
                if(count >= k){
                    return i;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        System.out.println(kthSmallestElement(arr,k));
    }
     */

    /* Minimize the height of tower
    private static int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = arr[n-1] - arr[0];
        int tempMin = arr[0];
        int tempMax = arr[n-1];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - k < 0) continue;

            tempMin = Math.min(arr[0]+k, arr[i]-k);
            tempMax = Math.max(arr[n-1]-k, arr[i-1]+k);
            res = Math.min(res , tempMax - tempMin);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,8,10};
        int k = 2;
        System.out.println(getMinDiff(arr,k));
    }
     */

//    private static int validParenthesis(String s){
//        Stack<Character> stack = new Stack<>();
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) == '(' ||
//               s.charAt(i) == '[') ||
//               s.charAt(i) == '{') {
//                stack.push(s.charAt(i));
//            }
//        }
//    }

    public static void convertToWave(int[] arr) {
        int n = arr.length;
        int i = 0, j = 1;
        while(n > 1){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            n-=2;
            i+=2;
            j+=2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        convertToWave(arr);
        System.out.println(Arrays.toString(arr));
    }
}

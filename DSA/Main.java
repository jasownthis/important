import java.util.*;

public class Main {

    /* anagram problem

    private static boolean anagramString(String s1, String s2){

        if(s1.length() != s2.length()) return false;
        int[] alpha = new int[26];

        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            int pos = c - 'a';
            alpha[pos]++;
        }

        for(int i = 0 ; i < s2.length(); i++){
            char c = s2.charAt(i);
            int pos = c - 'a';
            if(alpha[pos] == 0){
                return false;
            }
            else{
                alpha[pos]--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(anagramString("listen", "silent"));
        System.out.println(anagramString("listen", "silens"));
    }
    */


    /* finding row with maximum 1's

    private static int findRowMaxOne(int[][] matrix){
        int resultRow = 0;
        int row = 0;
        int col = matrix[0].length - 1;

        while( row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length){
            if(matrix[row][col] == 0){
                row++;
            }
            else{
                resultRow = row;
                col--;
            }
        }
        return resultRow + 1;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}};
        System.out.println(findRowMaxOne(matrix));
    }
     */


    /* longest consecutive subsequence

    private static int longestSubsequence(int[] arr){
        int res = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }

        for(int i = 0; i < arr.length; i++){
            if(!set.contains(arr[i]-1)){
                int j = arr[i];
                while(set.contains(j)) j++;

                if(res < j - arr[i]){
                    res = j - arr[i];
                }
            }
        }
        return res;
    }
    private static int longSubseqRep(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if (map.containsKey(i)) {
                int val = map.get(i);
                val++;
                map.put(i, val);
            } else {
                map.put(i, 1);
            }
        }

        int maxFreq = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i] - 1)){
                int j = nums[i];
                int freq = 0;
                while(map.containsKey(j)){
                    freq += map.get(j);
                    j++;
                }

                if(maxFreq < freq) maxFreq = freq;
            }
        }
        return maxFreq;
    }
    public static void main(String[] args) {
        System.out.println(longSubseqRep(new int[]{1,9,3,3,10,4,20,2}));
    }
    */


    /* longest palindromic substring

    private static int longPalString(String s){
        char[] c = s.toCharArray();
        int maximumLength = 1;

        for(int i = 0; i < c.length; i++){
            for(int j = 0; j <= 1; j++){

                int low = i;
                int high = i+j;
                while(low >= 0 && c.length > low && high >= 0 && high < c.length && c[low] == c[high]){
                    int curretLength = high - low + 1;
                    if(curretLength > maximumLength){
                        maximumLength = curretLength;
                    }
                    low--;
                    high++;
                }
            }
        }

        return maximumLength;
    }
    public static void main(String[] args) {
        System.out.println(longPalString("forgeeksskeegfor"));
    }
    */
}

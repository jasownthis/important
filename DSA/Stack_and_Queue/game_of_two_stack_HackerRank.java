package Stack_and_Queue;
import java.util.*;
// problem link  :  https://www.hackerrank.com/challenges/game-of-two-stacks/problem

public class game_of_two_stack_HackerRank {
    public static int twoStacks(int maxSum, int[] a, int[] b){
        return twoStack(maxSum, a,b,0,0) - 1;
    }

    private static int twoStack(int maxSum, int[] a, int[] b, int sum, int count){
        if(sum > maxSum){
            return count;
        }

        if(a.length == 0 || b.length == 0){
            return count;
        }

        int sum1 = twoStack(maxSum, Arrays.copyOfRange(a,1,a.length), b, sum+a[0] , count+1);
        int sum2 = twoStack(maxSum, a, Arrays.copyOfRange(b,1,b.length), sum+b[0] , count+1);
        return Math.max(sum1, sum2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        while(g != 0){
            int n = sc.nextInt();
            int m  = sc.nextInt();
            int maxSum = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0 ; i < n; i++){
                a[i] = sc.nextInt();
            }

            int[] b = new int[m];
            for(int j = 0 ; j < m; j++){
                b[j] = sc.nextInt();
            }

            System.out.println(twoStacks(maxSum, a , b));
            g--;
        }
    }
}


/* Stack and Queue interview questions:

    video link : https://youtu.be/S9LUYztYLu4?si=7jgFJsCOrQb6gXQm

    questions:
        1. Game of two stacks : https://www.hackerrank.com/challenges/game-of-two-stacks/problem
        2. Largest rectangle in histogram : https://leetcode.com/problems/largest-rectangle-in-histogram/description/
        3. Valid parentheses : https://leetcode.com/problems/valid-parentheses/description/
        4. Minimum add to make parenthesis valid : https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
        5. Minimum insertion to balance a parenthesis string : https://leetcode.com/problems/minimum-insertions-to-balance-a-parntheses-string/description/
 */
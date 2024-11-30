package Backtracking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int solution(String S, String T) {
        int N = S.length();
        List<Integer> positiveImpact = new ArrayList<>();
        List<Integer> negativeImpact = new ArrayList<>();
        int initialDifference = 0;

        for (int i = 0; i < N; i++) {
            int sDigit = S.charAt(i) - '0';
            int tDigit = T.charAt(i) - '0';
            int diff = Math.abs(sDigit - tDigit);
            initialDifference += diff;

            if (sDigit > tDigit) {
                positiveImpact.add(diff);
            } else if (sDigit < tDigit) {
                negativeImpact.add(diff);
            }
        }

        Collections.sort(positiveImpact, Collections.reverseOrder());
        Collections.sort(negativeImpact, Collections.reverseOrder());

        int swaps = 0;
        int currentDifference = initialDifference;

        while (swaps < N && !positiveImpact.isEmpty() && !negativeImpact.isEmpty()) {
            int maxPositive = positiveImpact.remove(0);
            int maxNegative = negativeImpact.remove(0);

            int potentialReduction = 2 * Math.min(maxPositive, maxNegative);
            currentDifference -= potentialReduction;
            swaps++;

            if (currentDifference <= 0) {
                break;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("29162", "10524")); // Output: 2
        System.out.println(solution.solution("12345", "54321")); // Output: 2
        System.out.println(solution.solution("10000", "99999")); // Output: 0
        System.out.println(solution.solution("11111", "11111")); // Output: 0
        System.out.println(solution.solution("987654", "123456")); // Output: 1
    }
}


package TCSCODVITA;
import java.util.*;

//public class DanceRev{
//    public static int minimumMovesInTiles(List<String> instructions){
//        int n = instructions.size();
//        String[] tiles = {"left", "right", "down", "up"};
//        Map<String, Integer> dp  = new HashMap<>();
//
//        class MemoizeDP{
//            int helper(String left , String right, int processSteps){
//                if(processSteps == n) return 0;
//
//                String key = left + "," + right + "," + processSteps;
//                if(dp.containsKey(key)){
//                    return dp.get(key);
//                }
//
//                String targetKey = instructions.get(processSteps);
//                int moveLeft = (left.equals(targetKey) ? 0 : 1) + helper(targetKey, right , processSteps+1);
//                int moveRight = (right.equals(targetKey) ? 0 : 1) + helper(left , targetKey, processSteps+1);
//                int result = Math.min(moveLeft, moveLeft);
//                dp.put(key, result);
//                return result;
//            }
//        }
//
//        MemoizeDP mzd = new MemoizeDP();
//        int result = Integer.MAX_VALUE;
//        for(String startLeft : tiles){
//            for(String startRight: tiles){
//                result = Math.min(result, mzd.helper(startLeft,startRight,0));
//            }
//        }
//
//        return result;
//    }
//
//
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter n value : ");
//        int N = Integer.parseInt(s.nextLine().trim());
//        System.out.println("enter array instrutions : ");
//        List<String> instructions = new ArrayList<>();
//        for(int i = 0;  i < N ; i++){
//            instructions.add(s.nextLine().trim());
//        }
//        s.close();
//
//        int result = minimumMovesInTiles(instructions);
//        System.out.println(result);
//    }
//}
import java.util.*;

public class DanceRev {
    private static final String[] TILES = {"up", "down", "left", "right"};
    private static List<String> instructions;
    private static int n;
    private static Map<String, Integer> memoizationMap = new HashMap<>();

    private static int calculateMoves(String left, String right, int step) {
        if (step == n) {
            return 0;
        }

        String key = left + "|" + right + "|" + step;
        if (memoizationMap.containsKey(key)) {
            return memoizationMap.get(key);
        }

        String target = instructions.get(step);
        int leftMoveCost = (left.equals(target) ? 0 : 1) + calculateMoves(target, right, step + 1);
        int rightMoveCost = (right.equals(target) ? 0 : 1) + calculateMoves(left, target, step + 1);
        int result = Math.min(leftMoveCost, rightMoveCost);
        memoizationMap.put(key, result);
        return result;
    }

    public static int findMinimumMoves(List<String> inputInstructions) {
        instructions = inputInstructions;
        n = instructions.size();
        memoizationMap.clear();

        int minimumMoves = Integer.MAX_VALUE;
        for (String leftStart : TILES) {
            for (String rightStart : TILES) {
                minimumMoves = Math.min(minimumMoves, calculateMoves(leftStart, rightStart, 0));
            }
        }
        return minimumMoves;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numInstructions = Integer.parseInt(scanner.nextLine().trim());
        List<String> inputInstructions = new ArrayList<>();
        for (int i = 0; i < numInstructions; i++) {
            inputInstructions.add(scanner.nextLine().trim());
        }

        int result = findMinimumMoves(inputInstructions);
        System.out.println(result);
        scanner.close();
    }
}
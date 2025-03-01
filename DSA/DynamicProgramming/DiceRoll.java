package DynamicProgramming;
import java.util.*;

public class DiceRoll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = 1, b = 1;
        for(int i = 2; i <= n; i++){
            int c = a+b;
            a = b;
            b = c;
        }

        if(0 < n && n <= 6) System.out.println(b+1);
        else System.out.println(b);
    }
}

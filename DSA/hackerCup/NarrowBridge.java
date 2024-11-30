package hackerCup;

import java.util.*;
public class NarrowBridge {
    private String isPossible(int num){
        if(num % 2 == 0 && num > 2) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        String num = "24123";
        int even = 0;
        int odd = 0;
        for(int i = 0; i < num.length() ; i++){
            if(i%2 == 0) even += num.charAt(i) + '0';
            else odd += num.charAt(i) + '0';
        }
        System.out.println(even == odd);
    }
}


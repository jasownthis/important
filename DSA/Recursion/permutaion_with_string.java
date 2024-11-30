package Recursion;
import java.util.*;
public class permutaion_with_string {
    public static void main(String[] args) {
//        permutations("", "abc");
//        System.out.println(pad("" , "23"));
        dicePermutation("", 4);
    }

    static void permutations(String p , String s){
        if(s.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = s.charAt(0);
        for(int i =0 ; i <= p.length(); i++){
            String f = p.substring(0, i);
            String sec = p.substring(i, p.length());
            permutations(f+ch+sec, s.substring(1));
        }
    }

    // phone pad : Google problem
    static List<String> pad(String p , String s){
        if(s.isEmpty()){
            List<String> list =  new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans =  new ArrayList<>();
        int digit = s.charAt(0) - '0';
        for(int i = (digit - 1) * 3 ; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            ans.addAll(pad(p+ch , s.substring(1)));
        }
        return ans;
    }

    // dice permuation
    static void dicePermutation(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i = 1 ; i <= 6 && i <= target; i++){
            dicePermutation(p+i, target-i);
        }

    }
}





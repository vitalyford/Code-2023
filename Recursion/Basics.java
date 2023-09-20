package Recursion;

import java.util.*;

public class Basics {
    public static long factorial(long n) { // 5! = 1 * 2 * 3 * 4 * 5 = 4! * 5
        return (n == 0) ? 1 : factorial(n - 1) * n;
    } // ternary operator


    // if (message.length() <= 1) {
    //     return message;
    // }
    // char last = message.charAt(message.length() - 1);
    // String leftover = message.substring(0, message.length() - 1);
    
    // return last + backwardString(leftover);

    
    public static String backwardString(String message) {
        return (message.length() <= 1) ? message : backwardString(message.substring(1)) + (message.charAt(0));
    }


    public static int rabbits(int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n < 3 ) {
            return 1;
        }
        int value = rabbits(n - 1, memo) + rabbits(n - 2, memo);
        memo.put(n, value);
        System.out.println("For " + n + " it's " + value);
        return value;
    }



    public static void main(String[] args) {
        // System.out.println(factorial(20));
        // System.out.println(backwardString("A Santa lived as a devil at NASA"));
        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println(rabbits(10, memo));
    }
}

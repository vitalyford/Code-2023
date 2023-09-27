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


    public static int paradeCount(int n) {
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 3;
        }
        return paradeCount(n - 1) + paradeCount(n - 2);
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
        hanoi(20, "A", "C", "B");
        // System.out.println(factorial(20));
        // System.out.println(backwardString("A Santa lived as a devil at NASA"));
        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println(rabbits(10, memo));
        // Create an array with 100 integers that are all random and then sort the array in increasing order
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomNum = rand.nextInt(1000);
            arr[i] = randomNum;
        }
        Arrays.sort(arr);

        int target = 500;
        // Create a method that takes in the target and the array
        // and returns the index of the target in the array
        // or -1 if the target is not found in the array
        int index = searchArray(arr, target);
        System.out.println("The index of " + target + " is " + index);
    }

    private static int search(int[] arr, int target, int lower, int upper) {
        if (lower > upper) {
            return -1;
        }
        int mid = (lower + upper) / 2; // index
        int val = arr[mid];

        if (target == val) {
            return mid;
        }
        else if (target < val) { // going to the left side
            return search(arr, target, lower, mid - 1);
        }
        else { // going to the right side
            return search(arr, target, mid + 1, upper);
        }
    }


    public static void hanoi(int n, String src, String dst, String spare) {
        if (n == 1) {
            System.out.println("Move a disk from " + src + " to " + dst);
            return;
        }
        // Move n-1 disks from src to the spare
        hanoi(n - 1, src, spare, dst);
        // Move 1 disk from src to the dst
        hanoi(1, src, dst, spare);
        // Move n-1 disks from spare to the dst
        hanoi(n - 1, spare, dst, src);
    }


    public static int searchArray(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }
}

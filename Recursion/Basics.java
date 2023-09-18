package Recursion;

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

    public static void main(String[] args) {
        // System.out.println(factorial(20));
        System.out.println(backwardString("A Santa lived as a devil at NASA"));
    }
}

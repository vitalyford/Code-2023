import java.util.*;

public class MergeSort {
    private static void mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1); // inclusively
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

import java.util.*;

public class MergeSort {
    private static void somehowPutThemTogether(int[] arr, int start, int mid, int end) {
        // Merging two array ranges
        int[] temp = new int[end - start + 1];
        // Merging:
        // 1. create indicies to track the left, the right, and ugly - temp
        int left = start, right = mid + 1, t = 0;
        // 2. loop through until either left or right reach the ends
        //    of respective array ranges
        while (left != mid + 1 && right != end + 1) {
            // temp[t++] = (arr[left] <= arr[right]) ? arr[left++] : arr[right++];
            if (arr[left] <= arr[right]) {
                temp[t++] = arr[left++];
            }
            else {
                temp[t++] = arr[right++];
            }
        }

        // 3. add the rest from the left or right ranges
        //    if any of them have leftovers
        while (left != mid + 1) {
            temp[t++] = arr[left++];
        }
        while (right != end + 1) {
            temp[t++] = arr[right++];
        }
        
        // 4. move the temp into the actual array but
        //    remember that the temp is ONLY a part of that array
        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }


    private static void mergeSort(int[] arr, int start, int end) {
        if (start != end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            somehowPutThemTogether(arr, start, mid, end);
        }
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1); // inclusively
    }

    public static void main(String[] args) {
        int[] arr = { -5, 1, 4, 3, -2, 1, 1 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

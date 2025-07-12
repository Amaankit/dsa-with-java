package recursion;

import java.util.Arrays;

public class SubsetSumII {

    public static void main(String[] args) {
        // 👦 These are the numbers we want to sort from smallest to biggest
        // 🧑‍💻 Unsorted input array
        int[] ar4 = new int[]{4, 3, 53, 5};

        // 👦 Let's sort them using merge sort!
        // 🧑‍💻 Start merge sort with full range: 0 to array.length - 1
        mergeSort(0, ar4.length - 1, ar4);

        // 👦 Now print out the sorted list!
        // 🧑‍💻 Display the sorted array
        System.out.println(Arrays.toString(ar4));
    }

    /**
     * 👦 This helps put two halves together in the right order!
     * 🧑‍💻 Merges two sorted subarrays: array[low...mid] and array[mid+1...high]
     */
    private static void merge(int low, int mid, int high, int[] array) {
        // 👦 This is where we'll store our sorted numbers
        // 🧑‍💻 Temporary array to store merged result
        int[] result = new int[high - low + 1];
        int i = 0;
        int left = low;
        int right = mid + 1;

        // 👦 While both sides still have numbers, keep picking the smallest one
        // 🧑‍💻 Compare elements from both halves and build the result array
        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                result[i++] = array[left++];
            } else {
                result[i++] = array[right++];
            }
        }

        // 👦 If left side has leftover numbers, add them
        // 🧑‍💻 Copy remaining elements from left subarray
        while (left <= mid) {
            result[i++] = array[left++];
        }

        // 👦 If right side has leftover numbers, add them too
        // 🧑‍💻 Copy remaining elements from right subarray
        while (right <= high) {
            result[i++] = array[right++];
        }

        // 👦 Put everything back into the original list
        // 🧑‍💻 Copy merged result back into original array from position `low`
        for (int j = 0; j < result.length; j++) {
            array[low + j] = result[j];
        }
    }

    /**
     * 👦 This function keeps dividing the list into smaller parts to sort them
     * 🧑‍💻 Recursively splits the array, then merges the sorted halves
     */
    private static void mergeSort(int low, int high, int[] array) {
        // 👦 If there's only one number left, nothing to sort!
        // 🧑‍💻 Base case: a single element (or invalid range) is already sorted
        if (low >= high) {
            return;
        }

        // 👦 Find the middle point to cut the list in two
        // 🧑‍💻 Find the midpoint to divide the array into two halves
        int mid = (low + high) / 2;

        // 👦 Sort the left part
        // 🧑‍💻 Recursively sort the left half
        mergeSort(low, mid, array);

        // 👦 Sort the right part
        // 🧑‍💻 Recursively sort the right half
        mergeSort(mid + 1, high, array);

        // 👦 Now combine the two parts into one sorted part
        // 🧑‍💻 Merge the sorted halves
        merge(low, mid, high, array);
    }
}

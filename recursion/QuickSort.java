package recursion;

import java.util.Arrays;

public class QuickSort {

    // 👦 These are the numbers we want to sort from smallest to biggest
    // 🧑‍💻 Unsorted input array to be sorted using Quick Sort algorithm
    static int[] ar4 = new int[]{4, 3, 53, 5};

    public static void main(String[] args) {
        // 👦 Let's sort the numbers!
        // 🧑‍💻 Call quickSort on the full array: indices 0 to length - 1
        quickSort(ar4, 0, ar4.length - 1);

        // 👦 Now show the sorted list
        // 🧑‍💻 Print the final sorted array
        System.out.println(Arrays.toString(ar4));
    }

    /**
     * 👦 This helps us split the list into smaller parts around a special number (pivot)
     * 🧑‍💻 Partitions the array using Lomuto-style partitioning:
     *      - Picks pivot
     *      - Moves smaller values left of pivot, larger to the right
     *      - Returns final pivot position
     */
    private static int partition(int low, int high) {
        int pivot = ar4[low]; // 👦 Choose the first number as a pivot
        // 🧑‍💻 Pivot value to compare others against

        int i = low;
        int j = high;

        // 👦 Move i from the left and j from the right until they cross
        // 🧑‍💻 Repeatedly find values on wrong sides and swap them
        while (i < j) {
            // 👦 Keep moving i to the right while numbers are smaller than or equal to pivot
            // 🧑‍💻 Find first number greater than pivot from the left
            while (i <= high && ar4[i] <= pivot) i++;

            // 👦 Move j to the left while numbers are bigger than pivot
            // 🧑‍💻 Find first number less than or equal to pivot from the right
            while (j >= low && ar4[j] > pivot) j--;

            // 👦 If i and j haven't crossed, swap them
            // 🧑‍💻 Swap out-of-place elements
            if (i < j) {
                swap(i, j);
            }
        }

        // 👦 Put the pivot in the right place
        // 🧑‍💻 Swap pivot with element at j — its correct final position
        swap(low, j);
        return j;
    }

    /**
     * 👦 This function keeps breaking the list into halves and sorts each half
     * 🧑‍💻 Recursive quick sort method that:
     *      - Finds pivot
     *      - Recursively sorts left and right partitions
     */
    private static void quickSort(int[] array, int low, int high) {
        // 👦 If the part is small enough, no need to sort
        // 🧑‍💻 Base case: do nothing if low >= high
        if (low < high) {
            // 👦 Find where to split the list
            // 🧑‍💻 Partition the array and get pivot index
            int pivotIndex = partition(low, high);

            // 👦 Sort the part before pivot
            // 🧑‍💻 Recursively sort left half
            quickSort(array, low, pivotIndex - 1);

            // 👦 Sort the part after pivot
            // 🧑‍💻 Recursively sort right half
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * 👦 Swap two numbers in the list
     * 🧑‍💻 Swaps values at index i and j in array `ar4`
     */
    private static void swap(int i, int j) {
        int temp = ar4[i];
        ar4[i] = ar4[j];
        ar4[j] = temp;
    }
}

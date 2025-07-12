package slidingWindowAndTwoPointers;

public class MaxKConsecutiveElementSum {

    // This program calculates the maximum sum of `n` consecutive elements
    // Find N Cards with Maximum Sum it should be consecutive

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 3;
        System.out.println(getMaxSum(arr, n));
    }

    public static int getMaxSum(int[] arr, int n) {
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        // Calculate the sum of first `n` elements from the start (left side)
        for (int i = 0; i < n; i++) {
            leftSum += arr[i];
        }

        // Initially, maxSum is sum of all n elements from the left
        maxSum = leftSum + rightSum;

        // BE CAREFUL: The right index is not the last index of the array, but the last index of the array minus n
        int rightIndex = arr.length - 1;

        for (int i = 0; i < n; i++) {
            // BE CAREFUL: The right index is not the last index of the array, but the last index of the array minus n
            leftSum -= arr[n - i - 1];        // Remove one element from the left sum
            rightSum += arr[rightIndex - i];  // Add one element from the right
            maxSum = Math.max(maxSum, leftSum + rightSum); // Track the maximum sum
        }

        return maxSum;
    }
}

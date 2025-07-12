package slidingWindowAndTwoPointers;

public class MaxConsecutiveOnesWithKZeros {
    public static void main(String[] args) {
        // We have an array of 1s and 0s
        int[] arr = {1, 0, 1, 1, 0, 1};

        // We are allowed to change up to 'k' zeros into ones
        int k = 2;

        // Just printing something random
        System.out.println("fd");

        // Find the longest group of 1s if we can flip at most 2 zeros
        System.out.println(maxConsecutiveOnes(arr, k));
    }

    static int maxConsecutiveOnes(int[] arr, int k) {
        int maxLength = 0;    // This will hold the longest streak of 1s we can find
        int leftIndex = 0;    // Start of our window (like the beginning of a highlighter)
        int rightIndex = 0;   // End of our window (like the end of a highlighter)
        int n = arr.length;   // Total number of elements in the array
        int noOfZeros = 0;    // How many zeros we have inside the current window

        // Move the right side of our highlighter window across the array
        while (rightIndex < n) {

            // If the current number is 0, we count it
            if (arr[rightIndex] == 0) {
                noOfZeros++;
            }

            // If the number of zeros is more than allowed (more than k)
            // we need to shrink the window from the left side
            if (noOfZeros > k) {
                // If the number we're removing from the left was a zero, reduce the zero count
                if (arr[leftIndex] == 0) {
                    noOfZeros--;
                }

                // Move the left side of the window to the right
                leftIndex++;
            } else {
                // If we are still within the allowed number of zeros,
                // calculate how big our window is and update the maxLength if it's bigger
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            }

            // Move the right side of the window to the right
            rightIndex++;
        }

        // Return the longest stretch of 1s we found (with at most k zero flips)
        return maxLength;
    }
}
/*
Imagine you have a row of coins, some are heads (1) and some are tails (0).
You're allowed to flip up to k tails into heads.
You want to find the longest stretch of heads you can get if you're allowed to flip a few tails.
We use a window (like a highlighter) to keep track of the current stretch.
If we see too many tails, we move the start of our highlighter until we're back to the allowed number.
* */
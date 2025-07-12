package dp;

import java.util.Arrays;

/**
 * 💡 Problem: Maximum Sum of Non-Adjacent Elements
 *
 * Given an array of integers, find the maximum sum of elements such that
 * no two selected elements are adjacent in the array.
 *
 * ✅ You can either:
 * - Include the current element and skip the previous one
 * - Or skip the current element and carry forward the previous max
 *
 * 🧠 Example:
 * Input: [2, 6, 6]
 * Output: 8 (2 + 6 from index 0 and 2)
 *
 * 🔧 Approaches:
 * 1. Recursion (Brute force) – explore all choices
 * 2. Top-down DP (Memoization) – cache previous results
 * 3. Bottom-up DP (Tabulation) – build result iteratively
 */

public class MaximumSumOfNonAdjacentElements {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 6};

        int recursive = maxSum(nums);
        System.out.println("Recursive: " + recursive);

        int memoized = maxSumDP(nums);
        System.out.println("DP (Memoization): " + memoized);

        int tabulated = maxSumTabulation(nums);
        System.out.println("Tabulation: " + tabulated);
    }

    // 🔁 Recursive Solution (Brute force)
    // Time Complexity: O(2^n)
    // Space Complexity: O(n) recursion depth
    public static int solution(int[] nums, int n) {
        if (n < 0) return 0;         // Base case: no elements left
        if (n == 0) return nums[0];  // Only one element to take

        // Include current number and skip one before it
        int include = solution(nums, n - 2) + nums[n];

        // Exclude current number
        int exclude = solution(nums, n - 1);

        // Return max of both choices
        return Math.max(include, exclude);
    }

    public static int maxSum(int[] nums) {
        return solution(nums, nums.length - 1);
    }

    // 🧠 Memoization (Top-down DP)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int solutionDP(int[] nums, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];

        if (dp[n] != Integer.MIN_VALUE) return dp[n]; // Use memoized result

        int include = solutionDP(nums, n - 2, dp) + nums[n];
        int exclude = solutionDP(nums, n - 1, dp);

        dp[n] = Math.max(include, exclude);  // Store result
        return dp[n];
    }

    public static int maxSumDP(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return solutionDP(nums, nums.length - 1, dp);
    }

    // 📊 Tabulation (Bottom-up DP)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int solutionTabulation(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];                // Max for 0th index is nums[0]
        dp[1] = Math.max(nums[0], nums[1]); // Max of either nums[0] or nums[1]

        // Fill dp array iteratively
        for (int i = 2; i < n; i++) {
            int include = dp[i - 2] + nums[i];  // Include current
            int exclude = dp[i - 1];            // Exclude current
            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1]; // Max sum considering all elements
    }

    public static int maxSumTabulation(int[] nums) {
        return solutionTabulation(nums);
    }
}

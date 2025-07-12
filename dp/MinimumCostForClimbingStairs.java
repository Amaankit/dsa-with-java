package dp;

import java.util.Arrays;

/**
 * 🔢 Problem: Minimum Cost to Climb Stairs
 *
 * You are given an array `cost` where `cost[i]` is the cost of the i-th step.
 * You can start from either step 0 or step 1.
 * Each time you can either climb one or two steps.
 * The goal is to reach the top (i.e., one step beyond the last index) with minimum total cost.
 *
 * 🧠 Approaches:
 * 1. Recursive (no memoization) – simple, but slow (exponential time)
 * 2. Top-down DP (memoization) – stores subproblem results for reuse
 * 3. Bottom-up DP (tabulation) – builds from smallest subproblems to final answer
 * 4. Space optimized – uses two variables instead of an array (O(1) space)
 */

public class MinimumCostForClimbingStairs {

    public static void main(String[] args) {
        int[] cost = new int[]{15, 23, 44};

        int totalCostRecursive = minCostClimbingStairs(cost);
        System.out.println("Recursive: " + totalCostRecursive);

        int totalCostDP = minCostClimbingStairsDP(cost);
        System.out.println("DP (Memoization): " + totalCostDP);

        int totalCostTabulation = minCostClimbingStairsTabulation(cost);
        System.out.println("DP (Tabulation): " + totalCostTabulation);

        int totalCostSpaceOptimized = solutionSpaceOptimization(cost, cost.length);
        System.out.println("DP (Space Optimized): " + totalCostSpaceOptimized);
    }

    // Recursive solution (no memoization)
    // Time Complexity: O(2^n) because it branches into two recursive calls for each step
    // Space Complexity: O(n) due to the recursion call stack depth
    public static int solution(int[] cost, int index, int n) {
        // If reached or passed the top, no more cost needed
        if (index >= n) return 0;

        // Try stepping one step forward recursively
        int oneStep = solution(cost, index + 1, n);

        // Try stepping two steps forward recursively
        int twoStep = solution(cost, index + 2, n);

        // Return current step cost + minimum cost from next possible steps
        return cost[index] + Math.min(oneStep, twoStep);
    }

    // Entry for recursive approach, choosing starting step 0 or 1
    public static int minCostClimbingStairs(int[] cost) {
        // Pick minimum cost between starting at step 0 or step 1
        return Math.min(solution(cost, 0, cost.length), solution(cost, 1, cost.length));
    }

    // Top-down DP with memoization
    // Time Complexity: O(n), each subproblem computed once
    // Space Complexity: O(n) for dp array + O(n) recursion stack
    public static int minCostClimbingStairsDP(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        Arrays.fill(dp, -1);  // -1 means value not computed yet

        // Return minimum starting from step 0 or 1 using memoized recursion
        return Math.min(solutionDP(cost, 0, length, dp), solutionDP(cost, 1, length, dp));
    }

    public static int solutionDP(int[] cost, int index, int n, int[] dp) {
        // Base case: reached or passed the top
        if (index >= n) return 0;

        // If result already computed, return it to avoid recomputation
        if (dp[index] != -1) return dp[index];

        // Recursively compute cost stepping one step
        int oneStep = solutionDP(cost, index + 1, n, dp);

        // Recursively compute cost stepping two steps
        int twoStep = solutionDP(cost, index + 2, n, dp);

        // Store minimum cost from current step + its cost
        dp[index] = cost[index] + Math.min(oneStep, twoStep);

        // Return the computed value
        return dp[index];
    }

    // Bottom-up DP (Tabulation)
    // Time Complexity: O(n) — single pass loop through steps
    // Space Complexity: O(n) — dp array stores results for each step
    public static int minCostClimbingStairsTabulation(int[] cost) {
        return solutionTabulation(cost, cost.length);
    }

    public static int solutionTabulation(int[] cost, int n) {
        int[] dp = new int[n + 1];  // dp[i] = min cost to reach top from step i

        // Cost to stand on step 0 (starting point)
        dp[0] = cost[0];

        // Cost to stand on step 1 (starting point)
        dp[1] = cost[1];

        // Calculate min cost for every step from 2 to n-1
        for (int i = 2; i < n; i++) {
            // Current step cost + min cost from the two previous steps
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // You can start at step 0 or step 1, so return min of those two paths
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // Space optimized bottom-up DP
    // Time Complexity: O(n) — single pass loop
    // Space Complexity: O(1) — only a few variables used
    public static int solutionSpaceOptimization(int[] cost, int n) {
        // Initialize costs for first two steps
        int prev1 = cost[1]; // Cost to stand on step 1
        int prev2 = cost[0]; // Cost to stand on step 0
        int curr = 0;

        // Loop through steps starting from step 2
        for (int i = 2; i < n; i++) {
            // Current cost = cost[i] + min cost of previous two steps
            curr = cost[i] + Math.min(prev1, prev2);

            // Update prev2 and prev1 for next iteration
            prev2 = prev1;
            prev1 = curr;
        }

        // Minimum cost could be from either of the last two steps
        return Math.min(prev1, prev2);
    }
}

package dp;

import java.util.Arrays;

/**
 * 💰 Problem: Coin Change
 *
 * Given an array `coins[]` of distinct denominations and an integer `amount`,
 * return the minimum number of coins needed to make up that amount.
 * If it is not possible, return -1.
 *
 * You may use an unlimited number of each coin.
 *
 * 🧠 Example:
 * Input: coins = [2, 6, 6], amount = 16
 * Output: 4
 * Explanation: 6+6+2+2 = 16 → uses 4 coins.
 *
 * 🚀 Approaches:
 * 1. Recursion (Brute Force) – Try all combinations (slow for large inputs)
 * 2. Memoization (Top-down DP) – Cache subproblem results
 * 3. Tabulation (Bottom-up DP) – Build the solution iteratively
 */

public class CoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = new int[]{2, 6, 6};
        int amount = 16;

        int totalCostRecursive = minCoin(coins, amount);
        System.out.println("Recursive: " + totalCostRecursive);

        int totalCostDP = minCoinDP(coins, amount);
        System.out.println("DP (Memoization): " + totalCostDP);

        int totalCostTab = minCoinTabulation(coins, amount);
        System.out.println("Tabulation: " + totalCostTab);
    }

    // 🔁 Recursive approach (Brute force)
    // Time Complexity: O(2^amount) — tries all combinations
    // Space Complexity: O(amount) — recursion stack
    public static int solution(int[] coins, int target, int length) {
        // Base case: no amount left
        if (target == 0) return 0;

        // Base case: negative target → no solution
        if (target < 0) return Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;

        // Try each coin
        for (int i = 0; i < length; i++) {
            int subAns = solution(coins, target - coins[i], length);
            if (subAns != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + subAns); // count current coin
            }
        }

        return ans;
    }

    public static int minCoin(int[] coins, int amount) {
        int ans = solution(coins, amount, coins.length);
        return (ans != Integer.MAX_VALUE) ? ans : -1;
    }

    // 🧠 DP with Memoization (Top-down)
    // Time Complexity: O(amount * n) — each sub-amount computed once
    // Space Complexity: O(amount) — for memoization array + stack
    public static int solutionDP(int[] coins, int target, int length, int[] dp) {
        if (target == 0) return 0;
        if (target < 0) return Integer.MAX_VALUE;

        if (dp[target] != -1) return dp[target]; // already computed

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            int subAns = solutionDP(coins, target - coins[i], length, dp);
            if (subAns != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + subAns);
            }
        }

        dp[target] = ans;  // save answer
        return dp[target];
    }

    public static int minCoinDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = solutionDP(coins, amount, coins.length, dp);
        return (ans != Integer.MAX_VALUE) ? ans : -1;
    }

    // 📊 DP with Tabulation (Bottom-up)
    // Time Complexity: O(amount * n)
    // Space Complexity: O(amount)
    public static int solutionTabulation(int[] coins, int target) {
        int[] dp = new int[target + 1];

        // Fill dp[] with MAX initially
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base: 0 amount needs 0 coins

        // Build up the solution for every amount
        for (int i = 0; i <= target; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return (dp[target] != Integer.MAX_VALUE) ? dp[target] : -1;
    }

    public static int minCoinTabulation(int[] coins, int amount) {
        int ans = solutionTabulation(coins, amount);
        return (ans != Integer.MAX_VALUE) ? ans : -1;
    }
}

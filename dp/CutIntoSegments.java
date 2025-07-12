package dp;

import java.util.Arrays;

public class CutIntoSegments {

    public static void main(String[] args) {
        // Try to cut a rod of length 15 using segments of length 2, 6, and 6
        int[] coins = new int[]{2, 6, 6}; // segment sizes
        int amount = 16;

        // Recursive approach (no memoization)
        int recursive = maxSegments(15, coins[0], coins[1], coins[2]);
        System.out.println("Recursive: " + recursive);

        // Top-down DP with memoization
        int dp = maxSegmentsDP(15, coins[0], coins[1], coins[2]);
        System.out.println("DP (Memoization): " + dp);

        // Bottom-up DP (tabulation)
        int tab = maxSegmentsTabulation(15, coins[0], coins[1], coins[2]);
        System.out.println("Tabulation: " + tab);
    }

    // ------------------ Recursive Solution ------------------

    /**
     * Recursive function to find the max number of segments.
     * Base cases:
     * - If rod length is 0, return 0 (no more cuts needed)
     * - If rod length is negative, return MIN_VALUE (invalid)
     * Recursive step:
     * - Try all 3 segment cuts and pick the one giving max cuts
     */
    public static int solution(int n, int x, int y, int z) {
        if (n == 0) return 0; // no more rod left to cut → 0 cuts needed
        if (n < 0) return Integer.MIN_VALUE; // invalid → can't cut

        // Try cutting x, y, or z and pick the one with max result
        int takeX = solution(n - x, x, y, z);
        int takeY = solution(n - y, x, y, z);
        int takeZ = solution(n - z, x, y, z);

        return 1 + Math.max(takeX, Math.max(takeY, takeZ));
    }

    public static int maxSegments(int n, int x, int y, int z) {
        int ans = solution(n, x, y, z);
        return ans < 0 ? 0 : ans;
    }

    // Time Complexity: Exponential (O(3^n))
    // Space Complexity: O(n) (recursive call stack)

    // ------------------ DP with Memoization ------------------

    /**
     * Memoized (Top-Down DP) version of the problem
     * We store the solution for every 'n' to avoid recalculating it
     */
    public static int solutionDP(int n, int x, int y, int z, int[] dp) {
        if (n == 0) return 0;
        if (n < 0) return Integer.MIN_VALUE;
        if (dp[n] != -1) return dp[n]; // use cached result

        int takeX = solutionDP(n - x, x, y, z, dp);
        int takeY = solutionDP(n - y, x, y, z, dp);
        int takeZ = solutionDP(n - z, x, y, z, dp);

        dp[n] = 1 + Math.max(takeX, Math.max(takeY, takeZ)); // store result
        return dp[n];
    }

    public static int maxSegmentsDP(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); // mark all as uncomputed
        int ans = solutionDP(n, x, y, z, dp);
        return ans < 0 ? 0 : ans;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n) for the dp[] array + O(n) stack (recursive)

    // ------------------ Tabulation (Bottom-Up) ------------------

    /**
     * Tabulation approach (Bottom-Up DP)
     * Build the solution from 0 up to n using a dp array
     */
    public static int solutionTabulation(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE); // impossible values
        dp[0] = 0; // base case: 0 length rod → 0 cuts

        // Loop from 1 to n to fill the dp table
        for (int i = 1; i <= n; i++) {
            if (i - x >= 0 && dp[i - x] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], 1 + dp[i - x]);
            }
            if (i - y >= 0 && dp[i - y] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], 1 + dp[i - y]);
            }
            if (i - z >= 0 && dp[i - z] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], 1 + dp[i - z]);
            }
        }

        return dp[n] == Integer.MIN_VALUE ? -1 : dp[n];
    }

    public static int maxSegmentsTabulation(int n, int x, int y, int z) {
        int ans = solutionTabulation(n, x, y, z);
        return ans < 0 ? 0 : ans;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n) for the dp[] array
}

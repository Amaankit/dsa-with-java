package dp; // Package name

// formula will be f(n) = ((k-1)* f(n-2)) + ((k-1) * f(n-1))
// base case if n=1,retrun 1, if n=2, return k + k*(k-1)

public class PentingFenceAlgorithm {

    public static void main(String[] args) {
        int n = 5; // Total number of fences
        int k = 3; // Total number of available colors

        // Using plain recursion
        int recursive = minWaysRecursive(n, k);
        System.out.println("Recursive: " + recursive);

        // Using memoization (top-down dynamic programming)
        int dp = minWaysDP(n, k);
        System.out.println("DP (Memoization): " + dp);

        // Using tabulation (bottom-up dynamic programming)
        int tab = minWaysTabulation(n, k);
        System.out.println("Tabulation: " + tab);
    }

    /**
     * Recursive approach (Exponential time)
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) - due to call stack
     */
    public static int minWaysRecursive(int n, int k) {
        // Base case: 1 fence, k ways to paint
        if (n == 1) return k;

        // Base case: 2 fences, k ways for first, and k choices for second
        // (including same and different color)
        if (n == 2) return k * k;

        // Recursive formula: (k - 1) * (f(n-1) + f(n-2))
        return (k - 1) * (minWaysRecursive(n - 1, k) + minWaysRecursive(n - 2, k));
    }

    /**
     * Memoization (Top-down DP)
     * Stores previously computed results to avoid recomputation
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int minWaysDP(int n, int k) {
        int[] dp = new int[n + 1]; // Array to store results
        for (int i = 0; i <= n; i++) dp[i] = -1; // Initialize all as uncomputed
        return solutionDP(n, k, dp);
    }

    public static int solutionDP(int n, int k, int[] dp) {
        if (n == 1) return k;
        if (n == 2) return k * k;

        // If already computed, return stored result
        if (dp[n] != -1) return dp[n];

        // Compute using the same recursive formula
        dp[n] = (k - 1) * (solutionDP(n - 1, k, dp) + solutionDP(n - 2, k, dp));
        return dp[n];
    }

    /**
     * Tabulation (Bottom-up DP)
     * Iteratively builds up the solution from base cases
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int minWaysTabulation(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;

        int[] dp = new int[n + 1]; // dp[i] = ways to paint i fences

        dp[1] = k;       // Base case: 1 fence
        dp[2] = k * k;   // Base case: 2 fences

        // Fill the table from 3 to n
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]); // Transition formula
        }

        return dp[n]; // Final result
    }
}

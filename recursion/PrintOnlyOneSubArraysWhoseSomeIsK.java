package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintOnlyOneSubArraysWhoseSomeIsK {

    // 👦 These are the numbers we're playing with.
    // 🧑‍💻 Input array to generate all possible subsequences (inclusion/exclusion style).
    static int[] nums = new int[]{3, 4, 5, 2, 45};

    // 👦 We want to find a group of numbers that adds up to this.
    // 🧑‍💻 This is the target sum we are trying to match via any one valid subsequence.
    static int target = 7;

    public static void main(String[] args) {
        // 👦 This is our "bag" to try different number combos.
        // 🧑‍💻 List to hold the current subset during the recursive exploration.
        List<Integer> ds = new ArrayList<>();

        // 👦 Start trying from the first number, with an empty bag and 0 as the current total.
        // 🧑‍💻 Start recursive backtracking from index 0 with sum = 0 and empty list.
        printSubArray(0, ds, 0);
    }

    /**
     * 👦 This function tries to find just ONE way to pick numbers so they add up to the target.
     * 🧑‍💻 Recursive backtracking function that prints only the **first valid** subsequence with sum == target.
     *      It returns `true` immediately after finding one match to stop further recursion.
     */
    private static boolean printSubArray(int index, List<Integer> ds, int sum) {

        // 👦 If we've checked all the numbers...
        // 🧑‍💻 Base case: Reached end of array
        if (index == nums.length) {
            // 👦 ...and the numbers we picked add up to the target, we print them!
            // 🧑‍💻 If current subset's sum equals target, print and return true to stop recursion.
            if (sum == target) {
                System.out.println(ds);
                return true;
            }
            // 👦 Otherwise, this combo didn't work.
            // 🧑‍💻 This path didn’t yield a valid solution.
            return false;
        }

        // 👦 Try taking this number into our bag.
        // 🧑‍💻 Include current number in subset.
        ds.add(nums[index]);
        sum += nums[index];

        // 👦 Now check the next number.
        // 🧑‍💻 Recursive call with inclusion; return true immediately if valid solution found.
        if (printSubArray(index + 1, ds, sum)) return true;

        // 👦 Take that number back out (undo).
        // 🧑‍💻 Backtrack: remove last number and undo the added sum.
        ds.remove(ds.size() - 1);
        sum -= nums[index];

        // 👦 Try skipping this number completely.
        // 🧑‍💻 Recursive call without inclusion.
        if (printSubArray(index + 1, ds, sum)) return true;

        // 👦 If neither taking nor skipping helped, say “nope”.
        // 🧑‍💻 No valid subset found in either path — return false to caller.
        return false;
    }
}

package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubArraysWhoseSomeIsK {

    // 👦 A list of numbers we will work with
    // 🧑‍💻 This is the input array. We will generate subsets and check which ones sum to the target
    static int[] nums = new int[]{3, 4, 5, 2, 45};

    // 👦 This is the total we are trying to reach
    // 🧑‍💻 Target sum value we want the subset to equal
    static int target = 7;

    public static void main(String[] args) {
        // 👦 An empty list to keep numbers we choose
        // 🧑‍💻 Holds the current subset being built
        List<Integer> ds = new ArrayList<>();

        // 👦 Start the function with index 0, empty list, and sum 0
        // 🧑‍💻 Begin recursive search from index 0 with empty subset and current sum = 0
        printSubArray(0, ds, 0);
    }

    /**
     * 👦 This is like choosing or skipping each number one by one.
     * 🧑‍💻 This recursive method generates all subsets of `nums` and prints the ones with sum == target
     */
    private static void printSubArray(int index, List<Integer> ds, int sum) {

        // 👦 If we have checked all numbers...
        // 🧑‍💻 Base case: when we've processed all elements
        if (index == nums.length) {
            // 👦 If total is what we want, then print the list
            // 🧑‍💻 Print the subset if its sum equals the target
            if (sum == target) {
                System.out.println(ds);
            }
            return;
        }

        // 👦 Try including the current number
        // 🧑‍💻 Include nums[index] in the current subset
        ds.add(nums[index]);
        sum += nums[index];

        // 👦 Go to the next number
        // 🧑‍💻 Recurse with next index after including the current number
        printSubArray(index + 1, ds, sum);

        // 👦 Now undo the choice (backtrack)
        // 🧑‍💻 Backtrack: remove the last element added
        ds.remove(ds.size() - 1);
        sum -= nums[index];

        // 👦 Try the case where we skip this number
        // 🧑‍💻 Exclude current number and move to the next index
        printSubArray(index + 1, ds, sum);
    }
}

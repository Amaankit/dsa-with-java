package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    // 👦 All our winning number teams go here!
    // 🧑‍💻 Stores all unique valid combinations summing to target
    public static List<List<Integer>> ans = new ArrayList<>();

    // 👦 These are the blocks we can pick to make our number tower
    // 🧑‍💻 Input candidate numbers (must be sorted before use)
    public static int[] arr = new int[]{2, 3, 6, 7};

    // 👦 This is our magic basket where we try different blocks
    // 🧑‍💻 Temporary list to hold current combination being explored
    public static List<Integer> ds = new ArrayList<>();

    public static void main(String[] args) {
        // 👦 Here's another set of numbers, just for showing sorting
        // 🧑‍💻 Irrelevant example array; not used in the actual logic
        int[] ar4 = new int[]{4, 3, 53, 5};

        // 👦 Let's sort our blocks before we build anything
        // 🧑‍💻 Sort input array to handle duplicates and pruning
        Arrays.sort(arr);

        // 👦 Now let's try building towers that add up to 7
        // 🧑‍💻 Start recursive backtracking to find all combinations summing to 7
        findCombinations(0, 7, ds);

        // 👦 Print this sorted set just to see what it looks like!
        // 🧑‍💻 Unrelated print statement; demonstrates sorting only
        System.out.println(Arrays.toString(ar4));
    }

    private static void findCombinations(int ind, int target, List<Integer> ds) {
        // 👦 If our tower adds up to the target, yay! Save it
        // 🧑‍💻 Base case: if sum matches target, add a deep copy of current combination
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // 👦 Let's try each block one by one from where we left off
        // 🧑‍💻 Loop through remaining candidates to build combinations
        for (int i = ind; i < arr.length; i++) {

            // 👦 If this block is the same as the one before it, skip to avoid repeat towers
            // 🧑‍💻 Skip duplicate values at the same recursive level to avoid duplicate combinations
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // 👦 If the block is too big to fit, stop trying!
            // 🧑‍💻 No need to continue if current number exceeds remaining target
            if (arr[i] > target) break;

            // 👦 Put the block in the basket and keep building
            // 🧑‍💻 Choose current element and explore further
            ds.add(arr[i]);

            // 👦 Try the next block with a smaller target
            // 🧑‍💻 Recurse with reduced target and next index to avoid reusing the same element
            findCombinations(i + 1, target - arr[i], ds);

            // 👦 Take the block out and try a different one
            // 🧑‍💻 Backtrack by removing the last added element
            ds.remove(ds.size() - 1);
        }
    }
}

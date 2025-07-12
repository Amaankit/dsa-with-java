package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    // 👦 This will store all the good number groups (answers)
    // 🧑‍💻 Master list to collect all valid combinations
    public static List<List<Integer>> ans = new ArrayList<>();

    // 👦 These are the numbers we can pick from
    // 🧑‍💻 Input candidate array
    public static int[] arr = new int[]{2, 3, 6, 7};

    // 👦 Our basket to try different number combinations
    // 🧑‍💻 Current subset under construction
    public static List<Integer> ds = new ArrayList<>();

    public static void main(String[] args) {
        // 👦 Start the search from index 0 and target = 7
        // 🧑‍💻 Begin recursive backtracking to find all combinations that sum to 7
        findCombinations(0, 7, ds);

        // 👦 Print all the number groups that added up to the target
        // 🧑‍💻 Output the list of all valid combinations
        System.out.println(ans);
    }

    /**
     * 👦 This function tries all ways to add numbers so they total up to the target
     * 🧑‍💻 Recursive function to explore all combinations of elements (with repetition allowed)
     *      that sum up to the given target.
     */
    public static void findCombinations(int index, int target, List<Integer> ds) {
        // 👦 If we tried all numbers
        // 🧑‍💻 Base case: reached the end of the array
        if (index == arr.length) {
            // 👦 And we got the exact total, save it
            // 🧑‍💻 If sum == target, add the current list as a new result
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); // ✅ Clone list before storing
            }
            return;
        }

        // 👦 If we can still pick the number at this spot
        // 🧑‍💻 Include arr[index] if it doesn't exceed remaining target
        if (arr[index] <= target) {
            ds.add(arr[index]); // 👦 Add it to the basket
            findCombinations(index, target - arr[index], ds); // 👦 Try again with new total
            ds.remove(ds.size() - 1); // 👦 Take it back and try something else (backtrack)
        }

        // 👦 Try skipping this number and moving forward
        // 🧑‍💻 Move to the next index (exclude current element)
        findCombinations(index + 1, target, ds);
    }
}

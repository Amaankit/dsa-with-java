package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintingSubsequences {

    // 🧑 A static array containing integers to generate subsequences from.
    // 👦 These are the numbers we will use to make all possible combinations.
    static int[] nums = new int[]{3, 4, 5, 45};

    public static void main(String[] args) {
        // 👦 An empty list where we will build different number combinations
        // 🧑 This list holds the current subsequence during recursion
        List<Integer> ds = new ArrayList<>();

        // 👦 Start the process from the first number (index 0)
        // 🧑 Start generating subsequences from index 0
        printSubseq(0, ds, nums.length);
    }

    // 🧑 Recursive function to generate all subsequences of the nums[] array.
    // 👦 This function helps us try out all ways of picking or skipping numbers.
    public static void printSubseq(int i, List<Integer> ds, int length) {

        // 🧑 Base case: if the index reaches the array length, we've made one full subsequence.
        // 👦 If we checked all numbers, time to show what we picked.
        if (i == length) {
            if (ds.isEmpty()) {
                // 👦 If we didn’t pick any number, show empty {}
                // 🧑 Empty list represents the empty subsequence.
                System.out.println("{}");
            } else {
                // 👦 Show the picked numbers
                // 🧑 Print the current valid subsequence
                System.out.println(ds);
            }
            return;
        }

        // 👦 First, we try adding this number and continue
        // 🧑 Include the current number in the subsequence and recurse
        ds.add(nums[i]);
        printSubseq(i + 1, ds, length);

        // 👦 Now we remove the number (undo), and try without it
        // 🧑 Backtrack by removing the last element before exploring the "exclude" path
        ds.remove(ds.size() - 1);

        // 👦 Try without including the current number
        // 🧑 Exclude the current number and recurse
        printSubseq(i + 1, ds, length);
    }
}

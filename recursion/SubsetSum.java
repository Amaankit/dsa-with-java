package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    // 👦 This is where we save the magic totals we can make!
    // 🧑‍💻 Stores all possible subset sums
    public static List<Integer> ans = new ArrayList<>();

    // 👦 These are our special number blocks we can use
    // 🧑‍💻 Input array of numbers to form subsets from
    public static int[] arr = new int[]{2, 3, 6, 7};

    public static void main(String[] args) {
        // 👦 These are just some other numbers, not used in our magic game
        // 🧑‍💻 Unused array — just here for demonstration, not used in logic
        int[] ar4 = new int[]{4, 3, 53, 5};

        // 👦 Time to start the magic! Let’s begin from the first number and a total of 0
        // 🧑‍💻 Start recursive function from index 0 and initial sum of 0
        findSubSetSum(0, 0);

        // 👦 Ta-da! Here are all the different sums we made!
        // 🧑‍💻 Print all possible subset sums
        System.out.println(ans);
    }

    /**
     * 👦 This function helps us pick or skip number blocks to see what totals we can make!
     * 🧑‍💻 Recursive function to explore all subsets and calculate their sums.
     * @param index - 👦 Which number block we are looking at now 🧑‍💻 Current index in input array
     * @param sum   - 👦 The current magic total so far 🧑‍💻 The sum of the current subset
     */
    private static void findSubSetSum(int index, int sum) {
        // 👦 If we’ve looked at all the number blocks, save our total
        // 🧑‍💻 Base case: if we've reached the end, record the current subset sum
        if (index == arr.length) {
            ans.add(sum);
            return;
        }

        // 👦 Try adding this number to our total and go to the next
        // 🧑‍💻 Include the current element and recurse
        findSubSetSum(index + 1, sum + arr[index]);

        // 👦 Or skip this number and try the next one without adding it
        // 🧑‍💻 Exclude the current element and recurse
        findSubSetSum(index + 1, sum);
    }
}

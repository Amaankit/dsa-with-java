package slidingWindowAndTwoPointers; /**
 * 🔍 Problem: 3Sum (LeetCode #15)
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that:
 *   - i != j, i != k, and j != k
 *   - nums[i] + nums[j] + nums[k] == 0
 *
 * The solution set must not contain duplicate triplets.
 *
 * 🔧 Example:
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 * ✅ Constraints:
 * - Time Complexity: O(n^2)
 * - Space Complexity: O(1) (ignoring the result list)
 *
 * 🔄 Approach (Optimal using Two-Pointer after Sorting):
 * 1. Sort the array to make it easy to skip duplicates and use two pointers.
 * 2. Iterate through the array:
 *      - Skip duplicates for the current index.
 *      - Use two pointers (`left`, `right`) to find pairs such that nums[i] + nums[left] + nums[right] == 0.
 *      - Skip duplicates for left/right as needed.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        // Example input array
        int[] s = new int[]{-1, 0, 1, 2, -1, -4};
        // Call the threeSum method and print the result
        System.out.println(threeSum(s)); // Expected: [[-1, -1, 2], [-1, 0, 1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort the array for two-pointer technique and easy duplicate handling

        List<List<Integer>> result = new ArrayList<>(); // List to store the final triplets

        // Iterate over the array, fixing one number at a time
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for the current index
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1; // Left pointer just after the current element
            int right = nums.length - 1; // Right pointer at the end of the array

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; // Calculate the triplet sum

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;  // Move both pointers inward
                    right--;
                } else if (sum > 0) {
                    right--; // Decrease sum by moving right pointer to smaller values
                } else {
                    left++; // Increase sum by moving left pointer to higher values
                }
            }
        }

        return result; // Return all unique triplets found
    }
}

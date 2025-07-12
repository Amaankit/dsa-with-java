
/**
 * Problem 1: Two Sum
 * Given an array of integers and a target value, return the indices of the two numbers such that they add up to the target.
 */

import java.util.*;

public class TwoThreeSum {

    // ---------------------- TWO SUM ----------------------

    /**
     * Brute Force Approach: Check every pair to find the two numbers that add up to the target.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * Optimal Approach: Use a HashMap to store (value, index). Check if (target - current value) exists in the map.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // ---------------------- THREE SUM ----------------------

    /**
     * Brute Force: Try all possible triplets.
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public static List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * Optimal Approach: Sort and use two pointers after fixing the first element.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) + O(k) for output
     */
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Two Sum (Optimal): " + Arrays.toString(twoSumOptimal(nums, target)));

        int[] nums2 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Three Sum (Optimal): " + threeSumOptimal(nums2));
    }
}

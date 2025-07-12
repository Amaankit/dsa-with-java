package slidingWindowAndTwoPointers;/*
* Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
* */

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length; // Get the length of the input array
        int l = 0; // Left pointer initialization
        int r = 0; // Right pointer initialization
        int sum = 0; // Current window sum
        int minLength = 100000000; // Initialize minLength to a large value (acts like infinity)

        while (r < n) { // Traverse the array with the right pointer
            sum += nums[r]; // Add the current element to the sum

            // Try to shrink the window from the left as long as sum >= target
            while (sum >= target) {
                int length = r - l + 1; // Calculate current window length
                if (minLength > length) {
                    minLength = length; // Update minimum length if current window is smaller
                }
                sum -= nums[l]; // Remove the element at left pointer from sum
                l++; // Move the left pointer to the right to shrink the window
            }
            r++; // Expand the window by moving the right pointer to the right
        }

        // If no valid subarray was found, return 0; otherwise, return minLength
        return minLength == 100000000 ? 0 : minLength;
    }
}

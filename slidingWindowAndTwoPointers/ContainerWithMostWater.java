package slidingWindowAndTwoPointers;

/**
 * LeetCode 11: Container With Most Water
 *
 * 🔸 Problem Statement:
 * You are given an array of integers height of length n.
 * There are n vertical lines drawn such that the two endpoints
 * of the i-th line are at (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container
 * that holds the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * 🔹 Constraints:
 * - n >= 2
 * - 0 <= height[i] <= 10^4
 *
 * 🔸 Solution Approach (Two Pointer Technique):
 * - Initialize two pointers, one at the beginning (`left`), and one at the end (`right`)
 * - At each step, calculate the area formed by the two lines:
 *     - width = right - left
 *     - height = min(height[left], height[right])
 * - Move the pointer pointing to the shorter line inward,
 *   since that might help increase the area by increasing the minimum height
 * - Repeat this until left meets right
 *
 * 🔹 Time Complexity: O(n)
 * 🔹 Space Complexity: O(1)
 */

public class ContainerWithMostWater {

    public static void main(String[] args) {
        // Sample input array of line heights
        int[] s = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        // Print the maximum area of water container
        System.out.println(maxArea(s)); // Expected Output: 49
    }

    // Function to compute the maximum water area
    public static int maxArea(int[] height) {
        // Initialize two pointers at start and end of array
        int left = 0;
        int right = height.length - 1;

        // Variable to track the maximum area found
        int maxArea = 0;

        // Loop until the two pointers meet
        while (left < right) {
            // Calculate current container area using width * height
            int area = (right - left) * Math.min(height[left], height[right]);

            // Update max area if the current area is larger
            maxArea = Math.max(area, maxArea);

            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++; // Move left inward
            } else {
                right--; // Move right inward
            }
        }

        // Return the maximum area found
        return maxArea;
    }
}

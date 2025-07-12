package slidingWindowAndTwoPointers; /**
 * 🧩 Problem Statement:
 * Given two strings `s` and `k`, find the minimum length substring in `s`
 * which contains all characters of `k` (including duplicates).
 * The order of characters does not matter.
 *
 * Example:
 * Input: s = "aabcabcbb", k = "abc"
 * Output: "abc"
 *
 * ✅ Constraints:
 * - Characters in `k` can repeat.
 * - The result must include all characters in `k` with the required frequency.
 *
 * 💡 Approach (Sliding Window + HashMap - Detailed Explanation):
 *
 * 1. **Build a frequency map** for string `k` using a HashMap. This helps us track which characters
 *    we need to include in the window and how many times.
 *    For example, if k = "aabc", then freqMap = {a:2, b:1, c:1}.
 *
 * 2. Initialize two pointers `leftIndex` and `rightIndex` to represent a sliding window in string `s`.
 *    We'll slide `rightIndex` forward to expand the window, and `leftIndex` to shrink it once all
 *    characters from `k` are matched.
 *
 * 3. For each character added to the window (moving `rightIndex`):
 *    - Decrement its count in the map.
 *    - If that character was required (its count was > 0), increase the `count` of matched characters.
 *
 * 4. Once `count` becomes equal to the length of `k`, it means the current window contains all
 *    characters from `k` (with required frequency). Now, try to shrink the window by moving `leftIndex`
 *    while still maintaining a valid window.
 *
 * 5. During shrinking:
 *    - If the current window is smaller than the previously found minimum, update `minimumLength` and `startingIndex`.
 *    - Restore the count of the character at `leftIndex` in the map.
 *    - If the restored count goes above 0, it means that character is now missing from the window,
 *      so decrement the `count`.
 *
 * 6. Continue this process until the entire string `s` is traversed.
 * 7. Finally, if a valid window is found, return the substring using `startingIndex` and `minimumLength`.
 *    Otherwise, return an empty string.
 *
 * 🕐 Time Complexity: O(n), where n is the length of `s`.
 * 🔁 Space Complexity: O(m), where m is the number of distinct characters in `k`.
 */


import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "aabcabcbb";
        String k = "abc";
        System.out.println(minimumSubstring(s, k)); // Output will be "abc"
    }

    // This method returns the minimum substring of `s` that contains all characters of `k`
    public static String minimumSubstring(String s, String k) {
        int leftIndex = 0;  // Left boundary of sliding window
        int count = 0;      // To track how many characters from `k` have been fully matched
        int rightIndex = 0; // Right boundary of sliding window
        int n = s.length(); // Total length of the string `s`
        int startingIndex = -1; // Starting index of the minimum substring
        int minimumLength = Integer.MAX_VALUE; // Stores minimum window length

        // Step 1: Build a frequency map of characters in string `k`
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < k.length(); i++) {
            char ch = k.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Expand window with right pointer
        while (rightIndex < n) {
            char ch = s.charAt(rightIndex);

            // If current character is needed (its count > 0), increase match count
            if (map.getOrDefault(ch, 0) > 0) {
                count++;
            }

            // Decrease character count from the map
            map.put(ch, map.getOrDefault(ch, 0) - 1);

            // Step 3: Shrink window from the left as long as all characters are matched
            while (count == k.length()) {
                // Update minimum window length and start index
                if (rightIndex - leftIndex + 1 < minimumLength) {
                    minimumLength = rightIndex - leftIndex + 1;
                    startingIndex = leftIndex;
                }

                // Shrink from the left
                char leftChar = s.charAt(leftIndex);
                map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);

                // If character was needed, decrement match count
                if (map.get(leftChar) > 0) {
                    count--;
                }
                leftIndex++;
            }

            // Move right pointer to expand window
            rightIndex++;
        }

        // Step 4: Return result
        return startingIndex != -1 ? s.substring(startingIndex, startingIndex + minimumLength) : "";
    }
}

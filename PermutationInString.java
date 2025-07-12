// Importing HashMap (not needed for this solution, can be removed)
import java.util.HashMap;


/**
 * 🧩 Problem Statement:
 * Given two strings `s1` and `s2`, return true if `s2` contains a permutation of `s1`,
 * i.e., one of `s1`'s permutations is a substring of `s2`.
 *
 * Example:
 * Input: s1 = "abc", s2 = "axybcabcbab"
 * Output: true (since "bca", "cab", or "abc" is present in `s2`)
 *
 * ✅ Constraints:
 * - Only lowercase English letters.
 * - Length of s1 <= length of s2
 *
 * 💡 Approach (Sliding Window + Frequency Arrays):
 * 1. Create two arrays `s1Counts` and `s2Counts` of size 26 (for each lowercase letter).
 *    - `s1Counts`: stores frequency of characters in `s1`
 *    - `s2Counts`: stores frequency of characters in the current window of size s1.length() in `s2`
 *
 * 2. Initialize the counts for the first window and compare how many characters have matching frequencies.
 *    If all 26 characters match → return true.
 *
 * 3. Slide the window through `s2`:
 *    - Remove the leftmost character of the previous window.
 *    - Add the new rightmost character.
 *    - For each move, update `matches` accordingly:
 *      - If character frequencies match → increment `matches`
 *      - If they mismatch after the update → decrement `matches`
 *
 * 4. At any point, if `matches == 26`, return true.
 * 5. If no match found after full traversal → return false.
 *
 * 🕐 Time Complexity: O(n), where n = length of `s2`
 * 🔁 Space Complexity: O(1), since arrays are fixed size (26)
 */

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "abc";                          // String whose permutation we want to find in s2
        String s2 = "axybcabcbab";                  // Source string in which we are searching

        System.out.println(checkInclusion(s1, s2)); // Calling function and printing result
    }

    // This function returns true if any permutation of s1 is a substring of s2
    public static Boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;   // If s1 is longer, permutation can't be in s2

        int matches = 0;                               // Number of character matches between s1 and s2 window
        int[] s1Counts = new int[26];                  // Frequency array for s1
        int[] s2Counts = new int[26];                  // Frequency array for the current window of s2

        // Count characters in s1 and initial window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;            // Increment frequency for character in s1
            s2Counts[s2.charAt(i) - 'a']++;            // Increment frequency for character in initial s2 window
        }

        // Compare both frequency arrays to count how many characters match
        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] == s2Counts[i]) {
                matches++;                             // If frequency matches, increment match count
            }
        }

        // Slide the window through s2 starting from s1.length()
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;            // If all 26 characters match, return true

            int indexRight = s2.charAt(right) - 'a';   // New character coming into the window
            s2Counts[indexRight]++;                    // Increment count in s2 window

            // Update match count based on new character
            if (s1Counts[indexRight] == s2Counts[indexRight]) {
                matches++;                             // Match gained
            } else if (s1Counts[indexRight] + 1 == s2Counts[indexRight]) {
                matches--;                             // Mismatch occurred due to frequency overflow
            }

            int indexLeft = s2.charAt(right - s1.length()) - 'a'; // Character leaving the window
            s2Counts[indexLeft]--;                      // Decrease count in s2 window

            // Update match count based on removed character
            if (s1Counts[indexLeft] == s2Counts[indexLeft]) {
                matches++;                              // Match restored
            } else if (s1Counts[indexLeft] - 1 == s2Counts[indexLeft]) {
                matches--;                              // Match lost due to underflow
            }
        }

        return matches == 26;                           // Final check after loop
    }
}

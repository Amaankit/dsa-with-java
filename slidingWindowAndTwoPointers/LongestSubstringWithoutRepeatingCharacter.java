package slidingWindowAndTwoPointers;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        // Try out the function with a test word
        String s = "abcabcbb";
        // Print the answer: how long is the longest part of the word with no repeating letters?
        System.out.println(LongestSubstring(s)); // Output will be 3 for "abc"
    }

    // This function finds the longest stretch in a word where no letter repeats
    public static String LongestSubstring(String s) {
        int len = s.length();
        int l = 0; // Left pointer for the sliding window
        int r = 0; // Right pointer for the sliding window
        int startingIndex = -1; // Stores the starting index of the maximum length substring
        int maxLength = 0; // Stores the length of the maximum substring found
        HashMap<Character, Integer> charset = new HashMap<>(); // Stores the latest index of each character

        while (r < len) {
            char currentChar = s.charAt(r);
            Integer charIndex = charset.get(currentChar); // Get the last index of current character

            // If currentChar is not in the current window (or hasn't been seen before)
            if (charIndex == null || charIndex < l) {
                int length = r - l + 1; // Calculate current window size
                if (length > maxLength) {
                    maxLength = length; // Update maximum length
                    startingIndex = l; // Update starting index (Important: should use 'l' not 'r')
                }
            } else {
                // If currentChar was seen inside the current window
                // Move the left pointer just after the last occurrence of currentChar
                l = charIndex + 1;
            }

            // Update or insert the current character's latest index
            charset.put(currentChar, r);
            r++;
        }

        // Return the longest substring using startingIndex and maxLength
        return startingIndex == -1 ? "" : s.substring(startingIndex, startingIndex + maxLength);
    }

}

package slidingWindowAndTwoPointers;

import java.util.Arrays;

public class NumberOfSubstringContainingAllThreeCharacters {

    // This program counts how many substrings (small parts of a string)
    // contain all three letters: 'a', 'b', and 'c'

    public static void main(String[] args) {
        String arr = "abaabcaab";  // The string we are checking
        System.out.println(getNumberOfSubstring(arr));  // Print the answer
    }

    public static int getNumberOfSubstring(String a) {
        int count = 0;  // This will store how many substrings we found
        int[] lastSeen = new int[]{-1, -1, -1};  // Remember where we last saw 'a', 'b', and 'c'

        // Go through every letter in the string one by one
        for (int i = 0; i < a.length(); i++) {
            // Update the last position where we saw 'a', 'b', or 'c'
            // For example, if we see 'a', then we update lastSeen[0] = i
            lastSeen[a.charAt(i) - 'a'] = i;

            // If we have seen all three letters at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the smallest index among the three last seen
                // That’s the earliest all three letters were included
                // All substrings from that index up to this one will have 'a', 'b', and 'c'
                count += 1 + Arrays.stream(lastSeen).min().orElse(0);
            }
        }

        return count;  // Return the total count
    }
}

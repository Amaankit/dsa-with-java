import java.util.HashMap;
//TO BE SOLVED

public class SlidingWindowMaximum {



    public static void main(String[] args) {
        // Try out the function with a test word
        String s = "abcabcbb";
        // Print the answer: how long is the longest part of the word with no repeating letters?
        System.out.println(lengthOfLongestSubstring(s)); // Output will be 3 for "abc"
    }

    // This function finds the longest stretch in a word where no letter repeats
    public static int lengthOfLongestSubstring(String s) {

        int leftIndex = 0;     // Start of the sliding window (like the start of a highlighter)
        int rightIndex = 0;    // End of the sliding window (like the other end of a highlighter)
        int n = s.length();    // Total number of letters in the word

        int maxLength = 0;     // The longest part with no repeating letters found so far

        // This map will remember where each letter was last seen in the word
        HashMap<Character, Integer> map = new HashMap<>();

        // Move the right end of the window through the word
        while (rightIndex < n) {
            char currentChar = s.charAt(rightIndex); // Look at the letter at the right end

            // Check if this letter has been seen before
            Integer charIndex = map.get(currentChar);

            // If we've seen it before AND it's inside the current highlighted part
            if (charIndex != null && charIndex >= leftIndex) {/*.***** This greater than Equals to is too critical ***** */
                // Move the left end just after the last time this letter appeared
                // This way, we remove the repeated letter from the window
                leftIndex = charIndex + 1;   //***********LOOOOOOOOOK AT THIS
            }

            // Calculate how many letters are in the current highlighted part
            int length = rightIndex - leftIndex + 1;

            // Update the longest length if this one is bigger
            maxLength = Math.max(maxLength, length);

            // Remember where we last saw this letter
            map.put(currentChar, rightIndex);

            // Move the right end forward to check the next letter
            rightIndex++;
        }

        // After the loop, return the longest length we found
        return maxLength;
    }
}

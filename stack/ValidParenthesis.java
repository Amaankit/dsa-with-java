package stack; /**
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

public class ValidParenthesis {

    public static void main(String[] args) {
        // Example input array
        String s = "()";
        // Call the threeSum method and print the result
        System.out.println(isValid(s)); // Expected: [[-1, -1, 2], [-1, 0, 1]]
    }


    private static  boolean matches(char open,char close){
        return (open =='(' && close== ')') ||
                (open =='{' && close== '}') ||
                (open =='[' && close== ']');
    }
    public static  boolean isValid(String s) {
        char[] stack = new char[s.length()];
        if(s.length()%2!=0){
            return false;
        }
        int top = -1;
        for(char ch:s.toCharArray() ){
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;
            }else{
                if(top==-1 || !matches(stack[top],ch)) return false;
                top--;
            }
        }
        return top == -1;

    }
}

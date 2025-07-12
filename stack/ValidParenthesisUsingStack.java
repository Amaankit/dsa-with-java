package stack;

import java.util.Stack;

public class ValidParenthesisUsingStack {

    // Helper method to check if opening and closing brackets match
    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // Use built-in stack for simplicity

        // Iterate over each character in the input string
        for (char ch : s.toCharArray()) {

            // If it's an opening bracket, push onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If stack is empty or doesn't match the current closing bracket, it's invalid
                if (stack.isEmpty() || !matches(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    // Main method to test the function
    public static void main(String[] args) {

        String input = "{[()]}";
        System.out.println("Is valid? " + isValid(input)); // Output: true
    }
}

package linkedlist;

/**
 * LeetCode 19: Remove Nth Node From End of List
 *
 * 🔸 Problem Statement:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * 🔹 Constraints:
 * - The list is non-empty and contains at least 1 node.
 * - 1 <= n <= size of the list
 *
 * 🔸 Solution Approach (Two Pointers / Fast-Slow Technique):
 * - Use two pointers (`fastPointer` and `slowPointer`) both initialized to the head.
 * - Move `fastPointer` `n` steps ahead.
 * - Then move both pointers one step at a time until `fastPointer` reaches the end.
 * - `slowPointer` will then point to the node just before the one that needs to be removed.
 * - Remove the target node by updating `slowPointer.next`.
 * - Edge Case: If `fastPointer` becomes null after the initial `n` steps,
 *   it means the head needs to be removed (e.g., removing the nth node from a list of size n).
 *
 * 🔹 Time Complexity: O(L), where L is the length of the list.
 * 🔹 Space Complexity: O(1)
 */

public class RemoveNthNodeOfAList {

    // Definition for singly-linked list
    private static class ListNode {
        int val; // Value of the node
        ListNode next; // Pointer to the next node

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to remove the nth node from the end of the list
    private ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize two pointers to the head of the list
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        // Move fastPointer n steps ahead
        for (int i = 0; i < n; i++) {
            fastPointer = fastPointer.next;
        }

        // If fastPointer is null, it means we need to remove the head node
        if (fastPointer == null) return head.next;

        // Move both pointers until fastPointer reaches the end
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;       // Advance fastPointer
            slowPointer = slowPointer.next;       // Advance slowPointer
        }

        // Skip the target node by linking to the node after the one to be removed
        slowPointer.next = slowPointer.next.next;

        // Return the updated head of the list
        return head;
    }
}

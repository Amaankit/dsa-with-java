package linkedlist;

/**
 * LeetCode 21: Merge Two Sorted Lists
 *
 * 🔸 Problem Statement:
 * You are given the heads of two **sorted** linked lists `list1` and `list2`.
 * Merge the two lists into a single sorted list. The resulting list should also be sorted.
 * Return the head of the merged linked list.
 *
 * 🔹 Constraints:
 * - The linked lists are sorted in non-decreasing order.
 * - You must merge the lists in-place (without creating new nodes).
 *
 * 🔸 Solution Approach (Iterative with Dummy Node):
 * - Create a dummy node to simplify list merging.
 * - Use two pointers (`t1`, `t2`) to traverse both lists.
 * - At each step, compare values at `t1` and `t2`, and link the smaller one to the merged list.
 * - Move the pointer whose node was added.
 * - After one list is fully traversed, link the remaining part of the other list.
 * - Return `dummy.next` as the head of the new merged list.
 *
 * 🔹 Time Complexity: O(n + m) where n and m are lengths of list1 and list2.
 * 🔹 Space Complexity: O(1) (no new nodes created, just pointer manipulation)
 */

public class MergeTwoSortedList {

    // Definition for singly-linked list
    private static class ListNode {
        int val; // Value of the node
        MergeTwoSortedList.ListNode next; // Pointer to the next node

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, MergeTwoSortedList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Pointers for both input lists
        ListNode t1 = list1;
        ListNode t2 = list2;

        // Dummy node to start the merged list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode; // Temp pointer to build merged list

        // Traverse both lists while both have nodes
        while (t1 != null && t2 != null) {
            // Compare values and attach the smaller one to merged list
            if (t1.val > t2.val) {
                temp.next = t2; // Add t2 node to merged list
                temp = t2;      // Move temp forward
                t2 = t2.next;   // Advance t2
            } else {
                temp.next = t1; // Add t1 node to merged list
                temp = t1;      // Move temp forward
                t1 = t1.next;   // Advance t1
            }
        }

        // Attach any remaining nodes
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        // Return the head of the merged list (skip dummy node)
        return dummyNode.next;
    }
}





package linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedList {

    // Definition for singly-linked list
    private static class ListNode {
        int val; // Value of the node
        MergeKSortedList.ListNode next; // Pointer to the next node

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, MergeKSortedList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Min heap that compares ListNodes based on their value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add head of each list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Dummy node to build the result list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process the heap
        while (!pq.isEmpty()) {
            // Get the smallest node
            ListNode smallest = pq.poll();
            // Add it to the merged list
            current.next = smallest;
            current = current.next;

            // If there's a next node in the list, push it into the heap
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        // Return the merged list starting from dummy.next
        return dummy.next;
    }
}


package org.example;

public class Solution {

    /**
     * Sorts a given linked list using merge sort.
     *
     * @param head The head of the linked list to be sorted.
     * @return The sorted linked list.
     */
    public ListNode sortList(ListNode head) {
        return mergeSortRecur(head);
    }

    /**
     * Recursively performs merge sort on a linked list.
     *
     * @param head The head of the linked list to be sorted.
     * @return The sorted linked list.
     */
    public ListNode mergeSortRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        ListNode middle = findMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null;

        // Recursively sort both halves
        ListNode firstHalfSorted = mergeSortRecur(head);
        ListNode secondHalfSorted = mergeSortRecur(secondHalf);

        // Merge the sorted halves
        return merge(firstHalfSorted, secondHalfSorted);
    }

    /**
     * Finds the middle node of a linked list.
     *
     * @param head The head of the linked list.
     * @return The middle node.
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * Merges two sorted linked lists into a single sorted linked list.
     *
     * @param left  The head of the first sorted linked list.
     * @param right The head of the second sorted linked list.
     * @return The merged sorted linked list.
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode currentList = dummyHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                currentList.next = left;
                left = left.next;
            } else {
                currentList.next = right;
                right = right.next;
            }
            currentList = currentList.next;
        }

        if (left != null) {
            currentList.next = left;
        }

        if (right != null) {
            currentList.next = right;
        }

        return dummyHead.next;
    }
}

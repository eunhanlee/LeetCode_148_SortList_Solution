package org.example;

public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSortRecur(head);
    }

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

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

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
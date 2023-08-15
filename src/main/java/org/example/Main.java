package org.example;

public class Main {
    public static void main(String[] args) {

        Solution tt = new Solution();
        ListNode list = new ListNode(4);
        list.next = new ListNode(2);
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(3);


        list = tt.sortList(list);
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
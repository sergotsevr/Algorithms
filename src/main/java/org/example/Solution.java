package org.example;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = new ListNode(0);
        ListNode curr = first;
        int adder = 0;

        while (l1 != null || l2 != null || adder != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + adder;
            adder = (sum) / 10;
            ListNode node = new ListNode((sum) % 10);
            curr.next = node;
            curr = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return first.next;
    }
}
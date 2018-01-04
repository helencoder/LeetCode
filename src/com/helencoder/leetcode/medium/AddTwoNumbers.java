package com.helencoder.leetcode.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * Created by zhenghailun on 2018/1/2.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers2(l1, l2);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        ListNode tmp1 = l1;
        while (tmp1 != null) {
            sb1.insert(0, tmp1.val);
            tmp1 = tmp1.next;
        }

        ListNode tmp2 = l2;
        while (tmp2 != null) {
            sb2.insert(0, tmp2.val);
            tmp2 = tmp2.next;
        }

        int num = Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());

        char[] charArr = String.valueOf(num).toCharArray();

        ListNode res = new ListNode(charArr[charArr.length - 1]);
        for (int i = charArr.length - 2; i >= 0; i--) {
            res.next = new ListNode(charArr[i]);
        }

        return res;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            cur = cur.next;
        }
        if (carry != 0)
            cur.next = new ListNode(carry);
        return dummy.next;
    }

}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}


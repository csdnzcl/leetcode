/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/* class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur, nxt = null;
        cur = head;
        while(cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
} */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode reverNode = reverseList(head.next);
        ListNode tail = head.next;
        tail.next = head;
        head.next = null;
        return reverNode;
    }
}
// @lc code=end


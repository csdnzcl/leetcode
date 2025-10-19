/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);//防止
        ListNode p0 = dummy;
        ListNode pre = null, cur = null, nxt = null;
        int count = right - left + 1;
        for(int i = 1; i < left; ++i) {
            p0 = p0.next;
        }
        cur = p0.next;//指向第left个结点

        for (int i = 0; i <= right - left; ++i) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
        
    }
}
// @lc code=end




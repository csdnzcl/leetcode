/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = new ListNode(-3);
        ListNode slow = new ListNode(-1);
        slow.next = head;
        fast.next = head;
        while(n-- > 0){
            fast = fast.next;
        }
        if(fast.next == null) {
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
// @lc code=end

/*
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
示例 1：

输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
 */
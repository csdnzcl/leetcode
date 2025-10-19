/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy.next;
        int n = 0;
        while(p0 != null) {
            p0 = p0.next;
            ++n;
        }
        if(k > n) {
            return head;
        }
        p0 = dummy;
        ListNode pre = null, cur, nxt;
        cur = p0.next;
        int num = n/k;
        while(num != 0){
            --num;
            for(int i = 0; i < k; ++i) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode temp = p0.next;
            temp.next = cur;
            p0.next = pre;
            p0 = temp;
        }
        return dummy.next;
    }
}
// @lc code=end

/* 
 * 
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
  k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
  你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]

示例 2：
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 */
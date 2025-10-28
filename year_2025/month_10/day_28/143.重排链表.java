/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode pre = null, cur = mid, tmp = cur;
        //从中间反转链表
        while(cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        ListNode head2 = pre;
        ListNode leftHead = null, rightHead = null;
        while(head2.next != null){
            leftHead = head.next;
            rightHead = head2.next;
            head.next = head2;
            head2.next = leftHead;
            head = leftHead;
            head2 = rightHead;
        }
    }
}
// @lc code=end
/*
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例 1：
输入：head = [1,2,3,4]
输出：[1,4,2,3]
 */


 //错误代码：
 /*
  * 
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode pre = null, cur = mid, tmp = cur;
        //从中间反转链表-----------------错误： 最后一个节点并未实现翻转
        while(cur.next != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        ListNode head2 = cur;
        ListNode leftHead = null, rightHead = null;
        while(head != null){
            leftHead = head.next;
            rightHead = head2.next;
            head.next = head2;
            head2.next = leftHead;
            head = leftHead;
            head2 = rightHead;
        }
    }
}
  
  */

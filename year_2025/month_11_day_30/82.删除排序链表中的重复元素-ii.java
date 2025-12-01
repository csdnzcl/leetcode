/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null ) {
            int val = cur.next.val;
            if(val == cur.next.next.val) {
                while(cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }
            else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

//******需要重点复习
/*
 * 思想：
 * 由于重复了需要全部删除（包括当前节点），所以使用  前置节点.next  对当前节点进行相关操作
 */

/*
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，
 * 只留下不同的数字 。返回 已排序的链表 。
示例 1：

输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]

示例 2：

输入：head = [1,1,1,2,3]
输出：[2,3]

提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
 * 
 */
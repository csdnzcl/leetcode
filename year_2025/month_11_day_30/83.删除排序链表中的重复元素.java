/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
        if(head == null) {
            return null;
        }
        /* 
        ListNode node = head;
        while(node.next != null){
            while(node.val == node.next.val){
                if(node.next.next != null){
                    node.next = node.next.next;
                }
                else{
                    node.next = null;
                    break;
                }
            }
        //陷阱：node.next如果为空，则导致node为空，再回到24line，
        //则出现NullpointerException----null.next!=null
            node = node.next;
            if(node == null) {
                break;
            }//解决陷阱
        } 
        */
        //优化：
        ListNode node = head;
        while(node.next != null) {
            if(node.val == node.next.val) {
                node.next = node.next.next;
            }
            else {
                node = node.next;
            }
        }
        return head;
    }
}


// @lc code=end

/*
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，
 * 使每个元素只出现一次 。返回 已排序的链表 。
示例 1：

输入：head = [1,1,2]
输出：[1,2]
 * 
 */
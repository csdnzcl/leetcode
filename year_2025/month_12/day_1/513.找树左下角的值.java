/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int val = root.val;
        while (!q.isEmpty()) {
            int n = q.size();
            val = q.peek().val;
            while (n-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null)  q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return val;
    }
}
// @lc code=end
/* 
给定一个二叉树的 根节点 root，
请找出该二叉树的 最底层 最左边 节点的值。
假设二叉树中至少有一个节点。

示例 1:
输入: root = [2,1,3]
输出: 1

提示:
二叉树的节点个数的范围是 [1,104]
-231 <= Node.val <= 231 - 1 
 */
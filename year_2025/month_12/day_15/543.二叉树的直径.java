/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
 * 
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * 
 * 提示：
 * 树中节点数目在范围 [1, 104] 内
 * -100 <= Node.val <= 100 
*/
class Solution {
    int max = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if(root == null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int cur = left + right + 2;
        max = Math.max(max, cur);
        return Math.max(left, right) + 1;
    }
}
// @lc code=end
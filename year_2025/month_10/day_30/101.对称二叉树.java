/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSame(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSame(p.left,q.right) && 
        isSame(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }
}
// @lc code=end

/*
给你一个二叉树的根节点 root ， 检查它是否轴对称。
示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true
 */
/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null || p == null) {
            return p == q;
        }
        return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
// @lc code=end

/*
 class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null || p == null) {
            return p.val == q.val;
            //错误，如果 p 或 q 是 null，
            //访问 p.val 或 q.val 会导致 NullPointerException
        }
        return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
 */
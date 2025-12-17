/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
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
 * 给定一个二叉树，我们在树的节点上安装摄像头。节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。计算监控树的所有节点所需的最小摄像头数量
 */
class Solution {
    public int minCameraCover(TreeNode root) {
        int[] ans = new int[3];//ans[0]:装  ans[1]:父节点装，自己不装,  ans[2]:自己不装，至少一个子节点装
        ans = dfs(root);
        return Math.min(ans[0],ans[2]);
    }

    int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int ans[] = new int[3];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        ans[0] = Math.min(left[1], left[0]) + Math.min(right[1], right[0]) + 1;
        ans[1] = Math.min(left[0], left[2]) + Math.min(right[0], right[2]);
        ans[2] = Math.min(Math.min(left[0] + right[2], left[2] + right[0]), left[0] + right[0]);
        return ans;

    }
}
// @lc code=end


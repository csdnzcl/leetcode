/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);//res[0]：选  res[1]：不选
        return Math.max(res[0], res[1]); // 根节点选或不选的最大值
    }

    private int[] dfs(TreeNode node) {
        if (node == null) { // 递归边界
            return new int[]{0, 0}; // 没有节点，怎么选都是 0
        }
        int[] left = dfs(node.left); // 递归左子树
        int[] right = dfs(node.right); // 递归右子树
        int rob = left[1] + right[1] + node.val; // 选
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不选
        return new int[]{rob, notRob};
    }
}
// @lc code=end


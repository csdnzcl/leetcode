/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public int max(int a, int b){
        return a > b ? a : b;
    }
    public int maxDepth(TreeNode head) {
        if(head == null){
            return 0;
        }
        return 1 + max(maxDepth(head.left) , maxDepth(head.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int l = maxDepth(root.left) + 1;
        int r = maxDepth(root.right) + 1;
        int a = l-r;
        if(Math.abs(a) <= 1) {
            return true && isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
}
// @lc code=end

/*
注意平衡二叉树的定义：
树中任意节点左右子树的最大深度差 <= 1;
*/

/* 
官方题解：
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
*/
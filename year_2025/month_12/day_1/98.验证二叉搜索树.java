/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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

//1. 使用前序遍历：先判断，再递归
class Solution {
    private static final long inf = (long) Integer.MAX_VALUE + 3;
    public boolean isBST(TreeNode root, long left, long right){
        if(root == null) {
            return true;
        }
        int x = root.val;
        return x > left && x < right
        && isBST(root.left, left, x)
        && isBST(root.right, x, right);
    }
    public boolean isValidBST(TreeNode root) {
        return isBST(root, -inf, inf);
    }
}
//2. 使用中序遍历：
class Solution{
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if(root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}

//3. 后序遍历
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root)[1] != Long.MAX_VALUE;
    }

    private long[] dfs(TreeNode node) {
        if (node == null) {
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = dfs(node.left);
        long[] right = dfs(node.right);
        long x = node.val;
        // 也可以在递归完左子树之后立刻判断，如果发现不是二叉搜索树，就不用递归右子树了
        if (x <= left[1] || x >= right[0]) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[]{Math.min(left[0], x), Math.max(right[1], x)};
    }
}

//3. 使用后序遍历：


// @lc code=end

/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

示例 1：

输入：root = [2,1,3]
输出：true

提示：

树中节点数目范围在[1, 104] 内
-2^31 <= Node.val <= 2^31 - 1

*/
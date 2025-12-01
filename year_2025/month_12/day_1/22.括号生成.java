/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    private static final char[] MAPPING = {'(', ')'};
    public List<String> generateParenthesis(int n) {
        char[] path = new char[2*n];
        List<String> ans = new ArrayList<>();
        dfs(0, 0, n, path, ans);
        return ans;
        
    }
    private void dfs(int left, int right, int n, char[] path, List<String> ans) {
        if(right == n && left == n) {
            ans.add(new String(path));
            return;
        }
        //剪枝：
        if(left < right || left > n || right > n){
            return;
        }
        if (left < n) { 
            path[left + right] = MAPPING[0];
            dfs(left + 1, right, n, path, ans);
        }

        if (right < left) {
            path[left + right] = MAPPING[1];
            dfs(left, right + 1, n, path, ans);
        }
     }
}
// @lc code=end

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]

提示：
1 <= n <= 8
*/
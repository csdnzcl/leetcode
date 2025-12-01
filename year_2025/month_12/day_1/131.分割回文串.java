/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<List<String>> partition(String s) {
        char[] string = s.toCharArray();
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        dfs(0, string, path, ans);
        return ans;
    }
    private void dfs(int i, char[] s, List<String> path, List<List<String>> ans) {
        if (i == s.length) { 
            ans.add(new ArrayList<>(path)); 
            return;
        }
        for(int j = i; j < s.length; ++j){
            if(!isPalindrome(s, i, j)){
                continue;
            }
            path.add(new String(s, i, j - i + 1));
            dfs(j + 1, s, path, ans);
            path.remove(path.size() - 1);
        }
    }
    private boolean isPalindrome(char[] str, int left, int right) {
        while (left < right) {
            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end
/*
给你一个字符串 s，请你将 s 分割成一些 子串，
使每个子串都是 回文串 。返回 s 所有可能的分割方案。

示例 1：
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]

提示：
1 <= s.length <= 16
s 仅由小写英文字母组成
*/

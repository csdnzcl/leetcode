/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] MAPPING = new String[]{"", "", "abc", 
    "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        char[] path = new char[n];
        dfs(0,ans, path, digits.toCharArray());
        return ans;
    }
    public void dfs(int i, List<String> ans, char[] path, char[] digits) {
        if(i == digits.length){
            ans.add(new String(path));
            return ;
        }
        String letter = MAPPING[digits[i] - '0'];
        for (char c : letter.toCharArray()) {
            path[i] = c;
            dfs(i+1, ans, path, digits);
        }
    }
}
// @lc code=end
/* 
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

提示：
1 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */
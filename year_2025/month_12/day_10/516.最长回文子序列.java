/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */

// @lc code=start

//1. 区间DP 
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; --i) {
            for(int j = 0; j < n; ++j) {
                if(i > j) {
                    dp[i][j] = 0;
                }
                else if(i == j) {
                    dp[i][j] = 1;
                }
                else if(str[i] == str[j]){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];

    }

// 2. 记忆化搜索
//dfs(i, j):从s[i] 到 s[j] 的最长回文子序列的长度
    int dfs(int i, int j, char[] str, int[][] memo){
        if(i == j) {
            return 1;
        }
        else if(i > j) {
            return 0;
        }
        else if (memo[i][j] != -1){
            return memo[i][j];
        }
        else if(str[i] == str[j]) {
            return memo[i][j] = 2 + dfs(i + 1, j - 1, str, memo);
        }
        else return memo[i][j] = Math.max(dfs(i + 1, j, str, memo), dfs(i, j - 1, str, memo));

    } */
}
// @lc code=end


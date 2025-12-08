/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */


import java.util.Arrays;
//1. 记忆化搜索
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int memo[][] = new int [n][2];
        for(int i = 0; i < n; ++i){
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, 0, memo, prices);

    }
    int dfs(int i, int hold, int[][] memo, int[] prices) {
        if(i < 0) {
            if(hold == 1) {
                return Integer.MIN_VALUE / 2;
            }
            return 0;
        }
        if(memo[i][hold] != -1) {
            return memo[i][hold];
        }
        if(hold == 1) {
            return memo[i][hold] = Math.max(dfs(i - 1, 1, memo, prices), dfs(i - 1, 0, memo, prices) - prices[i]);
        }
        return memo[i][hold] = Math.max(dfs(i - 1, 1, memo, prices) + prices[i], dfs(i - 1, 0, memo, prices));
    }
}

//2. 递推
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]: 空仓, dp[i][1]: 持仓
        int[][] dp = new int[n][2];
        dp[0][0] = 0;          // 没买，利润 0
        dp[0][1] = -prices[0]; // 买了，利润为负
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
// @lc code=end


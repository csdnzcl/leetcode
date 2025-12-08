/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 买卖股票的最佳时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 */

// @lc code=start
//1. 记忆化搜索
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] cache = new int[n][3];
        for(int i = 0; i < n; ++i) {
            Arrays.fill(cache[i], -1);
        }
        //state:  0:空仓， 1：持仓   2；冷冻期(昨天卖出)
        //第 i - 1 天结束时，处于 state 这种状态下，也就是从第 0 天到第 i 天所能累积获得的【最大利润】。
        return Math.max( dfs(n - 1, 0, cache, prices),dfs(n - 1, 2, cache, prices));
    }
    
    int dfs(int i, int state, int[][] cache, int[] prices) {
        if(i < 0) {
            if(state == 0 || state == 2) return 0;
            if(state == 1) return Integer.MIN_VALUE / 2;
        }
        if(cache[i][state] != -1) return cache[i][state];
        if(state == 2) {
            return cache[i][state] = dfs(i - 1, 1, cache, prices) + prices[i];
        }
        else if(state == 0){
            return cache[i][state] = Math.max (
                dfs(i - 1, 0, cache, prices), 
                dfs(i - 1, 2, cache, prices)
            );
        }
        else  {
            return cache[i][state] = Math.max(
                dfs(i - 1, 0, cache, prices) - prices[i], 
                dfs(i - 1, 1, cache, prices)
            );
        }
    }
}

//2. 状态机DP
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        //dp[i][0]:空仓   dp[i][1] :持仓   dp[i][2] :冷冻期
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = Integer.MIN_VALUE / 2;
        for(int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
    
}
// @lc code=end


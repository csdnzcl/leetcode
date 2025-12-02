/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] cache = new int[n][amount + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }

        int ans = dfs(n - 1, amount, coins, cache);
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    private int dfs(int i, int c, int[] coins, int[][] cache) {
        if(i < 0) {
            return c == 0 ? 0 : Integer.MAX_VALUE / 2;
        }
        if(cache[i][c] != -1) {
            return cache[i][c];
        }
        if(coins[i] > c) {
            return cache[i][c] = dfs(i - 1, c, coins, cache);
        }
        return Math.min (dfs(i - 1, c, coins, cache), dfs(i, c - coins[i], coins, cache) + 1);
    }
}

/* 
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if(coins[0] > amount) {
            return -1;
        }
        int m = amount + 1;
        // dp[j] 定义：凑满容量 j 有多少种方法
        int[] dp = new int[m + 1];
        dp[coins[0]] = 1;
//注意遍历方向：
        for (int num : coins) {
            for (int j = amount; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[amount]; 
    }
} */
// @lc code=end

       /*  if (i < 0) {
            return c == 0 ? 0 : Integer.MAX_VALUE / 2; // 除 2 防止下面 + 1 溢出
        }
        if (cache[i][c] != -1) { // 之前计算过
            return cache[i][c];
        }
        if (c < coins[i]) { // 只能不选
            return cache[i][c] = dfs(i - 1, c, coins, cache);
        }
        // 不选 vs 继续选
        return cache[i][c] = Math.min(dfs(i - 1, c, coins, cache),
         dfs(i, c - coins[i], coins, cache) + 1); */
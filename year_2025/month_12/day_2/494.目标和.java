/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start

// 1. 记忆化搜索
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        sum -= Math.abs(target);
        if(sum < 0 || sum % 2 == 1) {
            return 0;
        }
        sum /= 2;
//cache[i][c] != -1,则dfs(i,c) = cache[i][c]:dfs(i, c):只使用数组中下标为 0 到 i 的这些物品，
// 把容量 c 填满，有多少种方法？
        int[][] cache = new int[n][sum + 1];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(n - 1, sum, nums, cache);
    }

    private int dfs(int i, int c, int[] nums, int[][] cache) {
        if(i < 0) {
            return c == 0 ? 1 : 0;
        }
        if(cache[i][c] != -1) {
            return cache[i][c];
        }
        int ans = dfs(i - 1, c, nums, cache);//不选第i个数
        if(c >= nums[i]) {
            ans += dfs(i - 1, c - nums[i], nums, cache);//选第i个数
        }
        return cache[i][c] = ans;
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        sum -= Math.abs(target);
        if(sum < 0 || sum % 2 == 1) {
            return 0;
        }
        int m = sum / 2;
        int dp[][] = new int[n + 1][m + 1];
        //dp[i][j] 定义：从前 i 个物品中选，凑出容量 j 的方法数
        for(int[] a : dp){
            Arrays.fill(a, 0);
        }
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1]; 
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][m];
    }
}

//3. 空间优化：使用一维数组---因为dp[i][……]之和dp[i-1][……]相关
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;
        sum -= Math.abs(target);
        if (sum < 0 || sum % 2 == 1) return 0;
        int m = sum / 2;
        // dp[j] 定义：凑满容量 j 有多少种方法
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = m; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[m];
    }
}
// @lc code=end


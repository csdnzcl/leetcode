/*
 * @lc app=leetcode.cn id=1039 lang=java
 *
 * [1039] 多边形三角剖分的最低得分
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，
 * 其中 values[i] 是按 顺时针顺序 第 i 个顶点的值。
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，
 * 三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 * 
 * 提示：
 * n == values.length
 * 3 <= n <= 50
 * 1 <= values[i] <= 100
 */

// @lc code=start

//1. 递推
class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; --i) {
            for(int j = 0; j < n; ++j){
                int num = j - i;
                if(num <= 1)
                    dp[i][j] = 0;
                else{
                    int min = Integer.MAX_VALUE / 2;
                    for(int k = i + 1; k < j; ++k) {
                        int sum = values[i] * values[k] * values[j];
                        sum += dp[i][k] + dp[k][j];
                        min = Math.min(sum, min);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n - 1];
        
    }
//2. 记忆化搜索
    //dfs(i, j)：从i到j的最多得分
    int dfs(int i, int j, int[] values, int[][] memo) {
        int n = j - i;
        if(n == 1) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int min = Integer.MAX_VALUE / 2;
        for(int k = i + 1; k < j; ++k) {
            int num = values[i] * values[j] * values[k];
            int sum = dfs(i, k, values, memo) + dfs(k, j, values, memo);
            sum += num;
            max = Math.min(min, sum);
        }
        return memo[i][j] = min;
    }
 */
}
// @lc code=end


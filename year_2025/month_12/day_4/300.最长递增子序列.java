/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxAns = 1;
        for(int i = 1; i < n; ++i) {
            for(int j = i - 1; j >= 0; --j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
// @lc code=end


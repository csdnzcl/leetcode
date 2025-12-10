/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。子数组 是数组中的一个连续部分。
 * 
 * 提示：
 *  1 <= nums.length <= 105
 *  -104 <= nums[i] <= 104
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxAns = dp[0];
        for(int i = 1; i < n; ++i) {
            if(dp[i - 1] <= 0){
                dp[i] = nums[i];
            }
            else{
                dp[i] = dp[i - 1] + nums[i];
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
// @lc code=end


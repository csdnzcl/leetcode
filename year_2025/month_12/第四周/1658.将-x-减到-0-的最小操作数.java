/*
 * @lc app=leetcode.cn id=1658 lang=java
 *
 * [1658] 将 x 减到 0 的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if(nums[0] > x && nums[n - 1] > x) {
            return -1;
        }
        int ans = -1, total = 0, left = 0;
        for(int a : nums) {
            total += a;
        }
        int tar = total - x;
        if(tar < 0) {
            return -1;
        }
        for(int i = 0; i < n; i++) {
            tar -= nums[i];
            while(tar < 0) {
                tar += nums[left];
                left++;
            }
            if(tar == 0) {
                ans = Math.max(ans, i - left + 1);
            }
        }
        return ans == -1 ? ans : n - ans;
    }
}
// @lc code=end


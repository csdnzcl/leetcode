/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE / 2, left = 0;
        for(int i = 0; i < n; ++i) {
            target -= nums[i];
            while(target <= 0) {
                ans = Math.min(ans, i - left + 1);
                target += nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE / 2 ? 0 : ans;
    }
}
// @lc code=end


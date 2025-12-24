/*
 * @lc app=leetcode.cn id=3634 lang=java
 *
 * [3634] 使数组平衡的最少移除数目
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            while((long)nums[left] * k < nums[i]) {
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return n - ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=2958 lang=java
 *
 * [2958] 最多 K 个重复元素的最长子数组
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        int left = 0, ans = 0;
        for(int i = 0; i < n; ++i) {
            hash.merge(nums[i], 1, Integer::sum);
            while(hash.get(nums[i]) > k) {
                hash.merge(nums[left], -1, Integer::sum);
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
// @lc code=end


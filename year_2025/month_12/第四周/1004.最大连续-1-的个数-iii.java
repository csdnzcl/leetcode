/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, sum = 0;
        int left = 0;
        for(int i = 0; i < n; ++i) {
            if(nums[i] == 0) {
                sum++;
            }
            while(sum > k) {
                if(nums[left++] == 0) {
                    sum--;
                }
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
// @lc code=end


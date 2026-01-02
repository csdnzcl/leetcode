/*
 * @lc app=leetcode.cn id=2389 lang=java
 *
 * [2389] 和有限的最长子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; ++i){
            sum[i] = sum[i - 1] + nums[i];
        }
        for(int i = 0; i < m; ++i) {
            int up = upperBound(sum, queries[i]);
            ans[i] = up;
        }
        return ans;
    }

    private int upperBound(int[] sum, int target){
        int left = 0, right = sum.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sum[mid] > target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            
        }
        return left;
    }
}
// @lc code=end


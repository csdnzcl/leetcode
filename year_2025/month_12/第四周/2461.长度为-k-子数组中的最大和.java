/*
 * @lc app=leetcode.cn id=2461 lang=java
 *
 * [2461] 长度为 K 子数组中的最大和
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, ans = 0;
        int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < n; ++i) {

            sum += nums[i];

            hash.merge(nums[i], 1, Integer::sum);//hash++;
            int left = i - k + 1;
            if(left < 0) {
                continue;
            }

            if(hash.size() == k) {
                ans = Math.max(ans, sum);
            }

            sum -= nums[left];
            int cnt = hash.get(nums[left]);
            if(cnt > 1) {
                hash.put(nums[left], cnt - 1);
            }else{
                hash.remove(nums[left]);
            }
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=2841 lang=java
 *
 * [2841] 几乎唯一子数组的最大和
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long maxSum(List<Integer> Nums, int m, int k) {
        Integer[] nums = Nums.toArray(Integer[]::new);
        Map<Integer, Integer> hash = new HashMap<>();
        int n = nums.length;
        long sum = 0;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            hash.merge(nums[i], 1, Integer::sum);
            int left = i - k + 1;
            if(left < 0) continue;
            if(hash.size() >= m) {
                ans = Math.max(ans, sum);
            }
            int tmp = nums[left];
            sum -= tmp;
            int c = hash.get(tmp);
            if(c > 1) {
                hash.put(tmp, c - 1);
            }else{
                hash.remove(tmp);
            }
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1695 lang=java
 *
 * [1695] 删除子数组的最大得分
 */

// @lc code=start


import java.util.HashMap;
import java.util.Map;

import org.xml.sax.HandlerBase;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
            hash.merge(nums[i], 1, Integer::sum);
            while(hash.get(nums[i]) > 1) {
                int tmp = nums[left];
                sum -= tmp;
                if(tmp == nums[i]){
                    hash.put(nums[i],1);
                }else{
                    hash.remove(tmp);
                }
                left++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
// @lc code=end


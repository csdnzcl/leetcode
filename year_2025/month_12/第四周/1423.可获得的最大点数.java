/*
 * @lc app=leetcode.cn id=1423 lang=java
 *
 * [1423] 可获得的最大点数
 */

// @lc code=start
/* class Solution {
    
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int leftSum = 0;
        for(int i = 0; i < k; ++i) {
            leftSum += nums[i];
        }
        int rightSum = 0, ans = leftSum;
        for(int i = 0; i < k; ++i) {
            leftSum -= nums[k - i - 1];
            rightSum += nums[n - i - 1];
            ans = Math.max(ans, leftSum + rightSum);
        }
        return ans;
    }
} */

class Solution{
    public int maxScore(int[] nums, int k) {
        int total = 0, min = Integer.MAX_VALUE / 2, sum = 0;
        int n = nums.length;
        int m = n - k;
        //增加m == 0---》窗口为0的情况
        if(m == 0) {
            int ans = 0;
            for(int a : nums) {
                ans += a;
            }
            return ans;
        }
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
            total += nums[i];
            int left = i - m + 1;
            if(left < 0) {
                continue;
            }
            min = Math.min(min, sum);
            sum -= nums[left];
        }
        if(m == 0) {
            return total;
        }
        return total - min;
    }
}
// @lc code=end


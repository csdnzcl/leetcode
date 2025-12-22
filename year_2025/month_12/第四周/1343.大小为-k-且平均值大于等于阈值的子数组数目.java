/*
 * @lc app=leetcode.cn id=1343 lang=java
 *
 * [1343] 大小为 K 且平均值大于等于阈值的子数组数目
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int ans = 0;
        int cnt = 0;
        int avg = 0;
        for(int i = 0; i < n; ++i) {
            avg += (arr[i] - threshold);
            int left = i - k + 1;
            if(left < 0) continue;
            if(avg >= 0) {
                ans++;
            }
            avg -= (arr[left] - threshold);
        }
        return ans;
    }
}
// @lc code=end


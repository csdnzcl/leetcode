/*
 * @lc app=leetcode.cn id=1208 lang=java
 *
 * [1208] 尽可能使字符串相等
 */

// @lc code=start
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int n = str1.length;
        int left = 0;
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            sum += Math.abs(str1[i] - str2[i]);
            while(sum > maxCost) {
                sum -= Math.abs(str1[left] - str2[left]);
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
// @lc code=end


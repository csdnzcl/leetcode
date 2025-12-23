/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, num = 0;
        int[] cnt = new int[128];
        char[] str = s.toCharArray();
        int n = str.length;
        int left = 0;
        for(int i = 0; i < n; i++){
            char tmp = str[i];
            cnt[tmp]++;
            while(cnt[tmp] > 1) {
                cnt[str[left]]--;
                ++left;
            }
            num = i - left + 1;
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
// @lc code=end


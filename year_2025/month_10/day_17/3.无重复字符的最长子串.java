/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度
 */

// @lc code=start


class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[] cnt = new int[128];
        int left = 0;
        int ans = 0;
        for(int right = 0; right < n; ++right) {
            char c = str[right];
            cnt[c]++;
            while(cnt[c] > 1){
                --cnt[str[left]];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end


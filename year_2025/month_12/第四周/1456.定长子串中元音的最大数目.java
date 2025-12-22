/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        int vowel = 0;
        for (int i = 0; i < n; i++) { // 枚举窗口右端点 i
            // 1. 入
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                vowel++;
            }

            int left = i - k + 1; // 窗口左端点
            if (left < 0) { // 窗口大小不足 k，尚未形成第一个窗口
                continue;
            }

            // 2. 更新
            ans = Math.max(ans, vowel);

            // 3. 出
            char out = s[left];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1234 lang=java
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedString(String S) {
        char[] s = S.toCharArray();
        int[] cnt = new int['X']; // new int[88]; 'X' = 88
        for (char c : s) {
            cnt[c]++;
        }

        int n = s.length;
        int m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0; 
        }

        int ans = n;
        int left = 0;
        for (int right = 0; right < n; right++) { 
            cnt[s[right]]--; // 注意 cnt 统计的是在子串 [left,right] 外面的字母个数
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                // 子串 [left,right] 满足要求
                ans = Math.min(ans, right - left + 1);
                cnt[s[left]]++; // 缩小子串，把 s[left] 放到外面
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end


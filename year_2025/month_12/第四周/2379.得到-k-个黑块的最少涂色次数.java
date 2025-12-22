/*
 * @lc app=leetcode.cn id=2379 lang=java
 *
 * [2379] 得到 K 个黑块的最少涂色次数
 */

// @lc code=start
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE / 2;
        char[] str = blocks.toCharArray();
        int n = str.length;
        int cnt = 0;
        for(int i = 0; i < n; ++i) {
            if(str[i] == 'W') {
                cnt++;
            }
            int left = i - k + 1;
            if(left < 0) continue;

            min = Math.min(min, cnt);

            if(str[left] == 'W') {
                cnt--;
            }
        }
        return min;
    }
}
// @lc code=end


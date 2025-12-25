/*
 * @lc app=leetcode.cn id=2024 lang=java
 *
 * [2024] 考试的最大困扰度
 */

// @lc code=start

//1. Myself
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] str = answerKey.toCharArray();
        int n = str.length;
        int[] left = new int[2];
        int ans = 0;
        int[] sum = new int[2];
        for(int i = 0; i < n; ++i) {
            if(str[i] == 'F') {
                sum[0]++;
            }
            else{
                sum[1]++;
            }
            while(sum[0] > k) {
                if(str[left[0]++] == 'F') {
                    sum[0]--;
                }
            }
            while(sum[1] > k) {
                if(str[left[1]++] == 'T') {
                    sum[1]--;
                }
            }
            ans = Math.max(ans, i - left[0] + 1);
            ans = Math.max(ans, i - left[1] + 1);
        }
        return ans;
    }
}

//2. 灵神：
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] s = answerKey.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[2];
        for (int right = 0; right < s.length; right++) {
            cnt[s[right] >> 1 & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[left] >> 1 & 1]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1170 lang=java
 *
 * [1170] 比较字符串最小字母出现频次
 */

// @lc code=start
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int m = words.length;
        int[] ans = new int[n];
        int[] words_f = new int[m];
        for(int i = 0; i < m; ++i){
            char[] str = words[i].toCharArray();
            words_f[i] = f(str);
        }
        Arrays.sort(words_f);
        for(int i = 0; i < n; ++i) {
            int target = f(queries[i].toCharArray());
            int left = upperBound(words_f, target);
            if(left != m) {
                ans[i] = m - left;
            }
        }
        return ans;
    }

    private int f(char[] str){
        Arrays.sort(str);
        int num = 1;
        for(int i = 1; i < str.length; ++i) {
            if(str[i] == str[0]) {
                num++;
            }else{
                break;
            }
        }
        return num;
    }

    private int upperBound(int[] potions, int target){
        int left = 0, right = potions.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(potions[mid] > target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}

//优化：
//把 words 的 f 值预处理成「频率数组」+「后缀和」即可，将二分查找换成 O(1) 查表
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] cnt = new int[27];          // 1..26
        for (String w : words) {
            int fw = f(w.toCharArray());
            cnt[fw]++;
        }
        // 后缀和：suffix[i] = 有多少个 word 的 f 值 ≥ i
        int[] suffix = new int[28];
        for (int i = 26; i >= 1; i--) {
            suffix[i] = suffix[i + 1] + cnt[i];
        }

        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int qf = f(queries[i].toCharArray());
            ans[i] = suffix[qf + 1];      // 严格大于
        }
        return ans;
    }

    // 计算 f(w)
    private int f(char[] s) {
        Arrays.sort(s);
        char min = s[0];
        int c = 1;
        for (int i = 1; i < s.length && s[i] == min; i++) c++;
        return c;
    }
}
// @lc code=end


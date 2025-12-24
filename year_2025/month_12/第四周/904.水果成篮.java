/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < n; i++) {
            cnt.merge(fruits[i], 1, Integer::sum); // fruits[right] 进入窗口
            while(cnt.size() > 2) {
                int count = cnt.get(fruits[left]);
                if(count > 1) {
                    cnt.put(fruits[left], count - 1);
                }else{
                    cnt.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
// @lc code=end


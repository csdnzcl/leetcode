/*
 * @lc app=leetcode.cn id=2300 lang=java
 *
 * [2300] 咒语和药水的成功对数
 */

// @lc code=start
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int n = spells.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i) {
            long s = spells[i];
            long minP = (success + s - 1) / s;   // 向上取整的整数写法
            int left = lowerBound(potions, minP);
            if(left != m){
                ans[i] = m - left;
            }
        }
        return ans;
    }

    private int lowerBound(int[] potions, long target){
        int left = 0, right = potions.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(potions[mid] >= target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start

//1. myself：
class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, num = 0;
        int n = nums.length;
        int left = 0;
        int flag = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 1){
                flag++;
            }
            while(flag > 1) {
                if(nums[left] != 1) {
                    flag--;
                }
                left++;
            }
            if(flag == 0){
                num = i - left + 1;
            }else{
                num = i - left;
            }
            ans = Math.max(ans, num);
        }
        return ans == n ? n - 1: ans;
    }
}

//2.灵神：
class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int cnt0 = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 1. 入，nums[right] 进入窗口
            cnt0 += 1 - nums[right]; // 维护窗口中的 0 的个数
            while (cnt0 > 1) { // 不符合题目要求
                // 2. 出，nums[left] 离开窗口
                cnt0 -= 1 - nums[left]; // 维护窗口中的 0 的个数
                left++;
            }
            // 3. 更新答案，注意不是 right-left+1，因为我们要删掉一个数
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
// @lc code=end


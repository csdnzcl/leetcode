/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; ++i) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            int left = i - k + 1;
            if(deque.getFirst() < left) {
                deque.removeFirst();
            }
            if(left >= 0) {
                ans[left] = nums[deque.getFirst()];
            }
        }
        return ans;
        
    }
}
// @lc code=end


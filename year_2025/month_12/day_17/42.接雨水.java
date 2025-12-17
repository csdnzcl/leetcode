/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; ++i) {
            int high = height[i];
            while(!stack.isEmpty() && high >= height[stack.peek()]) {
                int j = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                sum += (i - left - 1) * (Math.min(height[left], high) - height[j]);
            }
            stack.push(i);
        }
        return sum;
    }
}
// @lc code=end


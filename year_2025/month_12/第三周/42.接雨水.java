/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
//1. 前后缀分解
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n]; // preMax[i] 表示从 height[0] 到 height[i] 的最大值
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        int[] sufMax = new int[n]; // sufMax[i] 表示从 height[i] 到 height[n-1] 的最大值
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i]; // 累加每个水桶能接多少水
        }
        return ans;
    }
}

//2. 相向双指针
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int preMax = 0; // 前缀最大值，随着左指针 left 的移动而更新
        int sufMax = 0; // 后缀最大值，随着右指针 right 的移动而更新
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                ans += preMax - height[left];
                left++;
            } else {
                ans += sufMax - height[right];
                right--;
            }
        }

        return ans;
    }
}

//3. 单调栈
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


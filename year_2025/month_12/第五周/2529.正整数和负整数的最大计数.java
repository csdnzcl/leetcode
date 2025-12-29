/*
 * @lc app=leetcode.cn id=2529 lang=java
 *
 * [2529] 正整数和负整数的最大计数
 */

// @lc code=start
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length - 1;
        int r = upperBound(nums, 0);
        int pos = n - r + 1;
        int l = upperBound(nums, -1);
        int neg = l;
        return Math.max(pos, neg);
        
    }

    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
        
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end


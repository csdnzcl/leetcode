/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = lowerBound(nums, target);
        if (left == n || nums[left] != target) {
            return new int[]{-1, -1}; // nums 中没有 target
        }
        int right = lowerBound(nums, target + 1);
        return new int[] {left, right - 1};
    }

    public static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
    
        while (left < right) {
            int mid = left + (right - left) / 2;
        
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
    }
    
    return left;  // 如果所有元素都小于target，返回arr.length
    }

}
// @lc code=end


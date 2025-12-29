/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        return lowerBound(nums, target);
        
    }

    private int lowerBound(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1; // 闭区间 [left, right]
    while (left <= right) { // 区间不为空
    
        int mid = left + (right - left) / 2;
        if (nums[mid] >= target) {
            right = mid - 1; // 范围缩小到 [left, mid-1]
        } else {
            left = mid + 1; // 范围缩小到 [mid+1, right]
        }
    }
    // 循环结束后 left = right+1
    // 此时 nums[left-1] < target 而 nums[left] = nums[right+1] >= target
    // 所以 left 就是第一个 >= target 的元素下标
    return left;
}

}
// @lc code=end


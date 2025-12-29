/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = upperBound(letters, target);
        if(left == letters.length) {
            return letters[0];
        }
        return letters[left];
    }

    private int upperBound(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(letters[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end


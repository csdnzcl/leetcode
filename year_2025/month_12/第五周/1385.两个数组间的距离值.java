/*
 * @lc app=leetcode.cn id=1385 lang=java
 *
 * [1385] 两个数组间的距离值
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        int n = arr1.length;
        Arrays.sort(arr2);
        for(int i = 0; i < n; ++i) {
            int low = BinaryFind(arr2, arr1[i] - d);
            int up = BinaryFind(arr2, arr1[i] + d + 1);
            if(low == up) {
                ans++;
            }
        }
        return ans;
    }
    
    private int BinaryFind(int[] arr2, int target) {
        int left = 0, right = arr2.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr2[mid] >= target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }



//朴素做法：
    /* public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        int n1 = arr1.length, n2 = arr2.length;
        for(int i = 0; i < n1; ++i) {
            int tmp = arr1[i];
            boolean flag = true;
            for(int j = 0; j < n2; ++j) {
                if(Math.abs(tmp - arr2[j]) <= d) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }
        return ans;
    } */
}
// @lc code=end


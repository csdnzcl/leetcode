/*
 * @lc app=leetcode.cn id=2090 lang=java
 *
 * [2090] 半径为 k 的子数组平均值
 * 给你一个下标从 0 开始的数组 nums ，数组中有 n 个整数，另给你一个整数 k 。半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。构建并返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值 。x 个元素的 平均值 是 x 个元素相加之和除以 x ，此时使用截断式 整数除法 ，即需要去掉结果的小数部分。例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75，截断后得到 2 。
 */

// @lc code=start
//1. 我写的
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        if(n < 2 * k + 1) {
            return ans;
        }
        long sum = 0;
        for(int i = 0; i < n; ++i) {
            sum += (long)nums[i];
            int left = i - 2 * k;
            if(left < 0) {
                continue;
            }
            long tmp = sum / (long) (2 * k + 1);
            ans[i - k] = (int) tmp;
            sum -= (long)nums[left];
        }
        return ans;
    }
}

//2. 灵神写的：
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1);
        long s = 0; // 维护窗口元素和（注意类型！）
        for (int i = 0; i < n; i++) {
            // 1. 进入窗口
            s += nums[i];
            if (i < k * 2) { // 窗口大小不足 2k+1
                continue;
            }
            // 2. 记录答案
            avgs[i - k] = (int) (s / (k * 2 + 1));
            // 3. 离开窗口
            s -= nums[i - k * 2];
        }
        return avgs;
    }
}
// @lc code=end


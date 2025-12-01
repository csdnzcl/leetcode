/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int[] visited = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0, n, nums, visited, path, ans);
        return ans;
    }
    private void dfs(int i, int maxDepth, int[] nums, int[] visited, 
        List<Integer> path, List<List<Integer>> ans){
        if(i == maxDepth) {
            ans.add(new ArrayList(path));
            return ;
        }
        for(int j = 0; j < maxDepth; ++j) {
            if(visited[j] == 0){
                visited[j] = 1;
                path.add(nums[j]);
                dfs(i+1, maxDepth, nums, visited, path, ans);
                visited[j] = 0;
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end

/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

提示：
1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
*/
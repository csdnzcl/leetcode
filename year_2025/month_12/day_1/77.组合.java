/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start

import java.util.ArrayList;
/* 
1. 正向剪枝
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(1, n, k, ans, path);
        return ans;
        
    }
    void dfs(int i, int n, int k, List<List<Integer>> ans, List<Integer> path){
        if(path.size() == k){
            ans.add(new ArrayList(path));
            return;
        }
        for(int j = i; j <= n - (k - path.size()) + 1; ++j) {
            path.add(j);
            dfs(j + 1, n, k, ans, path);
            path.remove(path.size() - 1);
        }
    }
} */
//2. 逆向剪枝
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, path, ans); // 从 i=n 开始倒着枚举，这样 dfs 中就不需要 n 了，少传一个参数
        return ans;
    }

    private void dfs(int i, int k, List<Integer> path, List<List<Integer>> ans) {
        int d = k - path.size(); // 还要选 d 个数
        if (d == 0) { // 选好了
            ans.add(new ArrayList<>(path));
            return;
        }
        // 枚举的数不能太小，否则后面没有数可以选
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, k, path, ans);
            path.removeLast(); // path.remove(path.size() - 1);
        }
    }
}

// @lc code=end

/* 
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。

示例 1：
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

提示：
1 <= n <= 20
1 <= k <= n
 */
/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(9, k, n, path, ans);
        return ans;
    }

     private void dfs(int i, int k, int sub, List<Integer> path, List<List<Integer>> ans) {
        if(path.size() == k) {
            if(sub == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        //第一个剪枝：
        int num = k - path.size();
        int max = (i + i - num + 1) * num / 2;
        if(sub > max){
            return;
        }
        for(int j = i; j >= 1; --j) {
            //第二个剪枝
            if(sub < 0){
                continue;
            }
            path.add(j);
            dfs(j - 1, k, sub - j, path, ans);
            path.remove(path.size() - 1);
        }
     }
}
// @lc code=end
/* 
找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
- 只使用数字1到9
- 每个数字 最多使用一次 
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]
解释:
1 + 2 + 4 = 7
没有其他符合的组合了。

提示:
2 <= k <= 9
1 <= n <= 60
 */
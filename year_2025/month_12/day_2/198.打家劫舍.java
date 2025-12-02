/* 
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约
因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，
计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1：

输入：[1,2,3,1]
输出：4

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
/* 1. 记忆化搜索
class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums.length - 1, nums,cache);
        
    }

    private int dfs(int i, int[] nums, int[] cache) {
        if(i < 0) {
            return 0;
        }
        if(cache[i] != -1){
            return cache[i];
        }
        int ans =  Math.max(dfs(i-1,nums,cache), dfs(i - 2, nums,cache) + nums[i]);
        cache[i] = ans;
        return ans;
    }
} */

//2. 转为递推---自底向上
/* class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] f = new int[n];
        Arrays.fill(f,0);
        f[0] = nums[0];
        f[1] = Math.max(f[0], nums[1]);
        for(int i = 2; i < n; ++i) {
            f[i] = Math.max(f[i-1], f[i-2] + nums[i]);
        }
        return f[n-1];
    }
} */

//3. 空间优化：O(n) --> O(1)
class Solution{
    public int rob(int[] nums) {
        int n = nums.length;
        int f0 = 0, f1 = 0, newF = 0;
        for(int i = 0; i < n; ++i) {
            newF = Math.max(f0 + nums[i], f1);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
// @lc code=end


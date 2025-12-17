/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 * 题目：
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */

// @lc code=start
//1. 暴力遍历
/*
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        ans[n - 1] = 0;
        int[][] max = new int[n][2];
        for(int i = 0; i < n; ++i) {
            max[i][0] = i;
            max[i][1] = temperatures[i];
        }
        for(int i = n - 2; i >= 0; --i) {
            for(int j = i + 1; j < n; ++j){
                if(temperatures[i] < max[j][1]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}
*/

//2. 单调栈---栈中存储下标，减少空间浪费
import java.util.Stack;

class Solution{
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        Stack<Integer> sta = new Stack<>();
        sta.push(n - 1);
        for(int i = n - 2; i >= 0; --i) {
            int t = temperatures[i];
            while(!sta.isEmpty() && t >= temperatures[sta.peek()]){
                sta.pop();
            }
            if(!sta.isEmpty()) { 
                ans[i] = sta.peek() - i;
            }
            else{
                ans[i] = 0;
            }
            sta.push(i);
        }
        return ans;
    }
} 

//3. 从左到右遍历：
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        Stack<Integer> sta = new Stack<>();
        for(int i = 0; i < n; ++i) {
            int t = temperatures[i];
            while(!sta.isEmpty() && t > temperatures[sta.peek()]) {
                int j = sta.pop();
                ans[j] = i - j;
            }
            sta.push(i);
        }
        return ans;
    }
}
// @lc code=end


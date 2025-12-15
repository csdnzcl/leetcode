/*
 * @lc app=leetcode.cn id=2246 lang=java
 *
 * [2246] 相邻字符不同的最长路径
 * 给你一棵 树（即一个连通、无向、无环图），根节点是节点 0 ，这棵树由编号从 0 到 n - 1 的 n 个节点组成。
 * 用下标从 0 开始、长度为 n 的数组 parent 来表示这棵树，
 * 其中 parent[i] 是节点 i 的父节点，由于节点 0 是根节点，所以 parent[0] == -1 。
 * 另给你一个字符串 s ，长度也是 n ，其中 s[i] 表示分配给节点 i 的字符。
 * 请你找出路径上任意一对相邻节点都没有分配到相同字符的 最长路径 ，并返回该路径的长度。
 */
// @lc code=start
class Solution {
    private List<Integer>[] g;
    private char[] s;
    private int ans;

    public int longestPath(int[] parent, String s) {
        this.s = s.toCharArray();
        int n = parent.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);//g[i]存储第i个结点邻居
        }
        dfs(0);
        return ans + 1;//节点数 = 边数 + 1
    }

    int dfs(int x){
        int maxLen = 0;
        for(int y : g[x]){
            int y_len = dfs(y) + 1;
            if(s[x] != s[y]){
                ans = Math.max(ans, maxLen + y_len);
                maxLen = Math.max(maxLen, y_len);
            }
        }
        return maxLen;
    }
}
// @lc code=end
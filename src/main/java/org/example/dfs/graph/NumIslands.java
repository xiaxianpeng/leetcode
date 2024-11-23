package org.example.dfs.graph;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * https://leetcode.cn/problems/number-of-islands/description/
 * Created on 2024/11/7 20:28
 */
public class NumIslands {

    /**
     * 使用深度优先搜索（DFS）方法计算岛屿数量。
     * 遍历整个网格，当遇到'1'时，使用DFS将整个岛屿置为'0'，并计数。
     *
     * @param grid 二维字符数组表示的网格
     * @return 岛屿的数量
     */
    public static int numIslands(char[][] grid) {
        int count = 0;// 记录岛屿数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {// 发现新岛屿
                    dfs(grid, i, j);
                    count++;
                    System.out.println("Island count: " + count);
                }
            }
        }
        return count;
    }

    /**
     * 使用DFS方法遍历并标记整个岛屿。
     *
     * @param grid 二维字符数组表示的网格
     * @param i    当前行索引
     * @param j    当前列索引
     */
    private static void dfs(char[][] grid, int i, int j) {
        // 检查当前索引[i, j]是否在网格的有效范围内且为陆地
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;// 越界或遇到水时终止搜索
        }
        grid[i][j] = '0';// 标记为已访问，防止重复搜索
        System.out.println("Visiting and marking: (" + i + ", " + j + ")");

        // 递归搜索相邻的上下左右节点
        // 上
        dfs(grid, i - 1, j);
        // 下
        dfs(grid, i + 1, j);
        // 左
        dfs(grid, i, j - 1);
        // 右
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }
}

package org.example.graph.dfs;

/**
 * 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * 示例 1：
 * 输入：grid = [
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * ]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * Created on 2024/12/19 22:26
 */
public class MaxAreaOfIsland {

    /**
     * 计算网格中最大的岛屿面积
     * 使用dfs来遍历每个岛屿并计算面积
     *
     * @param grid 二进制矩阵，表示地图
     * @return 最大岛屿的面积
     */
    public static int maxAreaOfIsland(int[][] grid) {
        // 如果grid为空返回0
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;// 存储岛屿最大面积
        int m = grid.length;// 行数
        int n = grid[0].length;// 列数

        // 遍历grid中的每个位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前是陆地且未被访问过
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);//计算以(i,j)为起点的岛屿面积
                    maxArea = Math.max(maxArea, area);//更新最大岛屿面积
                }
            }
        }

        return maxArea;
    }

    /**
     * dfs，计算当前岛屿的面积
     *
     * @param grid 二进制矩阵，表示地图
     * @param i    当前行索引
     * @param j    当前列索引
     * @return 当前岛屿的面积
     */
    private static int dfs(int[][] grid, int i, int j) {
        // 如果当前位置超过网格，或者已经是水，返回面积0
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] == 0) {
            return 0;
        }
        // 标记当前位置是水，表示已经访问过
        grid[i][j] = 0;

        // 向上下左右方向进行dfs
        int area = 1;
        area += dfs(grid, i - 1, j);// 上
        area += dfs(grid, i + 1, j);// 下
        area += dfs(grid, i, j - 1);// 左
        area += dfs(grid, i, j + 1);// 右
        return area;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid1));  // 输出: 6

        int[][] grid2 = {
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid2));  // 输出: 0
    }

}

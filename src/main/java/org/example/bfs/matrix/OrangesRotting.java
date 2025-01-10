package org.example.bfs.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，
 * 每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。
 * 如果不可能，返回 -1 。
 * 示例 1：
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * Created on 2025/1/10 16:38
 */
public class OrangesRotting {

    /**
     * 使用BFS方法模拟腐烂橘子的传播过程
     *
     * @param grid 二位整数数组，表示橘子的状态
     * @return 所需的最小分钟数，如果不可能返回-1
     */
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;// 网格为空或无效
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        // 遍历网格，初始化腐烂橘子队列和新鲜橘子计数
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        // 如果没有新鲜橘子，返回0
        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        // 定义上下左右四个方向
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 开始bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // 检查4个方向
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // 如果新位置在网格内且是新橘子
                    if (newRow >= 0 && newRow < rows // 行边界
                            && newCol >= 0 && newCol < cols // 列边界
                            && grid[newRow][newCol] == 1) { // 新鲜橘子

                        grid[newRow][newCol] = 2;//标记为腐烂
                        freshOranges--;
                        queue.offer(new int[]{newRow, newCol});
                        rottenThisMinute = true;

                    }
                }
            }

            if (rottenThisMinute) {
                minutes++;
            }
        }

        // 检查是否所有新鲜橘子都已腐烂
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(Arrays.deepToString(grid1));
        System.out.println(orangesRotting(grid1)); // 输出: 4

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(Arrays.deepToString(grid2));
        System.out.println(orangesRotting(grid2)); // 输出: -1

        int[][] grid3 = {
                {0, 2}
        };
        System.out.println(Arrays.deepToString(grid3));
        System.out.println(orangesRotting(grid3)); // 输出: 0
    }
}

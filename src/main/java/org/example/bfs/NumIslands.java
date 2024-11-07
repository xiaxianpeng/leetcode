package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * * 200. 岛屿数量
 * * https://leetcode.cn/problems/number-of-islands/description/
 * * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * * 此外，你可以假设该网格的四条边均被水包围。
 * * 示例 1：
 * * 输入：grid = [
 * * ["1","1","1","1","0"],
 * * ["1","1","0","1","0"],
 * * ["1","1","0","0","0"],
 * * ["0","0","0","0","0"]
 * * ]
 * * 输出：1
 * * 示例 2：
 * * 输入：grid = [
 * * ["1","1","0","0","0"],
 * * ["1","1","0","0","0"],
 * * ["0","0","1","0","0"],
 * * ["0","0","0","1","1"]
 * * ]
 * Created on 2024/11/7 21:57
 */
public class NumIslands {

    /**
     * 思路二：广度优先遍历 BFS
     * 主循环和思路一类似，不同点是在于搜索某岛屿边界的方法不同。
     * bfs 方法：
     * 借用一个队列 queue，判断队列首部节点 (i, j) 是否未越界且为 1：
     * 若是则置零（删除岛屿节点），并将此节点上下左右节点 (i+1,j),(i-1,j),(i,j+1),(i,j-1) 加入队列；
     * 若不是则跳过此节点；
     * 循环 pop 队列首节点，直到整个队列为空，此时已经遍历完此岛屿。
     * 链接：https://leetcode.cn/problems/number-of-islands/solutions/16884/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/
     */
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            i = cur[0];
            j = cur[1];
            if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                // 上
                queue.add(new int[]{i - 1, j});
                // 下
                queue.add(new int[]{i + 1, j});
                // 左
                queue.add(new int[]{i, j - 1});
                // 右
                queue.add(new int[]{i, j + 1});
            }
        }
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

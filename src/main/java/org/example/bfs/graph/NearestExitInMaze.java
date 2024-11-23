package org.example.bfs.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. 迷宫中离入口最近的出口
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。
 * 同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。
 * 你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 * 示例 1：
 * 输入：maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * 输出：1
 * 解释：总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
 * 一开始，你在入口格子 (1,2) 处。
 * - 你可以往左移动 2 步到达 (1,0) 。
 * - 你可以往上移动 1 步到达 (0,2) 。
 * 从入口处没法到达 (2,3) 。
 * 所以，最近的出口是 (0,2) ，距离为 1 步。
 * 示例 2：
 * 输入：maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * 输出：2
 * 解释：迷宫中只有 1 个出口，在 (1,2) 处。
 * (1,0) 不算出口，因为它是入口格子。
 * 初始时，你在入口与格子 (1,0) 处。
 * - 你可以往右移动 2 步到达 (1,2) 处。
 * 所以，最近的出口为 (1,2) ，距离为 2 步。
 * 示例 3：
 * 输入：maze = [[".","+"]], entrance = [0,0]
 * 输出：-1
 * 解释：这个迷宫中没有出口。
 * 链接：https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 18:39
 */
public class NearestExitInMaze {

    /**
     * 使用广度优先搜索（BFS）寻找从入口到最近出口的最短路径。
     * 利用队列进行逐层搜索，记录每一步的距离。
     *
     * @param maze     迷宫矩阵。
     * @param entrance 入口位置。
     * @return 到最近出口的最短路径的步数，如果不存在返回-1。
     */
    public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});// {行，列，步数}
        maze[entrance[0]][entrance[1]] = '+';// 标记入口位置为已访问

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int steps = cur[2];
            System.out.println("Visiting (" + x + ", " + y + "), Steps: " + steps);

            // 检查4个方向
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // 检查新位置的有效性
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == '.') {
                    // 如果新位置在边界且不是入口，则为出口
                    if (newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) {
                        System.out.println("Exit found at (" + newX + ", " + newY + "), Steps: " + (steps + 1));
                        return steps + 1;
                    }
                    // 否则继续搜索
                    maze[newX][newY] = '+';// 标记为已访问
                    queue.offer(new int[]{newX, newY, steps + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // 示例测试用例1
        char[][] maze1 = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance1 = {1, 2};
        System.out.println("Shortest Path to Exit: " + nearestExit(maze1, entrance1)); // 输出: 1

        // 示例测试用例2
        char[][] maze2 = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        int[] entrance2 = {1, 0};
        System.out.println("Shortest Path to Exit: " + nearestExit(maze2, entrance2)); // 输出: 2

        // 示例测试用例3
        char[][] maze3 = {
                {'.', '+'}
        };
        int[] entrance3 = {0, 0};
        System.out.println("Shortest Path to Exit: " + nearestExit(maze3, entrance3)); // 输出: -1
    }
}

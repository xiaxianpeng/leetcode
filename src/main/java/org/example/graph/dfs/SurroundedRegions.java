package org.example.graph.dfs;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，
 * 由若干字符 'X' 和 'O' 组成，
 * 捕获 所有 被围绕的区域：
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果您可以用 'X' 单元格 连接这个区域，
 * 并且区域中没有任何单元格位于 board 边缘，
 * 则该区域被 'X' 单元格围绕。
 * 通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。
 * 示例 1：
 * 输入：board = [
 * ["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]
 * ]
 * 输出：[
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","O","X","X"]
 * ]
 * 解释：
 * 在上图中，底部的区域没有被捕获，
 * 因为它在 board 的边缘并且不能被围绕。
 * 示例 2：
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 */
public class SurroundedRegions {


    /**
     * 使用dfs标记被环绕的区域
     *
     * @param board 给定的字符矩阵
     * @return void
     * 算法思路：
     * 使用深度优先搜索（DFS）从边界的 'O' 开始标记所有与边界相连的 'O' 为安全区域（例如，标记为 'S'）。
     * 1. 遍历矩阵的边界（第一行、最后一行、第一列、最后一列），
     * 对于每个 'O'，执行 DFS，将其及其连通的 'O' 标记为 'S'。
     * 2. 遍历整个矩阵：
     * a. 将所有标记为 'S' 的字符恢复为 'O'。
     * b. 将剩余的 'O' 替换为 'X'，因为这些 'O' 被 'X' 围绕。
     */
    public static void solve(char[][] board) {
        // 如果矩阵为空，直接返回
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        System.out.println("原始矩阵：\n" + Arrays.deepToString(board));
        int rows = board.length;
        int cols = board[0].length;

        // 1、标记与边界相连的'O'为'S'
        // 遍历第一行和最后一行
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }
            if (board[rows - 1][col] == 'O') {
                dfs(board, rows - 1, col);
            }
        }
        // 遍历第一列和最后一列
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }
            if (board[row][cols - 1] == 'O') {
                dfs(board, row, cols - 1);
            }
        }

        System.out.println("标记完成矩阵：\n" + Arrays.deepToString(board));
        // 2、遍历整个矩阵，替换'O'为'X','S'恢复为'O'
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                if (board[row][col] == 'S') {
                    board[row][col] = 'O';
                }
            }
        }

        System.out.println("最终被围绕矩阵：\n" + Arrays.deepToString(board));
    }

    /**
     * 深度优先搜索（DFS）标记与边界相连的 'O' 为 'S'
     *
     * @param board 矩阵
     * @param row   当前行
     * @param col   当前列
     */
    private static void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != 'O') {
            return;
        }
        // 标记当前'O'为'S',表示安全区域
        board[row][col] = 'S';
        // 递归访问上下左右四个方向
        dfs(board, row - 1, col);// 上
        dfs(board, row + 1, col);// 下
        dfs(board, row, col - 1);// 左
        dfs(board, row, col + 1);// 右
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
    }
}

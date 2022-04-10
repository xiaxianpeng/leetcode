package org.example.array;

import java.util.Arrays;

/**
 * @author xianpeng.xia
 * on 2022/4/10 7:52 PM
 *
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 *
 * 示例 1：
 *
 *
 * 输入：board =
 * [
 * ["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]
 * ]
 * 输出：[
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","O","X","X"]]
 *
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *
 * https://leetcode-cn.com/problems/surrounded-regions/solution/bei-wei-rao-de-qu-yu-by-leetcode-solution/
 */
public class Solve {

    private static int n, m;

    public static void solveDSF(char[][] board) {
        //
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;

        // 对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O；
        // 把标记过的字母 O 修改为字母 A
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }

        for (int i = 0; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        //最后我们遍历这个矩阵，对于每一个字母：
        //如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
        //如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = board[i][j] == 'A' ? 'O' : 'X';
            }
        }
    }

    private static void dfs(char[][] board, int x, int y) {
        // 任何边界上的 O 都不会被填充为 X
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    public static void solveBFS(char[][] board) {

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        System.out.println(Arrays.deepToString(board));
        solveDSF(board);
        System.out.println(Arrays.deepToString(board));
    }
}

package org.example.dfs.matrix;

import java.util.Arrays;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * Created on 2024/12/15 15:56
 */
public class WordSearch {

    /**
     * 使用给定的单词是否可以在网格中找到
     * 使用dfs+回溯
     *
     * @param board 二维字符网格
     * @param word  要搜索的单词
     * @return 如果单词能在网格中找到返回true，否则返回false
     */
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // 遍历每个起点尝试开始搜索
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, 0, row, col, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从给定位置开始，深度优先搜索指定的单词
     *
     * @param board   字符网格
     * @param word    要搜索的单词
     * @param index   当前正在匹配的单词字符索引
     * @param row     当前索引的行
     * @param col     当前位置的列
     * @param visited 访问标记数组
     * @return 如果匹配返回true，否则返回false
     */
    private static boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            // 所有字符都匹配成功
            return true;
        }
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || visited[row][col]
                || board[row][col] != word.charAt(index)) {
            // 越界，已访问，字符不匹配
            return false;
        }
        visited[row][col] = true;

        // 向4个方向搜索
        boolean result = dfs(board, word, index + 1, row - 1, col, visited)//上
                || dfs(board, word, index + 1, row + 1, col, visited)//下
                || dfs(board, word, index + 1, row, col - 1, visited)//左
                || dfs(board, word, index + 1, row, col + 1, visited);//右

        visited[row][col] = false; // 回溯，撤销访问标记

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(Arrays.deepToString(board));

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(word1 + " exist :" + exist(board, word1));//true
        System.out.println(word2 + " exist :" + exist(board, word2));//true
        System.out.println(word3 + " exist :" + exist(board, word3));//false
    }
}

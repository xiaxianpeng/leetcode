package org.example.string.backtrack;

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
 */
public class WorldSearch {


    /**
     * 判断单词是否存在于给定的字符网格中。
     *
     * @param board 字符网格
     * @param word  待查找的单词
     * @return 如果单词存在于网格中则返回 true，否则返回 false
     */
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // 遍历网格中的每个位置作为起始点
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 辅助函数，通过回溯检查单词是否存在。
     *
     * @param board 字符网格
     * @param word  待查找的单词
     * @param row   当前行位置
     * @param col   当前列位置
     * @param index 当前匹配到的单词索引
     * @return 如果当前路径能匹配单词，返回 true，否则返回 false
     */
    private static boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // 如果索引等于单词长度，说明单词已经完全匹配
        if (index == word.length()) {
            return true;
        }

        // 检查当前位置是否越界或不匹配
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // 临时保存当前字符，并标记为访问过
        char temp = board[row][col];
        board[row][col] = '#';

        System.out.printf("Visiting: (%d, %d) - Matching: %c\n", row, col, temp);

        // 递归搜索上下左右四个方向
        boolean found = backtrack(board, word, row - 1, col, index + 1) //上
                || backtrack(board, word, row + 1, col, index + 1) //下
                || backtrack(board, word, row, col - 1, index + 1) //左
                || backtrack(board, word, row, col + 1, index + 1); //右

        // 回溯，恢复原状
        board[row][col] = temp;
        if (!found) {
            System.out.printf("Backtracking from: (%d, %d) - Restoring: %c\n", row, col, temp);
        }
        return found;
    }

    public static void main(String[] args) {

        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board1, "ABCCED")); // 输出: true

        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board2, "SEE")); // 输出: true

        char[][] board3 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board3, "ABCB")); // 输出: false
    }
}

package org.example.array;

/**
 * @author xianpeng.xia
 * on 2022/4/8 11:17 PM
 * 有效的数独
 *
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class IsValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        // 行
        int[][] rows = new int[9][9];
        // 列
        int[][] cols = new int[9][9];
        // 九宫格
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                // 处理数字
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    cols[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    // 如果重复返回false
                    if (rows[i][index] > 1 || cols[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
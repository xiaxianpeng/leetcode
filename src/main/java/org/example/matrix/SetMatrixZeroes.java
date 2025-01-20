package org.example.matrix;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，
 * 如果一个元素为 0 ，
 * 则将其所在行和列的所有元素都设为 0 。
 * 请使用 原地 算法。
 * 示例 1：
 * 输入：matrix = [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：[
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]]
 * 示例 2：
 * 输入：matrix = [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：[
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Created on 2024/11/27 17:30
 */
public class SetMatrixZeroes {

    /**
     * 使用原地算法将矩阵中的0所在的行和列置零。
     *
     * @param matrix 输入的二维矩阵
     * @return void
     * 算法思路：
     * 1、首先判断第一行和第一列是否包含0，记录下来
     * 2、使用第一行和第一列来标记需要置零的行和列
     * 3、遍历矩阵的每个元素，如果元素为0，则标记其所在行列的第一个元素为0
     * 4、根据标记，遍历矩阵将对应的行和列置为0
     * 5、第一行和第一列要单独处理，因为他们同时用作标记位置
     */
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // 判断第一行和第一列是否要置为0
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 检查第一行是否有零
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 检查第一列是否有零
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 使用第一行和第一列作为标记
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 从第二行和第二列开始，根据标记置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 如果第一行需要置零
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // 如果第一列需要置零
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix1);
        System.out.println("Output for matrix1: " + Arrays.deepToString(matrix1)); // 输出 [[1, 0, 1], [0, 0, 0], [1, 0, 1]]

        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix2);
        System.out.println("Output for matrix2: " + Arrays.deepToString(matrix2)); // 输出 [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
    }
}

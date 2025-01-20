package org.example.matrix;

import org.example.util.ArrayUtil;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。
 * 请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要 使用另一个矩阵来旋转图像。
 * 示例 1：
 * 输入：matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ]
 * 输出：[
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2：
 * 输入：matrix = [
 * [5,1,9,11],
 * [2,4,8,10],
 * [13,3,6,7],
 * [15,14,12,16]
 * ]
 * 输出：[
 * [15,13,2,5],
 * [14,3,4,1],
 * [12,6,8,9],
 * [16,7,10,11]
 * ]
 */
public class RotateMatrix {

    /**
     * 旋转图像,顺时针旋转90度
     *
     * @param matrix 矩阵数组
     * @return void
     * 算法思路：
     * 1、先进行矩阵的转置，转置操作是交换矩阵的行和列
     * 2、再对每一行进行翻转，翻转操作是交换该行的两端元素
     * 3、这两步操作能有效实现原地旋转90度
     */
    public static void rotate(int[][] matrix) {
        System.out.println("原始的图像: ");
        ArrayUtil.print(matrix);

        int n = matrix.length;
        // 先转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("转置后的图像: ");
        ArrayUtil.print(matrix);

        // 然后翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        System.out.println("翻转行后的图像: ");
        ArrayUtil.print(matrix);
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix2);
    }


}

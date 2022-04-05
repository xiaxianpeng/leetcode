package org.example.array;

/**
 * @author xianpeng.xia
 * on 2022/4/5 3:32 PM
 * 旋转矩阵
 *
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
 */
public class RotateMatrix {

    /**
     * 旋转
     *
     * @param matrix 矩阵数组
     */
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N / 2; ++i) {
            for (int j = 0; j < (N + 1) / 2; ++j) {
                //
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - j - 1][i];
                matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
                matrix[N - j - 1][N - j - 1] = matrix[j][N - i - 1];
                matrix[j][N - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {

    }
}

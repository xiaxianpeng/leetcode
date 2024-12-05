package org.example.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [
 * [1,2,3,4],
 * [5,6,7,8],
 * [9,10,11,12]
 * ]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * Created on 2024/12/5 15:07
 */
public class SpiralMatrix {

    /**
     * 按照顺时针螺旋顺序遍历矩阵
     * 算法思路：
     * - 使用四个变量 `top`、`bottom`、`left`、`right` 表示矩阵的边界。
     * - 按顺序遍历：
     * 1. 从左到右遍历 `top` 行
     * 2. 从上到下遍历 `right` 列
     * 3. 从右到左遍历 `bottom` 行
     * 4. 从下到上遍历 `left` 列
     * - 每遍历一条边界后，相应的边界变量收缩，以实现内层矩阵的遍历。
     *
     * @param matrix 输入的二维数组
     * @return 顺时针螺旋顺序的元素列表
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. 从左到右遍历 top 行
            System.out.println("Traversing top row from column " + left + " to " + right);
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;// 上边界收缩
            System.out.println("Updated top to: " + top);

            // 2. 从上到下遍历 right 列
            System.out.println("Traversing right column from row " + top + " to " + bottom);
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;// 右边界收缩
            System.out.println("Updated right to: " + right);

            // 3. 从右到左遍历 bottom 行（如果没有交错）
            if (top <= bottom) {
                System.out.println("Traversing bottom row from column " + right + " to " + left);
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;// 下边界收缩
                System.out.println("Updated bottom to: " + bottom);
            }

            // 4. 从下到上遍历 left 列（如果没有交错）
            if (left <= right) {
                System.out.println("Traversing left column from row " + bottom + " to " + top);
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

            System.out.println("当前边界值 :");
            System.out.println("Top: " + top + ", Bottom: " + bottom + ", Left: " + left + ", Right: " + right);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Spiral Order: " + spiralOrder(matrix1));

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println("Spiral Order: " + spiralOrder(matrix2));
    }
}

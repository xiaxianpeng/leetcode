package org.example.matrix.binarysearch;

/**
 * 240. 搜索二维矩阵II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例 1：
 * 输入：matrix =
 * [
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]
 * ], target = 5
 * 输出：true
 * 示例 2：
 * 输入：matrix = [
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]
 * ], target = 20
 * 输出：false
 * Created on 2025/1/9 20:57
 */
public class SearchMatrix {

    /**
     * 使用从右上角开始搜索的方式查找目标值
     * 如果当前值比目标值大，向左移动，如果比目标值小，向下移动
     *
     * @param matrix 矩阵
     * @param target 目标值
     * @return 是否存在目标值
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始，row=0；col=cols-1
        int row = 0;
        int col = cols - 1;

        // 当行号列号在范围内时，继续查找
        while (row < rows && col >= 0) {
            // 获取当前所在的元素
            int current = matrix[row][col];

            // 如果当前值恰好与目标值相等，返回true
            if (current == target) {
                return true;
            }
            // 如果当前值大于目标值，说明该列后面的值更大，所以向左移动
            else if (current > target) {
                col--;
            }
            // 如果当前值小于目标值，说明该行前面的值也更小，向下移动
            else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix1, 5));   // 预期：true

        int[][] matrix2 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix2, 20));  // 预期：false
    }
}

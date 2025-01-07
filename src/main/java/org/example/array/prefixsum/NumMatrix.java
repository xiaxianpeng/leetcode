package org.example.array.prefixsum;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1,col1) ，右下角 为 (row2,col2) 。
 * 实现 NumMatrix 类：
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)
 * 返回 左上角 (row1,col1)、右下角(row2,col2) 所描述的子矩阵的元素 总和 。
 * 输入
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * *********
 * *********
 * *********
 * 链接：https://leetcode.cn/problems/range-sum-query-2d-immutable/solutions/2667331/tu-jie-yi-zhang-tu-miao-dong-er-wei-qian-84qp/
 * 算法步骤：
 * 当然，这个算法是基于二维前缀和技术用于快速计算二维矩阵中任意子矩阵的元素和。
 * 这里是算法的步骤和逻辑描述：
 * 构造二维前缀和矩阵:
 * 给定一个二维矩阵 matrix，我们构造一个新的二维矩阵 preSum，
 * 其大小比 matrix 多一行和一列，即 preSum 的大小为 (m+1) x (n+1)，
 * 其中 m 和 n 分别是 matrix 的行数和列数。
 * preSum 用于存储矩阵中每个子矩阵的元素和，
 * 这些子矩阵的左上角是 (0,0)，右下角是 (i-1, j-1)。
 * 计算前缀和:
 * 我们遍历 matrix，并填充 preSum 的每个元素。
 * preSum[i][j] 会被赋值为 matrix 中所有从 (0,0) 到 (i-1,j-1) 的元素的总和。
 * 计算它的方法是利用前缀和的递推公式:
 * preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1]
 * 其中：
 * preSum[i-1][j] 是上方子矩阵的和。
 * preSum[i][j-1] 是左侧子矩阵的和。
 * preSum[i-1][j-1] 是左上角对角线子矩阵的和，我们从上方和左侧的子矩阵和中减去它是因为它被计算了两次。
 * matrix[i-1][j-1] 是当前考虑的元素。
 * 查询子矩阵的总和:
 * 当我们需要查询 (row1,col1) 到 (row2,col2) 子矩阵的元素和时，可以直接利用前缀和矩阵 preSum 来得到结果：
 * sumRegion(row1, col1, row2, col2) = preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1]
 * 其中：
 * preSum[row2+1][col2+1] 是从 (0,0) 到 (row2, col2) 的子矩阵的总和。
 * preSum[row1][col2+1] 和 preSum[row2+1][col1] 分别是上方和左侧的子矩阵的总和。
 * preSum[row1][col1] 是左上角对角线的子矩阵的总和，我们再次加上这个值是因为之前减去了两次。
 * 利用以上步骤，我们可以在 O(1) 时间内查询任意子矩阵的总和，而构造二维前缀和矩阵 preSum 的时间复杂度是 O(mn)。
 * 这种方法在处理多个区域和查询时非常有效率。
 */
public class NumMatrix {

    // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    private int[][] preSum;

    /**
     * 使用二维前缀和构造preSum数组
     * preSum[i][j]表示原矩阵从(0,0)到(i-1,j-1)的元素和
     *
     * @param matrix 矩阵
     */
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            preSum = new int[1][1];
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 构造前缀和矩阵，比原矩阵多一行，多一列
        preSum = new int[rows + 1][cols + 1];

        // 填充preSum数组
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                // preSum[row][col] = 当前元素 + 上方 + 左方 - 左上方
                preSum[row][col] = matrix[row - 1][col - 1]
                        + preSum[row - 1][col]
                        + preSum[row][col - 1]
                        - preSum[row - 1][col - 1];
            }
        }

    }


    /**
     * 计算左上角为 (row1, col1)、右下角为 (row2, col2) 的子矩阵的元素总和。
     *
     * @param row1 子矩阵左上角的行索引
     * @param col1 子矩阵左上角的列索引
     * @param row2 子矩阵右下角的行索引
     * @param col2 子矩阵右下角的列索引
     * @return 子矩阵的元素总和
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] // (0,0)到(row2,col2)的所有元素的和
                - preSum[row2 + 1][col1] // 减去左侧不需要的部分:(0,0)到(row2,col1-1)
                - preSum[row1][col2 + 1] // 减去上方不需要的部分:(0,0)到(row1-1,col2)
                + preSum[row1][col1]; // (0,0)到(row-1,col1-1)，因为两次减法减重了，所以加回来
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        // return 8 (红色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));

        // return 11 (绿色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));

        // return 12 (蓝色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));

    }
}

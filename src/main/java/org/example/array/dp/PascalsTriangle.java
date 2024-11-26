package org.example.array.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 * Created on 2024/11/26 19:21
 * 杨辉三角的每一行的结构是：
 * 第一个和最后一个元素总是 1。
 * 其他元素是由上一行的两个相邻元素之和构成的。
 */
public class PascalsTriangle {

    /**
     * 生成杨辉三角的前 numRows 行。
     * 核心思路：使用动态规划的思想，每一行的内部元素等于上一行相邻两个元素之和。
     *
     * @param numRows 要生成的行数
     * @return 杨辉三角的前 numRows 行
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // 如果行数为0，直接返回空列表
        if (numRows == 0) {
            return triangle;
        }

        // 初始化第一行
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        System.out.println("Row 1: " + triangle.get(0));

        // 从第二行开始生成每一行
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(rowNum - 1);

            // 每一行的第一个元素为1
            row.add(1);

            // 中间的元素是由上一行相邻两个元素之和得到
            for (int colIndex = 1; colIndex < rowNum; colIndex++) {
                int sum = preRow.get(colIndex - 1) + preRow.get(colIndex);
                row.add(sum);
            }

            // 每一行的最后一个元素为1
            row.add(1);

            triangle.add(row);
            System.out.println("Row " + (rowNum + 1) + ": " + row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println("Pascal's Triangle with 5 rows:" + generate(5));
        System.out.println("Pascal's Triangle with 1 rows:" + generate(1));
    }
}

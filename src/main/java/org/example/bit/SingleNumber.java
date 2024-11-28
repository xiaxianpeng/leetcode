package org.example.bit;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    /**
     * 使用 XOR 运算找到数组中唯一的未配对元素。
     *
     * @param nums 输入的整数数组。
     * @return 数组中只出现一次的数字。
     * XOR 运算的性质：
     * 1、任何数与0进行 XOR 运算的结果仍为那个数：a⊕0=a
     * 2、任何数与其自身进行 XOR 运算的结果为0：a⊕a=0
     * 3、XOR 运算是交换律和结合律的：a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        //一个数和 0 做 XOR 运算等于本身：a⊕0 = a
        //一个数和其本身做 XOR 运算等于 0：a⊕a = 0
        //XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
        for (int num : nums) {
            System.out.println("XOR " + result + " with " + num);
            result ^= num;
            System.out.println("Result: " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testArray1 = {2, 2, 1};
        System.out.println("The single number in [2, 2, 1] is: " + singleNumber(testArray1));

        int[] testArray2 = {4, 1, 2, 1, 2};
        System.out.println("The single number in [4, 1, 2, 1, 2] is: " + singleNumber(testArray2));
    }
}

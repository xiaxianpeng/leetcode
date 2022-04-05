package org.example.queue;

/**
 * @author xianpeng.xia
 * on 2022/4/5 2:32 PM
 *
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 * 示例1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * 示例2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneEditAway {

    /**
     * @param first s1
     * @param second s2
     * @return 是否只经过一次编辑
     */
    public static boolean oneEditAway(String first, String second) {
        int n1 = first.length(), n2 = second.length();
        // 字符长度差
        int flag = Math.abs(n1 - n2);
        int diffCount = 0;
        // 如果差值大于1，返回false
        if (flag > 1) {
            return false;
        } else if (flag == 0) {// 长度相等只能是通过替换
            for (int i = 0; i < n1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diffCount++;
                }
            }
            return diffCount > 1 ? false : true;
        } else {// 长度差1只能是通过删除或者插入
            if (n1 == 0 || n2 == 0) {
                return true;
            }
            int i = 0, j = 0;
            while (diffCount <= 1) {
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                } else {
                    diffCount++;
                    if (n1 > n2) {
                        i++;
                    } else {
                        j++;
                    }
                }
                if ((i >= n1 || j >= n2) && diffCount <= 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
    }
}

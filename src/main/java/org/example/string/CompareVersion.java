package org.example.string;

/**
 * 165. 比较版本号
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 * 返回规则如下：
 * 如果 version1 < version2 返回 -1，
 * 如果 version1 > version2 返回 1，
 * 除此之外返回 0。
 * 示例 1：
 * 输入：version1 = "1.2", version2 = "1.10"
 * 输出：-1
 * 解释：
 * version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
 * 示例 2：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：
 * 忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
 * 示例 3：
 * 输入：version1 = "1.0", version2 = "1.0.0.0"
 * 输出：0
 * 解释：
 * version1 有更少的修订号，每个缺失的修订号按 "0" 处理。
 * Created on 2024/11/8 18:08
 */
public class CompareVersion {

    /**
     * 对字符串进行分割，诸位比较「修订号」大小即可。
     * 对于缺省的修订号位置，使用 0 进行代指。
     */
    public static int compareVersion(String v1, String v2) {
        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");
        int m = s1.length;
        int n = s2.length;
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            int a = 0;
            int b = 0;
            if (i < m) {
                a = Integer.parseInt(s1[i++]);
            }
            if (j < n) {
                b = Integer.parseInt(s2[j++]);
            }
            if (a != b) {
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.2";
        String v2 = "1.10";
        System.out.println(compareVersion(v1, v2));
        v1 = "1.01";
        v2 = "1.001";
        System.out.println(compareVersion(v1, v2));
        v1 = "1.0";
        v2 = "1.0.0.1";
        System.out.println(compareVersion(v1, v2));
    }
}

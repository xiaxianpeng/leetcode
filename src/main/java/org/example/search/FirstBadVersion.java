package org.example.search;

/**
 * @author xianpeng.xia
 * on 2022/5/6 00:46
 *
 * 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 *
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
 */
public class FirstBadVersion {

    int badVersion;

    private FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    private Boolean isBadVersion(int version) {
        return version == badVersion;
    }

    /**
     * @param n n
     * @return 第一个错误的版本。
     * 二分法
     */
    public int firstBadVersion(int n) {
        int L = 1, R = n;
        while (L < R) {// 循环直至区间左右端点相同
            int mid = L + (R - L) / 2;
            if (isBadVersion(mid)) {// 答案在区间 [L, R] 中
                R = mid;
            } else {// 答案在区间 [mid+1, right] 中
                L = mid + 1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return L;
    }

    public static void main(String[] args) {
        int n = 5, badVersion = 4;
        int bad = new FirstBadVersion(badVersion).firstBadVersion(n);
        System.out.println(bad);
    }
}

package org.example.string;

/**
 * @author xianpeng.xia
 * on 2022/4/5 2:56 PM
 */
public class CompressString {

    public static String compressString(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        Character c = s.charAt(0);
        //
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cnt++;
            } else {
                // 追加
                ans.append(c).append(cnt);
                c = s.charAt(i);
                cnt = 1;
            }
        }
        ans.append(c).append(cnt);
        return ans.toString();
    }

    /**
     * @param s s
     * @return 压缩后的字符串
     */
    public static String compressStringSolution(String s) {
        int i = 0, j = 0, len = s.length();
        StringBuffer ans = new StringBuffer();
        while (i < len) {
            // 从
            while (j < len && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            ans.append(s.charAt(i)).append(j - i);
            i = j;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "aabbbcdd";
        System.out.println(compressString(s));
    }
}

package org.example.reorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/5/5 00:46
 *
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 *
 * 有两种不同类型的日志：
 *
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 *
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 *
 *
 * 示例 1：
 *
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 * 示例 2：
 *
 * 输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-data-in-log-files
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderDataInLogFiles {

    private static class Log {

        /**
         * 类型
         */
        int type;
        /**
         * 索引
         */
        int index;
        /**
         * 原始字符串
         */
        String ori;
        /**
         * 标记
         */
        String sign;
        /**
         * 内容
         */
        String content;

        public Log(String s, int index) {
            this.index = index;
            int n = s.length(), i = 0;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            // eg:"dig1"/"let1"
            sign = s.substring(0, i);
            // eg:"8 1 5 1"/"art can"
            content = s.substring(i + 1);
            // "dig1 8 1 5 1", "let1 art can"
            ori = s;
            // eg:1/0
            type = Character.isDigit(content.charAt(0)) ? 1 : 0;
        }
    }

    /**
     * 自定义类 + 排序
     * 根据排序规则，我们需要对每个 str[i]str[i] 进行裁剪处理，从而得知每个 str[i]str[i] 是属于「字母日志」还是「数字日志」，以及得到 sign 部分和 content 部分。
     *
     * 在排序过程中，每个 str[i]str[i] 会被访问多次，为了让每个 str[i]str[i] 只进行一次这样的预处理工作，我们可以自定义类，将这部分工作放到类的实例化去做。
     *
     * 最后是简单将 str[i]str[i] 转存成 Log 实例，自定义排序，用排序结果构造答案的基本逻辑。
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/reorder-data-in-log-files/solution/by-ac_oier-ap28/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        List<Log> logList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            logList.add(new Log(logs[i], i));
        }
        Collections.sort(logList, (a, b) -> {
            if (a.type != b.type) {
                return a.type - b.type;
            }
            if (a.type == 1) {
                return a.index - b.index;
            }
            return !a.content.equals(b.content) ? a.content.compareTo(b.content) : a.sign.compareTo(b.sign);
        });
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            ans[i] = logList.get(i).ori;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] reorderLogFiles = new ReorderDataInLogFiles().reorderLogFiles(logs);
        System.out.println(Arrays.toString(reorderLogFiles));
    }
}

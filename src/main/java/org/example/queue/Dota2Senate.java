package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 649. Dota2 参议院
 * Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。
 * 他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：
 * 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。
 * 宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
 * 给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。
 * 然后，如果有 n 个参议员，给定字符串的大小将是 n。
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。
 * 所有失去权利的参议员将在过程中被跳过。
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。
 * 输出应该是 "Radiant" 或 "Dire" 。
 * 示例 1：
 * 输入：senate = "RD"
 * 输出："Radiant"
 * 解释：
 * 第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
 * 这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
 * 第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人。
 * 示例 2：
 * 输入：senate = "RDD"
 * 输出："Dire"
 * 解释：
 * 第 1 轮时，第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利。
 * 这一轮中，第二个来自 Dire 阵营的参议员会将被跳过，因为他的权利被禁止了。
 * 这一轮中，第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利。
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 * Created on 2024/11/18 13:32
 */
public class Dota2Senate {

    /**
     * 模拟 Dota2 参议院的投票过程，预测最后的胜利阵营。
     * 核心思路：
     * 1. 使用队列存储 Radiant 和 Dire 阵营的参议员。
     * 2. 在每一轮中，队列的首位参议员将对另一方的首位参议员进行制约。
     * 3. 若一方的所有参议员都无法投票，另一方获胜。
     */
    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        // 将 Radiant 和 Dire 阵营的参议员索引分别加入队列
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                // Radiant 阵营的参议员
                radiant.add(i);
            } else {
                // Dire 阵营的参议员
                dire.add(i);
            }
        }

        // 模拟轮次投票，直到有一个阵营获胜
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            // 获取当前轮投票的参议员
            Integer radiantIndex = radiant.poll(); // Radiant 阵营参议员的投票
            Integer direIndex = dire.poll();// Dire 阵营参议员的投票
            // 比较两个参议员的投票顺序，谁先投票，就可以禁权对方阵营的参议员
            if (radiantIndex < direIndex) {
                // Radiant 阵营的参议员投票成功，令其重新排队，继续参与后续轮次
                radiant.offer(radiantIndex + senate.length());
            } else {
                // Dire 阵营的参议员投票成功，令其重新排队，继续参与后续轮次
                dire.offer(direIndex + senate.length());
            }
        }
        // 判断哪个队列中有参议员，那个阵营获胜
        return radiant.isEmpty() ? "dire" : "radiant";
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));   // 输出 "Radiant"
        System.out.println(predictPartyVictory("RDD"));  // 输出 "Dire"
    }
}

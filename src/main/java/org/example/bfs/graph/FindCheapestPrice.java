package org.example.bfs.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过一些航班连接。
 * 给你一个数组 flights ，
 * 其中 flights[i] = [fromi, toi, pricei] ，
 * 表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，
 * 你的任务是找到出一条最多经过 k 站中转的路线，
 * 使得从 src 到 dst 的 价格最便宜 ，并返回该价格。
 * 如果不存在这样的路线，则输出 -1。
 * 示例 1：
 * 输入:
 * n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * 输出: 700
 * 解释: 城市航班图如上
 * 从城市 0 到城市 3 经过最多 1 站的最佳路径用红色标记，费用为 100 + 600 = 700。
 * 请注意，通过城市 [0, 1, 2, 3] 的路径更便宜，但无效，因为它经过了 2 站。
 * 示例 2：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如上
 * 从城市 0 到城市 2 经过最多 1 站的最佳路径标记为红色，费用为 100 + 100 = 200。
 * 示例 3：
 * 输入：n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * 输出：500
 * 解释：
 * 城市航班图如上
 * 从城市 0 到城市 2 不经过站点的最佳路径标记为红色，费用为 500。
 * Created on 2025/1/2 10:45
 */
public class FindCheapestPrice {

    /**
     * 使用BFS思路寻找在最多k站中转内从src到dst的最便宜航班价格
     *
     * @param n       城市数量
     * @param flights 航班信息数组，元素格式[from,to,price]
     * @param src     出发城市
     * @param dst     目的城市
     * @param k       最多可中转次数
     * @return 最低价格，如无可行航班返回-1
     * 算法思路：
     * 1、构建邻接表存储航班信息，便于快速查询从某城市可达的下一城市及价格
     * 2、维护一个二维数组best[city][stops]，表示在stops次数限制下，到达city的最小花费
     * 3、使用队列进行层序遍历，从(src,0,0)出发，依次向下层扩展，直到stops > k
     * 4、如果在遍历中出现更优花费，则更新best数组并将新状态加入队列
     * 5、在结束BFS后，遍历best[dst][0...k+1]，找最小花费，无解返回-1
     */
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 创建邻接表来存储航班信息，key：城市编号，value：（目标城市，价格），便于快速查找从某城市可直达的下一个城市及对应价格
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 将flights中的航班信息填入邻接表
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            // 将航班信息加入graph
            graph.get(from).add(new int[]{to, price});
        }

        // best[city][stops]表示在stops次数限制下，到达city的最小花费，初始化为无穷大
        int[][] best = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }

        // BFS队列，元素包含：当前城市，目前花费，已用中转次数
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});
        best[src][0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int city = current[0];
            int costSoFar = current[1];
            int stops = current[2];
            System.out.println("访问城市: " + city + ", 当前花费: " + costSoFar + ", 已用中转: " + stops);

            // 如果达到目的地，可能是解，但需继续搜索以防有最低价格
            if (city == dst) {
                System.out.println("到达目的地 " + dst + "，当前花费：" + costSoFar);
            }

            // 如果可以继续中转，则遍历相邻城市
            if (stops <= k) {
                for (int[] nextFlight : graph.get(city)) {
                    int nextCity = nextFlight[0];
                    int nextCost = costSoFar + nextFlight[1];

                    // 若在同等中转限制下找到更优价格，则更新并入队
                    if (nextCost < best[nextCity][stops + 1]) {
                        best[nextCity][stops + 1] = nextCost;
                        queue.offer(new int[]{nextCity, nextCost, stops + 1});
                        System.out.println("更新城市 " + nextCity + " 在中转次数 " + (stops + 1) + " 下的最小花费: " + nextCost);
                    }
                }
            }
        }

        // 在best数组中找到所有中转次数(0...k+1)下到达dst的最小花费
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            if (best[dst][i] < minCost) {
                minCost = best[dst][i];
            }
        }

        // 如果minCost还是最大值，说明无法到达
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public static void main(String[] args) {
        int n1 = 4;
        int[][] flights1 = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src1 = 0;
        int dst1 = 3;
        int k1 = 1;
        System.out.println("CheapestPrice:" + findCheapestPrice(n1, flights1, src1, dst1, k1));

        int n2 = 3;
        int[][] flights2 = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        int src2 = 0;
        int dst2 = 2;
        int k2 = 1;
        System.out.println("CheapestPrice:" + findCheapestPrice(n2, flights2, src2, dst2, k2));

        int n3 = 3;
        int[][] flights3 = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        int src3 = 0;
        int dst3 = 2;
        int k3 = 0;
        System.out.println("CheapestPrice:" + findCheapestPrice(n3, flights3, src3, dst3, k3));
    }
}

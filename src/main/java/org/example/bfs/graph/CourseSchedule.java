package org.example.bfs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。
 * 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；
 * 并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * Created on 2024/11/25 10:32
 */
public class CourseSchedule {

    /**
     * 判断是否可以完成所有课程的学习。
     * 使用拓扑排序算法，检测课程依赖图中是否存在环。
     *
     * @param numCourses    课程数
     * @param prerequisites 先修课程列表
     * @return 如果可以完成所有课程则返回 true，否则返回 false
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // 创建一个数组来存储每门课的入度
        int[] inDegree = new int[numCourses];
        // 创建一个邻接表来存储图
        List<List<Integer>> graph = new ArrayList<>();

        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 填充图和入度数组
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            graph.get(course).add(preCourse);
            inDegree[preCourse]++;
        }

        // 创建一个队列来进行BFS
        Queue<Integer> queue = new LinkedList<>();

        // 将所有入度为0的节点（课程）加入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;// 访问过的节点计数

        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited++;
            // 检查当前课程的所有后续课程
            for (Integer nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if(inDegree[nextCourse]==0){
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果访问过的节点数等于课程总数，说明可以完成所有课程
        return visited == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}})); // 输出: true
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}})); // 输出: false
    }
}

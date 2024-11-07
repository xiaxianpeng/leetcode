bfs 框架
```
// 计算起点 start 到终点 target 的最近距离
    int BFS(Node start, Node target) {
        // 核心数据结构
        Queue<Node> queue;
        // 避免走回头路
        Set<Node> visited;

        // 将起点加入到队列
        queue.offer(start);
        visited.add(start);

        // 记录扩展的步数
        int step = 0;

        while (!queue.isEmpty()) {
            // sz
            int sz = queue.size();

            /* 将当前队列的所有节点向四周扩散*/
            for (int i = 0; i < sz; i++) {
                Node cur = queue.poll();
                
                /* 判断是否到达终点 */
                if (cur == target) {
                    return step;
                }
                
                /* 将 cur 的相邻节点加入队列 */
                for (Node x : cur.adj()) {
                    if (x not in visited) {
                        queue.offer(x);
                        visited.add(x);
                    }
                }
                
            }
            
            /* 更新步数*/
            step++;
        }
    }
```
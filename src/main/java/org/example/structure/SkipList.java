package org.example.structure;

import java.util.Random;

/**
 * @author xianpeng.xia
 * on 2022/7/2 21:34
 *
 * 跳表
 */
public class SkipList {

    /**
     * 跳表的节点，每个节点记录了当前节点数据和所在层数数据
     */
    public class Node {

        private int data = -1;

        /**
         * 表示当前节点位置的下一个节点所有层的数据，从上层切换到下层，就是数组下标-1
         * forwards[3]表示当前节点在你第三层节点的下一个节点
         */
        private Node[] forwards;
        /**
         *
         */
        private int maxLevel = 0;

        public Node(int level) {
            forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("{ data: ");
            sb.append(data);
            sb.append("; levels: ");
            sb.append(maxLevel);
            sb.append(" }");
            return sb.toString();
        }
    }

    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    /**
     * 带头节点
     */
    private Node head = new Node(MAX_LEVEL);
    private Random random = new Random();

    public Node find(int value) {
        Node p = head;
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层在开始查找
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value, int level) {
        // 随机一个层数
        if (level == 0) {
            level = randomLevel();
        }
        // 创建新节点
        Node newNode = new Node(level);
        newNode.data = value;
        // 表示从最大层到低层，都要有节点的数据
        newNode.maxLevel = level;
        // 记录要更新的层数，表示新节点要你更新到哪一层
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }
        /**
         *
         * 1，说明：层是从下到上的，这里最下层编号是0，最上层编号是15
         * 2，这里没有从已有数据最大层（编号最大）开始找，（而是随机层的最大层）导致有些问题。
         *    如果数据量为1亿，随机level=1 ，那么插入时间复杂度为O（n）
         */
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // 这里update[i]表示当前层节点的前一节点，以为要找到前一节点，才能插入数据
            update[i] = p;
        }

        // 将每一层节点和后面节点关联
        for (int i = 0; i < level; i++) {
            // 记录当前层节点后面节点指针
            newNode.forwards[i] = update[i].forwards[i];
            // 前一个节点的指针，指向当前节点
            update[i].forwards[i] = newNode;
        }
        // 更新层高
        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void insert(int value) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        // 每次只增加一层，如果条件满足
        if (level > levelCount) {
            level = ++levelCount;
        }

        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;

        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
            // levelCount 会 > level，所以加上判断
            if (level > i) {
                if (p.forwards[i] == null) {
                    p.forwards[i] = newNode;
                } else {
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    public void delete(int value) {

        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    /**
     * 随机 level 次，如果是奇数层数 +1，防止伪随机
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public void printAll() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }

    public static void main(String[] args) {
        /*SkipList skipList = new SkipList();
        skipList.insert(1, 3);
        skipList.insert(2, 3);
        skipList.insert(3, 2);
        skipList.insert(4, 4);
        skipList.insert(5, 10);
        skipList.insert(6, 4);
        skipList.insert(8, 5);
        skipList.insert(7, 4);*/

        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(8);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(5);
        skipList.printAll();


    }
}

package org.example.skiplist;

import java.util.Random;

/**
 * @author xianpeng.xia
 * on 2022/7/2 21:34
 * <p>
 * 跳表
 */
public class SkipList {

    /**
     * 静态常量，表示跳表允许的最大层数。
     */
    private static final int MAX_LEVEL = 16;
    /**
     * 动态变量，记录当前跳表的层数。
     */
    private int levelCount = 1;
    /**
     * 带头节点，所有层的起始点。
     */
    private Node head = new Node(MAX_LEVEL);
    /**
     * 用于生成随机层数。
     */
    private Random random = new Random();

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

    public Node find(int value) {
        // head 是指向跳表头部的指针，它有多个指针（forwards），每个指针对应跳表的一层。
        // levelCount 表示跳表的总层数。通常情况下，层数是随机生成的，以保持跳表的平衡性。
        Node p = head;
        // 1、从最大层head节点开始，也就是最上面一层的最左边。
        // 2、使用一个 for 循环，从最高层 (levelCount - 1) 开始逐层向下遍历。每一次循环都是在一层中进行查找。
        for (int i = levelCount - 1; i >= 0; i--) {
            // p.forwards[i] 表示第 i 层的第一个节点。
            // 3、使用 while 循环水平遍历当前层的链表。如果当前节点的下一个节点 (p.forwards[i]) 非空，且该节点的数据值小于要查找的 value，就向右继续遍历。
            // 4、当 while 循环结束时，意味着已经到达当前层中小于 value 的最大节点，或者到达了当前层的末尾。
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
            // 5、切换到下一层继续查找，直到到达最底层 (i == 0)。
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            // 6、在最底层，检查 p.forwards[0] 是否为非空且数据值等于 value。如果是，说明找到了目标节点，返回该节点。
            return p.forwards[0];
        } else {
            // 7、如果 p.forwards[0] 为空或数据值不等于 value，则说明该值不存在于跳表中，返回 null
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
        // 1、确定插入层级：
        // 如果跳表是空的（即 head.forwards[0] 为空），则新节点的层级设置为 1
        // 如果跳表不为空，通过 randomLevel() 函数随机一个层级 level。randomLevel() 根据一定的概率决定节点在跳表中的高度（层数）
        int level = head.forwards[0] == null ? 1 : randomLevel();
        // 如果随机得到的层级 level 大于当前跳表的层级 levelCount，则更新 level 为 levelCount + 1，
        // 即跳表层数加一，因为跳表的层级每次最多增加一层。
        if (level > levelCount) {
            level = ++levelCount;
        }
        System.out.println("");
        System.out.println("insert:" + value + ",level:" + level);
        // 2、创建一个新的节点
        // 创建一个新的节点 newNode，并将数据域设置为待插入的值 value。
        // newNode 的层级由之前确定的 level 指定。
        Node newNode = new Node(level);
        newNode.data = value;

        // 3、寻找插入位置：
        Node p = head;
        // 3.1、从跳表的头节点 head 和最高层开始搜索（即 levelCount - 1），逐一向下遍历每一层，直到第 0 层。
        for (int i = levelCount - 1; i >= 0; --i) {
            // 3.2、在每一层中，向前遍历链表直到找到第一个值大于或等于 value 的节点的前一个节点 p。
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
            // 4、插入节点：
            // 在每一层中，如果 level 大于当前层级 i，说明新节点 newNode 应当在这一层中插入。
            if (level > i) {
                if (p.forwards[i] == null) {
                    // 如果当前节点 p 的 forwards[i] 是空的，说明 p 是这层的最后一个节点，直接将 newNode 插入到 p 的后面。
                    p.forwards[i] = newNode;
                } else {
                    // 如果 p.forwards[i] 不为空，则将 newNode 插入到 p 和 p.forwards[i] 之间。
                    // 即将 newNode 的 forwards[i] 指向 p.forwards[i]，然后将 p.forwards[i] 更新为 newNode。
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    public void delete(int value) {
        // 1、创建一个 update 数组，用来存储每一层中待删除元素的前驱节点（即在删除节点之前的节点）。这样我们可以在后面更新它们的指针。
        Node[] update = new Node[levelCount];
        // 从跳表头节点 head 开始向下和向前遍历。
        // 2、查找待删除节点的前驱：
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            //从最高层（levelCount - 1）开始遍历，直到最底层（i = 0）。
            //对于每一层，通过 while 循环向前移动，直到找到第一个数据值小于 value 的节点 p。
            //记录下每一层中 value 的前驱节点到 update 数组中。
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }
        // 3、检查待删除节点是否存在：
        // 判断 p.forwards[0] 是否非空并且数据值等于待删除的 value。如果是，说明找到了待删除节点。
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            // 4、执行删除：
            // 如果找到待删除节点，再次遍历各层，检查每一层的前驱节点的后继节点是否是待删除节点。
            for (int i = levelCount - 1; i >= 0; --i) {
                // 如果是，将前驱节点的后继指针（update[i].forwards[i]）更新为待删除节点的后继节点（update[i].forwards[i].forwards[i]），
                // 从而在每一层中移除了待删除节点。
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
        // 遍历每一层
        for (int i = levelCount - 1; i >= 0; i--) {
            System.out.print("Level " + i + ": ");
            Node node = head.forwards[i]; // 从该层的头节点开始
            while (node != null) {
                System.out.print(node.data + " "); // 打印节点值
                node = node.forwards[i]; // 移动到该层的下一个节点
            }
            System.out.println(); // 该层结束，打印换行
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
        skipList.printAll();
        skipList.insert(2);
        skipList.printAll();
        skipList.insert(6);
        skipList.printAll();
        skipList.insert(7);
        skipList.printAll();
        skipList.insert(8);
        skipList.printAll();
        skipList.insert(3);
        skipList.printAll();
        skipList.insert(4);
        skipList.printAll();
        skipList.insert(5);
        skipList.printAll();
        skipList.printAll();
        System.out.println("find:" + skipList.find(5));
    }
}

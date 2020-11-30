package org.example.linkedList;

import org.example.bean.Hero;
import org.example.bean.ListNode;

/**
 * Created by xianpeng.xia
 * on 2020/11/29 下午11:42
 * <p>
 * 使用单向链表存储水浒108好汉
 */
public class HeroList extends SingleLinkedList {

    public HeroList(ListNode<Hero> head) {
        super(head);
    }

    public void addByNo(ListNode<Hero> hero) {
        ListNode temp = getHead();
        //如果已经存在不插入
        boolean flag = false;
        //找到其前面一个节点 插入该节点后面
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            int nextHeroNo = ((Hero) temp.getNextNode().getVal()).getNo();
            int heroNo = ((Hero) hero.getVal()).getNo();
            if (nextHeroNo > heroNo) {
                break;
            } else if (nextHeroNo == heroNo) {
                flag = true;
                break;
            } else {
                temp = temp.getNextNode();
            }
        }

        if (flag) {
            System.out.println("已存在～～");
        } else {
            ListNode tempNextNode = temp.getNextNode();
            temp.setNextNode(hero);
            hero.setNextNode(tempNextNode);
            System.out.printf("%d 插入No %d 后", hero.getVal().getNo(), ((Hero) temp.getVal()).getNo());
            System.out.println();
        }
    }

    public void update(ListNode<Hero> hero) {
        ListNode<Hero> temp = getHead();
        boolean flag = false;
        // 找到要更新的节点的上一个节点
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            int no = ((Hero) temp.getNextNode().getVal()).getNo();
            if (no == hero.getVal().getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNextNode();
        }
        if (flag) {
            ListNode<Hero> node = temp.getNextNode();
            Hero val = node.getVal();
            val.setName(hero.getVal().getName());
            val.setNickname(hero.getVal().getNickname());
        } else {
            System.out.printf("未找到%d，无法更新", hero.getVal().getNo());
        }
    }

    public void delete(int no) {
        ListNode<Hero> temp = getHead();
        boolean flag = false;
        // 找到要更新的节点的上一个节点
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            int currentNo = ((Hero) temp.getNextNode().getVal()).getNo();
            if (currentNo == no) {
                flag = true;
                break;
            }
            temp = temp.getNextNode();
        }
        if (flag) {
            temp.setNextNode(temp.getNextNode().getNextNode());
        } else {
            System.out.printf("未找到%d，无法删除", no);
        }
    }

    public static void main(String[] args) {
        Hero hero0 = new Hero(0, "", "");
        Hero hero1 = new Hero(1, "宋江", "及时雨");
        Hero hero2 = new Hero(2, "卢俊义", "玉麒麟");
        Hero hero3 = new Hero(3, "吴用", "智多星");
        Hero hero4 = new Hero(4, "公孙胜", "入云龙");
        Hero hero5 = new Hero(5, "关胜", "大刀");
        Hero hero33 = new Hero(3, "吴用~", "智多星~~");

        HeroList heroList = new HeroList(new ListNode<>(hero0));
        heroList.addByNo(new ListNode(hero1));
        heroList.addByNo(new ListNode(hero3));
        heroList.addByNo(new ListNode(hero5));
        heroList.addByNo(new ListNode(hero2));
        heroList.addByNo(new ListNode(hero4));
        heroList.print();
        heroList.update(new ListNode(hero33));
        heroList.print();
        heroList.delete(2);
        heroList.print();

    }
}

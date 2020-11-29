package org.example.linkedList;

import org.example.bean.Hero;
import org.example.bean.ListNode;

/**
 * Created by xianpeng.xia
 * on 2020/11/29 下午11:06
 *
 * 单向链表
 */
public class SingleLinkedList {

    private ListNode head;

    public SingleLinkedList(ListNode head) {
        this.head = head;
    }

    public void add(ListNode node) {
        ListNode temp = head;
        //  找到最后一个节点
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            temp = temp.getNextNode();
        }
        // 最后一个节点大next指向新节点
        temp.setNextNode(node);
    }

    public void print() {
        if (head.getNextNode() == null) {
            System.out.println("Null linked list");
            return;
        }
        ListNode temp = head.getNextNode();
        while (true) {
            if (temp == null) {
                System.out.println("End ~~~");
                break;
            }
            System.out.println(temp);
            temp = temp.getNextNode();
        }
    }

    public static void main(String[] args) {
        Hero hero0 = new Hero(0, "", "");
        Hero hero1 = new Hero(1, "宋江", "及时雨");
        Hero hero2 = new Hero(2, "卢俊义", "玉麒麟");
        Hero hero3 = new Hero(3, "吴用", "智多星");
        Hero hero4 = new Hero(4, "公孙胜", "入云龙");
        Hero hero5 = new Hero(5, " 关胜", "大刀");

        SingleLinkedList singleLinkedList = new SingleLinkedList(new ListNode(hero1));
        singleLinkedList.add(new ListNode(hero1));
        singleLinkedList.add(new ListNode(hero2));
        singleLinkedList.add(new ListNode(hero3));
        singleLinkedList.add(new ListNode(hero4));
        singleLinkedList.add(new ListNode(hero5));

        singleLinkedList.print();


    }
}

package org.example.bean;

/**
 * @date 2020/09/25
 * @time 12:52
 */
public class ListNode<T> {

    private T val;
    private ListNode nextNode;

    public ListNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return val + " " + nextNode + " ";
    }
}

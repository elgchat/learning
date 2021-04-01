package com.elgchat.learning.data;

/**
 * 链表实现
 */
public class LinedStack {
    int size;
    Node head; //头节点

    /**
     * 初始化
     */
    public LinedStack() {
        head = null;
        size = 0;
    }

    /**
     * 入栈
     *
     * @param node
     */
    public void push(Node node) {
        //head
        if (size == 0) {
            head = node;
        } else {    //非head
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * 出栈
     *
     * @return Node
     */
    public Node pop() {
        if (size > 0) {
            Node oldHead = head;
            head = head.next;
            size--;
            return oldHead;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(1);
        Node n4 = new Node(4);
        LinedStack ls = new LinedStack();
        ls.push(n1);
        ls.push(n2);
        ls.push(n3);
        ls.push(n4);
        System.out.println(ls.pop().value);
        System.out.println(ls.pop().value);
        System.out.println(ls.pop().value);
        System.out.println(ls.pop().value);
    }
}
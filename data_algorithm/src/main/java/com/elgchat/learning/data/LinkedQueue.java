package com.elgchat.learning.data;


/**
 * 链表实现
 */
public class LinkedQueue {
    Node head;
    Node tail;
    int size;

    public void enqueue(Node node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Node dequeue() {
        if (head == null) return null;
        Node h = head; //将拉取的节点的下一个节点变成新的表头
        head = head.next; //把旧的表头的下一个节点指向设置为null，让gc回收 h.next = null;
        //队列为空
        if (head == null)
            tail = null;
        size--;
        return h;
    }

    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(1);
        Node n4 = new Node(4);
        LinkedQueue lq = new LinkedQueue();
        lq.enqueue(n1);
        lq.enqueue(n2);
        lq.enqueue(n3);
        lq.enqueue(n4);
        System.out.println(lq.dequeue().value);
        System.out.println(lq.dequeue().value);
        System.out.println(lq.dequeue().value);
        System.out.println(lq.dequeue().value);
    }
}

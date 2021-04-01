package com.elgchat.learning.data.queue;



public class LinkedQueue {

    /**
     * 队头
     */
    private Node head;
    /**
     * 队尾
     */
    private Node tail;
    private int size;


    public void enqueue(Object data){

        if (null == tail) {
            Node node = new Node(data);
            this.head = node;
            this.tail = node;
        }else {
            Node node = new Node(data);
            this.tail.next = node;
            this.tail = node;
        }
        size++;
    }


    public Object dequeue(){
        Node node = head;
        head = node.next;
        size--;
        return node.data;
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "head=" + head.toString() +
                ", tail=" + tail.toString() +
                ", size=" + size +
                '}';
    }

    public static class Node {

        private Object data;

        private Node next;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkedQueue arrayQueue = new LinkedQueue();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.toString());

        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println("====================>");
        System.out.println(arrayQueue.head);

        System.out.println(arrayQueue.toString());

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue((int) (Math.random() * 10));
        }
        System.out.println(arrayQueue.toString());
    }
}

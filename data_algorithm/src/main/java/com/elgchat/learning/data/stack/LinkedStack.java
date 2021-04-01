package com.elgchat.learning.data.stack;

public class LinkedStack {

    private Node node;

    private int size;

    /**
     * 入栈
     *
     * @param data data
     */
    public void push(Object data) {

        if (size == 0) {
            init(data);
        }else {
            this.node = new Node(data,this.node);
            size++;
        }
    }


    /**
     * 出栈
     *
     * @return data
     */
    public Object pop() {

        Node node = this.node;
        this.node = node.next;
        size--;
        return node.data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = this.node;
        while (node.next != null) {
            stringBuilder.append("==>").append(node.data.toString());
            node = node.next;
        }
        stringBuilder.append("==>").append(node.data.toString());
        return stringBuilder.toString();
    }

    private void init(Object data) {
        this.node = new Node(data);
        size++;
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
    }


    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();
        stack.push("张三");
        stack.push("李四");

        System.out.println("入栈后的数据" + stack.toString());

        System.out.println("出栈数据" + stack.pop());

        System.out.println("出栈后的数据" + stack.toString());
    }
}

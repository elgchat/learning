package com.elgchat.learning.data.stack;

public class LinkedStack {

    private Node node;
    private int len;

    /**
     * 入栈
     *
     * @param data data
     */
    public void push(Object data) {

        if (null == this.node) {
            init(data);
            return;
        }

        Node node = this.node;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(data, null);
        this.len++;
    }


    /**
     * 出栈
     *
     * @return data
     */
    public Object pop() {
        int len = 0;
        Node node = this.node;
        while (len != (this.len - 1)) {
            node = node.next;
            len++;
        }
        Object data = node.next.data;
        node.next = null;
        this.len--;
        return data;
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

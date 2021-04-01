package com.elgchat.learning.data;


/**
 * @author jianghai
 */
public class ListNode<T> {

    private int foot;
    private int count;
    private Node root;


    public boolean isEmpty() {
        return count == 0 || this.root == null;
    }

    public void add(T data) {

        if (this.isEmpty()) {
            this.root = new Node(data);
        } else {
            this.root.add(data);
        }
        this.count++;
    }

    public void addByIndex(int index,T data) {
        count = -1;
        Node tmp = this.root;
        while (count != index ){
            tmp = tmp.next;
            count++;
        }
        tmp.next = new Node(data,tmp.next);
    }

    public void addHead(T data) {
        this.root = new Node(data,this.root);
    }


    public void remove(int index) {
        count = 0;
        Node tmp = this.root;
        while (count != index ){
            tmp = tmp.next;
            count++;
        }
        tmp.next = new Node(null);
    }




    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node tmp = this.root;
        while (tmp.next != null ){
            str.append(tmp.data.toString());
            tmp = tmp.next;
        }
        str.append(tmp.data.toString());
        return str.toString();
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        private void add(T data) {
            if (this.next == null) {
                this.next = new Node(data);
            } else {
                this.next.add(data);
            }
        }

        private void get(int index,T data){
            if (ListNode.this.foot++ == index) {
                this.next = new Node(data,this.next);
                return;
            }
           this.next.get(index,data);
        }
    }
}

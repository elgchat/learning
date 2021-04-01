package com.elgchat.learning.data.linked;


/**
 * 模拟链表操作
 */
public class SingleLinkedList {
    /**
     * 定义节点
     */
    private Node node;

    /**
     * 长度
     */
    private int len;


    /**
     * get
     * @param i 下标
     * @return object
     */
    public Object get(int i) {
        if (i >= len || null == this.node) {
            return "下标越界或对象为空";
        }
        int len = 0;
        Node tmp = this.node;
        while (len != i) {
            len++;
            tmp = tmp.next;
        }
        return tmp.data;
    }


    /**
     * 更新
     * @param i 下标
     * @param data 数据
     */
    public void update(int i, Object data) {
        if (i >= len || null == this.node) {
            System.out.println("下标越界或对象为空");
        }

        int len = 0;
        Node tmp = this.node;
        while (len != i - 1) {
            len++;
            tmp = tmp.next;
        }

        tmp.next = new Node(data, tmp.next.next);
    }


    /**
     * 尾部插入
     *
     * @param data data
     */
    public void insertTail(Object data) {

        if (null == this.node) {
            init(data);
            return;
        }

        Node tmp = this.node;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new Node(data);
        len++;

    }

    /**
     * 头部插入
     *
     * @param data data
     */
    public void insertHead(Object data) {

        if (null == this.node) {
            init(data);
            return;
        }

        this.node = new Node(data, this.node);
        len++;
    }

    /**
     * 根据下标插入node
     *
     * @param i    下标
     * @param data data
     */
    public void insertByIndex(int i, Object data) {

        if (null == this.node) {
            init(data);
            return;
        }

        int len = 0;
        Node tmp = this.node;
        while (len != i && tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        tmp.next = new Node(data, tmp.next);
        this.len++;
    }

    /**
     * 从尾部删除
     */
    public void deleteTail() {
        int len = 0;
        Node tmp = this.node;
        while (len != this.len - 1) {
            tmp = tmp.next;
            len++;
        }
        tmp.next = null;
        this.len--;
    }

    /**
     * 从头部删除
     */
    public void deleteHead() {
        Node node = this.node;
        this.node = node.next;
    }

    /**
     * 指定索引删除
     * @param i 索引
     */
    public void deleteByIndex(int i) {
        int len = 0;
        Node node = this.node;
        while (len != (i - 1)) {
            node = node.next;
            len++;
        }
        node.next = node.next.next;
    }


    /**
     * 重新toString方法
     * @return string
     */
    @Override
    public String toString() {

        if (null == this.node) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        Node tmp = this.node;
        while (tmp.next != null) {
            builder.append("==>").append(tmp.data).append("\n");
            tmp = tmp.next;
        }
        builder.append("==>").append(tmp.data).append("\n");
        return builder.toString();
    }

    /**
     * 如果node节点为null，则初始化
     * @param data data
     */
    public void init(Object data) {
        this.node = new Node(data);
    }

    /**
     * 定义node节点
     */
    public static class Node {

        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println(singleLinkedList.toString());
        singleLinkedList.insertTail("1.张三");
        singleLinkedList.insertTail("2.李四");
        singleLinkedList.insertTail("3.王五");
        singleLinkedList.insertTail("4.张飞");

        System.out.println("尾部插入========>\n" + singleLinkedList.toString());

        singleLinkedList.insertHead("5.赵云");
        singleLinkedList.insertHead("6.关羽");

        System.out.println("头部插入========>\n" + singleLinkedList.toString());

        singleLinkedList.insertByIndex(3, "7.美猴王");

        System.out.println("指定中间插入========>\n" + singleLinkedList.toString());

        System.out.println("查找节点" + singleLinkedList.get(1) + "\n");

        singleLinkedList.update(3, "更新abc");
        System.out.println("更新\n" + singleLinkedList.toString());

        singleLinkedList.deleteTail();
        System.out.println("删除最后一行\n" + singleLinkedList.toString());

        singleLinkedList.deleteHead();
        System.out.println("删除第一行\n" + singleLinkedList.toString());

        singleLinkedList.deleteByIndex(1);
        System.out.println("删除指定\n" + singleLinkedList.toString());
    }
}

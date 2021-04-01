package com.elgchat.learning.data;

/**
 * @author jianghai
 */
public class ListNodeTest {


    public static void main(String[] args) {
        ListNode<String> listNode = new ListNode<String>();

        listNode.add("张三");
        listNode.add("李四");
        listNode.add("王五");
        listNode.add("赵四");
        listNode.add("baby");
        listNode.add("小青蛙");

        System.out.println(listNode);

        listNode.addByIndex(0,"哆啦A梦");
        System.out.println(listNode);

        listNode.addHead("abc");
        System.out.println(listNode);
    }
}

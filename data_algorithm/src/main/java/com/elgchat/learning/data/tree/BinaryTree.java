package com.elgchat.learning.data.tree;

/**
 * 二叉树实现
 */
public class BinaryTree {

    private static TreeNode treeNode;

    /**
     * 插入
     * @param data data
     */
    public static void insertNode(int data) {
        treeNode = insert(treeNode, data);
    }


    private static TreeNode insert(TreeNode treeNode, int data) {
        if (treeNode == null) {
            return new TreeNode(data, null, null);
        }

        if (data < treeNode.data) {
            treeNode.left = insert(treeNode.left, data);
        } else if (data > treeNode.data) {
            treeNode.right = insert(treeNode.right, data);
        } else {
            treeNode.data = data;
        }

        return treeNode;
    }

    /**
     * 前序遍历
     * @param treeNode treeNode
     */
    private static void preTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data);
        preTraverse(treeNode.left);
        preTraverse(treeNode.right);
    }

    /**
     * 中序遍历
     * @param treeNode treeNode
     */
    private static void inOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preTraverse(treeNode.left);
        System.out.println(treeNode.data);
        preTraverse(treeNode.right);
    }

    /**
     * 后序遍历
     * @param treeNode treeNode
     */
    private static void postOrderTraverse(TreeNode treeNode) {
        preTraverse(treeNode.left);
        preTraverse(treeNode.right);
        System.out.println(treeNode.data);
    }

    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public BinaryTree() {
    }

    public static void main(String[] args) {

        insertNode(5);
        insertNode(4);
        insertNode(3);
        insertNode(2);
        insertNode(6);
        insertNode(7);
        insertNode(8);

        System.out.println(treeNode.toString());

        System.out.println("=========前序========>");
        preTraverse(treeNode);
        System.out.println("=========中序========>");
        inOrderTraverse(treeNode);
        System.out.println("=========后序========>");
        postOrderTraverse(treeNode);
    }
}

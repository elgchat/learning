package com.elgchat.learning.data;


/**
 * 用数组实现的队列
 */
public class ArrayQueue {
    // 数组:items，数组大小:n
    int[] nums;
    // head表示队头下标，tail表示队尾下标
    int head = 0;
    int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int size) {
        nums = new int[size];
    }

    // 入队
    public boolean enqueue(int n) {
        // 如果tail == n 表示队列已经满了
        if (tail == nums.length) return false;
        nums[tail] = n;
        ++tail;
        return true;
    }

    // 出队
    public int dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return 0;
        int ret = nums[head];
        ++head;
        return ret;
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(8);
        aq.enqueue(3);
        aq.enqueue(5);
        aq.enqueue(1);
        aq.enqueue(4);
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
    }
}
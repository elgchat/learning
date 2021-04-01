package com.elgchat.learning.data.queue;

import java.util.Arrays;

/**
 * 数组模拟实现队列
 */
public class ArrayQueue {

    int[] nums = new int[8];
    int head = 0;
    int foot = 0;


    /**
     * 入队
     * @param num data
     */
    public void enqueue(int num) {
        nums[foot] = num;
        if (foot == nums.length - 1) {
            int[] newArray = new int[nums.length * 2];
            System.arraycopy(nums, 0, newArray, 0, nums.length);
            this.nums = newArray;
        }
        foot++;
    }

    /**
     * 出对
     * @return data
     */
    public int dequeue() {
        int num = nums[head];
        head++;
        if (head == foot) {
            nums = new int[8];
        }
        return num;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "nums=" + Arrays.toString(nums) +
                '}';
    }

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.toString());

        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println("====================>");
        System.out.println(arrayQueue.head);
        System.out.println(arrayQueue.foot);

        System.out.println(arrayQueue.toString());

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue((int) (Math.random() * 10));
        }
        System.out.println(arrayQueue.toString());
    }
}

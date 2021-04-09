package com.elgchat.learning.algorithm;

/**
 * 二分查找法实现
 */
public class BinarySearch {

    private static int binarySearch(int[] nums, int num) {

        int low = 0;
        int height = nums.length - 1;
        int mind;

        while (low <= height) {
            mind = (low + height) / 2;
            if (num == nums[mind]) {
                return mind;
            }
            if (num < nums[mind]) {
                height = mind - 1;
            } else {
                low = mind + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 11, 12, 13, 22, 23, 24, 33, 34, 35, 36};
        System.out.println(binarySearch(nums, 24));
    }

}

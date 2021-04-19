package com.elgchat.learning.algorithm;

/**
 * 二分查找法实现
 */
public class BinarySearch {

    private static int binarySearch(int[] nums, int num) {

        //低位
        int low = 0;
        //高位
        int height = nums.length - 1;
        //中间值
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

    private static int recursiveSearch(int[] nums, int num, int low, int height) {

        int mind = (low + height) / 2;
        if (nums[mind] == num) {
            return mind;
        }
        if (num < nums[mind]) {
            height = mind - 1;
        }
        if (num > nums[mind]) {
            low = mind + 1;
        }

        if (low == height) {
            return -1;
        }
        return recursiveSearch(nums, num, low, height);
    }

    private static int calculate(int[] nums) {
        //低位索引
        int low = 0;
        //高位索引
        int high = nums.length - 1;
        //中间索引
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            //偶数位
            if (mid % 2 == 0) {
                // 与后面的数相等
                if (nums[mid] == nums[mid + 1]) {
                    //前面的都对
                    low = mid + 1;
                    // 与前面的数相等
                } else if (nums[mid] == nums[mid - 1]) {
                    //后面的都对
                    high = mid - 1;
                    // 就是这个数
                } else {
                    return nums[mid];
                }
                //奇数位
            } else {
                // 与前面的数相等
                if (nums[mid] == nums[mid - 1]) {
                    //前面的都对
                    low = mid + 1;
                    //与后面的数相等
                } else if (nums[mid] == nums[mid + 1]) {
                    //后面的都对
                    high = mid - 1;
                    // 就是这个数
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 11, 12, 13, 22, 23, 24, 33, 34, 35, 36};
        System.out.println(binarySearch(nums, 24));
        System.out.println(recursiveSearch(nums, 12, 0, nums.length - 1));

        int[] num2 = {1, 1, 2, 2, 3, 3, 4, 5, 5};
        int[] num3 = {1, 1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(calculate(num3));
    }
}

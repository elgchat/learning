package com.elgchat.learning.algorithm;

/**
 * 递归实现
 */
public class Recursive {

    /**
     * 模拟计算
     *
     * @param num 参数num
     */
    public static int calculate(int num) {
        if (num <= 1) return num;
        return calculate(num - 1) + calculate(num - 2);
    }


    public static void main(String[] args) {
        System.out.println("斐波那契数列的前20项为：");
        for (int j = 1; j <= 20; j++) {
            System.out.print(calculate(j) + "\t");
            if (j % 5 == 0)
                System.out.println();
        }
    }
}

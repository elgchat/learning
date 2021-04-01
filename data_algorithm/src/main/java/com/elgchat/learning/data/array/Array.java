package com.elgchat.learning.data.array;

/**
 * 模拟数组操作
 */
public class Array {

    private int len;
    private int[] array = new int[8];

    public Array() {
        for (int i = 0; i < array.length - 2; i++) {
            array[i] = (int) (Math.random() * 100);
            len++;
        }
    }

    /**
     * get 方法
     * @param i 下标
     * @return data
     */
    public int get(int i) {
        return array[i];
    }

    /**
     * 更新数据
     * @param i 下标
     * @param value 更新的值
     */
    public void update(int i, int value) {

        if (i >= array.length) {
            System.out.println("数组越界");
            return;
        }
        array[i] = value;
    }

    /**
     * 尾部插入
     *
     * @param value 插入的值
     */
    public void insertTail(int value) {
        if (len == array.length) {
            System.out.println("触发扩容");
            resize();
        }
        array[len] = value;
        len++;
    }

    /**
     * 根据下标插入
     * @param i 下标
     * @param value 值
     */
    public void insertByIndex(int i, int value) {
        if (i >= array.length) {
            System.out.println("下标越界");
            return;
        }

        array[len] = array[len - 1];
        if (len - 1 - i >= 0) System.arraycopy(array, i, array, i + 1, len - 1 - i);
        array[i] = value;
        len ++;

    }

    /**
     * 根据下标删除
     * @param i 下标
     */
    public void deleteByIndex(int i) {

        if (i >= array.length) {
            System.out.println("下标越界");
            return;
        }
        for (; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        len--;
    }


    /**
     * 扩容
     */
    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        this.array = newArray;
    }


    /**
     * 获取数组长度
     *
     * @return array.length
     */
    public int arrayLength() {
        return array.length;
    }

    /**
     * 获取数组长度
     *
     * @return array.length
     */
    public int length() {
        return len;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(i).append("===>").append(array[i]).append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Array array = new Array();
        System.out.println("len:" + array.length());
        System.out.println("length:" + array.arrayLength());
        System.out.println(array.toString());

        array.update(5, 11);
        System.out.println("更新数值后===========>\n" + array.toString());

        for (int i = 0; i < 5; i++) {
            array.insertTail(211);
        }
        System.out.println("尾部插入后===========>\n" + array.toString());
        System.out.println("尾部插入后len：" + array.length() + "===>length:" + array.arrayLength());

        array.insertByIndex(3, 20);
        System.out.println("指定位置插入=========> \n" + array.toString());

        System.out.println("指定位置删除前" +array.get(3));

        array.deleteByIndex(3);
        System.out.println("指定位置删除==========> \n" + array.toString());

        System.out.println("指定位置删除前"+array.get(3));
    }
}

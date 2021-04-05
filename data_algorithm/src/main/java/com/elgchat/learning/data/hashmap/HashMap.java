package com.elgchat.learning.data.hashmap;

import java.util.Arrays;

public class HashMap {

    public Node[] data = new Node[10];
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;


    /**
     * put实现
     *
     * @param key   key
     * @param value 值
     */
    public void put(Object key, Object value) {
        key = key.toString();
        if (size >= data.length * DEFAULT_LOAD_FACTOR) {
            System.out.println("触发扩容");
            return;
        }

        int hash = hash(key);
        if (data[hash] == null) {
            data[hash] = new Node(hash, key, value);
        } else {
            Node datum = this.data[hash];
            while (datum.next != null) {
                datum = datum.next;
            }
            datum.next = new Node(hash, key, value);
        }
        size++;
    }

    /**
     * get 实现
     *
     * @param key key
     * @return data
     */
    public Object get(Object key) {
        key = key.toString();
        int hash = hash(key);

        if (data[hash] == null) {
            return null;
        }

        if (data[hash].next == null) {
            return data[hash].value;
        } else {
            Node datum = data[hash];
            while (datum.next != null && datum.key.equals(key)) {
                datum = datum.next;
            }
            Object value = datum.value;

            if (datum.next == null || datum.next.next == null || !value.equals(key)) {
                datum.next = null;
            } else {
                datum.next = datum.next.next;
            }
            size--;
            return value;
        }
    }

    int hash(Object key) {

//        hashmap 实现的hash
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 8);

        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "data=\n" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static class Node {
        private Object hash;
        private Object key;
        private Object value;
        private Node next;

        public Node(Object hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public Node(Object hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}' + "\n";
        }
    }


    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        //随机插入8条，为了达到阈值，触发扩容
//        for (int i = 0; i < 8; i++) {
//            //当i大于3时，key全部改为1，为了模拟hash碰撞
//            hashMap.put(i > 3 ? 1 : i, Math.random());
//        }
        hashMap.put(1,"李虎");
        hashMap.put(11,"赵四");
        hashMap.put(12,"张三");
        hashMap.put(21,"王五");
        hashMap.put(31,"唐七");
        hashMap.put(11,"赵四1");
        System.out.println(hashMap.toString());

        //输出指定
        System.out.println(hashMap.get(11));
    }
}

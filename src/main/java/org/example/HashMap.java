package org.example;


import java.util.ArrayList;
import java.util.LinkedList;


public class HashMap<K, V> {
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private LinkedList<Node>[] buckets;  // N = buckets.length

    public HashMap() {
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < N; i++)
            buckets[i] = new LinkedList<>();
    }

    public void put(K key, V value) {
        int bi = hashfun(key); //bucket index
        int di = getIndexWithinBucket(key, bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            node.value = value;
        } else {
            Node node = new Node(key, value);
            buckets[bi].add(node);
            size++;
        }
    }

    private int hashfun(K key) {
        int hc = key.hashCode();
        int comHC = Math.abs(hc) % buckets.length;

        return comHC; //compressed hash code = index
    }

    private int getIndexWithinBucket(K key, int bi) {
        int di = 0;
        for (Node node : buckets[bi]) {
            if (node.key.equals(key))
                return di;
            di++;
        }
        return -1;
    }

    public V get(K key) {
        int bi = hashfun(key);
        int di = getIndexWithinBucket(key, bi);
        if (di != -1) {
            Node node = buckets[bi].get(di);
            return node.value;
        } else {
            return null;
        }
    }

    public V remove(K key) {
        int bi = hashfun(key);
        int di = getIndexWithinBucket(key, bi);
        if (di != -1) {
            Node node = buckets[bi].remove(di);
            size--;
            return node.value;
        } else {
            return null;
        }
    }

    public boolean containsKey(K key) {
        int bi = hashfun(key);
        int di = getIndexWithinBucket(key, bi);
        if (di != -1) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (int bi = 0; bi < buckets.length; bi++) {
            for (Node node : buckets[bi]) {
                keys.add(node.key);
            }
        }

        return keys;
    }

    public int size() {
        return size;
    }

    public void display() {
        for (int bi = 0; bi < buckets.length; bi++) {
            for (Node node : buckets[bi]) {
                System.out.println(node.key + "-->" + node.value);
            }
        }
    }



}



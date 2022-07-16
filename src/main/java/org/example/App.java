package org.example;


import java.util.LinkedList;

public class App
{

    public static class HashMap<K,V>{

        private class Node{
            K key;
            V value;

            Node(K key, V value)
            {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private LinkedList<Node>[] buckets;  // N = buckets.length

        public HashMap(){
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N){
            buckets = new LinkedList[N];
            for(int i=0;i<N;i++)
                buckets[i] = new LinkedList<>();
        }


        public void put(K key, V value){
            int bi = hashfun(key); //bucket index
            int di = getIndexWithinBucket(key,bi);
        }

        private int hashfun(K key){
            int hc = key.hashCode();
            int comHC = Math.abs(hc) % buckets.length;

            return comHC; //compressed hash code = index
        }

        private int getIndexWithinBucket(K key,int bi){

        }

    }

}

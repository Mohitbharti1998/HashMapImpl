package org.example;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> map =  new HashMap<>();

        map.put("Mohit",1);
        map.put("Rohit",2);
        map.put("Ayush",3);

        map.remove("Rohit");

        map.display();
    }
}

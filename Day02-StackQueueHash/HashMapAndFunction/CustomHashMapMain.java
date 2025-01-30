/*Implement a Custom Hash Map
Problem: Design and implement a basic hash map class with operations for insertion, deletion, and retrieval.
Hint: Use an array of linked lists to handle collisions using separate chaining.*/

package day02stackqueuehash;

import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            bucket.removeIf(entry -> entry.key.equals(key));
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }
}

public class CustomHashMapMain {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Vidhi", 25);
        map.put("Kapil", 30);
        map.put("Yaman", 35);
        map.put("Mohit", 28); // Update value

        System.out.println("Vidhi's age: " + map.get("Vidhi"));
        System.out.println("Contains Kapil? " + map.containsKey("Kapil"));

        map.remove("Kapil");
        System.out.println("Contains Kapil after removal? " + map.containsKey("Kapil"));

        System.out.println("\nHashMap Contents:");
        map.display();
    }
}

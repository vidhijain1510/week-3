/*Problem Statement: Comparing Different Data Structures for Searching
Objective:
Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching elements.
Approach:
Array: Linear search (O(N)).
HashSet: Uses hashing (O(1) on average).
TreeSet: Balanced BST (O(log N)).

Comparative Analysis:
Dataset Size (N)      Array Search (O(N))    HashSet Search (O(1))       TreeSet Search (O(log N))
1,000                    1ms                     0.01ms                     0.1ms
100,000                 100ms                    0.01ms                     10ms
1,000,000                1s                      0.01ms                     20ms

Expected Result:
HashSet is fastest for lookups but requires extra memory.
TreeSet maintains order but is slightly slower than HashSet.*/

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class DataStructureSearchAnalysis{
    //Performing search in an array (O(N))
    public static boolean searchArray(int[] array, int key) {
        for (int num : array) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }

    //Performing search in a HashSet (O(1) on average)
    public static boolean searchHashSet(HashSet<Integer> set, int key) {
        return set.contains(key);
    }

    //Performing search in a TreeSet (O(log N))
    public static boolean searchTreeSet(TreeSet<Integer> set, int key) {
        return set.contains(key);
    }

    public static void measureSearchPerformance(int dataSize) {
        Random random = new Random();
        int[] array = random.ints(dataSize, 1, 1_000_000).toArray();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int num : array) {
            hashSet.add(num);
            treeSet.add(num);
        }

        int searchKey = array[random.nextInt(dataSize)];

        long startTime = System.nanoTime();
        searchArray(array, searchKey);
        long arraySearchTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        searchHashSet(hashSet, searchKey);
        long hashSetSearchTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        searchTreeSet(treeSet, searchKey);
        long treeSetSearchTime = System.nanoTime() - startTime;

        System.out.println("Data set: " + dataSize +
                " | Array Search: " + arraySearchTime / 1_000_000.0 + "ms" +
                " | HashSet Search: " + hashSetSearchTime / 1_000_000.0 + "ms" +
                " | TreeSet Search: " + treeSetSearchTime / 1_000_000.0 + "ms");
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 100_000, 1_000_000};
        for(int size : sizes){
            measureSearchPerformance(size);
        }
    }
}

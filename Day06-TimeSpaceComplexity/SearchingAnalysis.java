/*1. Problem Statement: Search a Target in a Large Dataset
Objective:
Compare the performance of Linear Search (O(N)) and Binary Search (O(log N)) on different dataset sizes.
Approach:
Linear Search: Scan each element until the target is found.
Binary Search: Sort the data first (O(N log N)), then perform O(log N) search.
Comparative Analysis:

Dataset Size (N)        Linear Search (O(N))      Binary Search (O(log N))
1,000                         1ms                     0.01ms
10,000                        10ms                    0.02ms
1,000,000                     1s                      0.1mms

Expected Result:
Binary Search performs much better for large datasets, provided data is sorted.
*/


import  java.util.*;

public class SearchingAnalysis {
    //Linear Search algorithm
    public static int linearSearch(int[] array, int target){
        for (int i = 0; i < array.length; i++){
            if(array[i]==target){
                return i;
            }
        }
        return -1;
    }

    //Binary Search algorithm
    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid]>target){
                right = mid-1;
            }
            if(array[mid]<target){
                left = mid+1;
            }
        }
        return -1;
    }

    //Method to measure the complexity of both the search
    static public void measureSearch(int dataSize){
        Random random = new Random( dataSize);
        int [] data = random.ints(dataSize, 1, 1_000_000).toArray();
        int target = data[random.nextInt(dataSize)];//random.nextInt(dataSize) gives a number between 0 and dataSize

        //Performing linear search
        long startTime = System.nanoTime();
        linearSearch(data, target);
        long linearSearchEndTime = System.nanoTime()-startTime;

        //Performing binary search
        Arrays.sort(data);
        startTime = System.nanoTime();
        binarySearch(data, target);
        long binarySearchEndTime = System.nanoTime() - startTime;

        //Displaying results
        System.out.println("Dataset size: " + dataSize + " | Linear Search: " + linearSearchEndTime/1_000_000.0+"ms" + " | Binary Search: " + binarySearchEndTime/1_000_000.0+"ms");

    }
    public static void main(String[] args) {
        int[] array = {1000, 10_000, 1_000_000};
        for (int arr : array) {
            measureSearch(arr);
        }
    }
}
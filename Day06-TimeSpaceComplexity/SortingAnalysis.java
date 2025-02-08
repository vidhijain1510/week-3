/*Problem Statement: Sorting Large Data Efficiently
Objective:
Compare sorting algorithms Bubble Sort (O(N²)), Merge Sort (O(N log N)), and Quick Sort (O(N log N)).
Approach:
Bubble Sort: Repeated swapping (inefficient for large data).
Merge Sort: Divide & Conquer approach (stable).
Quick Sort: Partition-based approach (fast but unstable).

Comparative Analysis:
Dataset Size (N)   Bubble Sort (O(N²))   Merge Sort (O(N log N))    Quick Sort (O(N log N))
 1,000                 50ms                     5ms                        3ms
10,000                  5s                      50ms                       30ms
1,000,000           Unfeasible (>1hr)           3s                          2s

Expected Result:
Bubble Sort is impractical for large datasets.
Merge Sort & Quick Sort perform well.
*/

import java.util.Arrays;
import java.util.Random;
public class SortingAnalysis{
    //Performing bubble sort (O(N²))
    static public int[] bubbleSort(int[] array){
        for(int i = 0; i<array.length-1;i++){
            for (int j = 0; j< array.length-1-i; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


    //Performing merge sort (O(N log N))
    static public int[] mergeSort(int[] array){
        divide(array, 0, array.length-1);
        return array;
    }
    //Method to divide the array
    static public void divide(int [] array, int startingIndex, int endingIndex) {
        if (startingIndex >= endingIndex) {
            return;
        }
        int mid = startingIndex + (endingIndex - startingIndex) / 2;
        divide(array, startingIndex, mid );
        divide(array, mid + 1, endingIndex); //Right sub array
        conquer(array, startingIndex, endingIndex, mid); //Left sub array
    }
    //Method to sort and merge the array
    static public void conquer(int[] array, int startingIndex, int endingIndex, int mid){
        int[] merged = new int[endingIndex-startingIndex+1];
        int index1= startingIndex;
        int index2 = mid+1;
        int x= 0;
        while(index1 <= mid && index2 <= endingIndex){
            if(array[index1] < array[index2]){
                merged[x++] = array[index1++];
            }else{
                merged[x++] = array[index2++];
            }
        }
        //Copying remaining elements of left subarray
        while (index1 <= mid){
            merged[x++] = array[index1++];
        }
        //Copying remaining elements of right subarray
        while (index2 <= endingIndex){
            merged[x++] = array[index2++];
        }

        //Copying merged elements back to the original array
        for(int i=0,j=startingIndex; i <merged.length;i++,j++){
            array[j]=merged[i];
        }
    }

    //Performing quick sort (O(N log N))
    static public void quickSort(int[] array, int low, int high){
        if(low<high){
            int pivotIndex = partition(array, low, high);
            quickSort(array,low,pivotIndex-1);
            quickSort(array,pivotIndex+1,high);
        }
    }

    static public int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low-1;
        //Traversing the array
        for(int j = low; j<high; j++){
            if(array[j]<pivot){
                i++;
                //swap
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        i++;
        int temp=array[i];
        array[i]=pivot;
        array[high]=temp;
        return i; //pivot index
    }

    static public void measureSort(int dataSize) {
        Random random = new Random();
        long endBubbleSortTime = 0;
        if (dataSize <= 10_000) {
            int[] data1 = random.ints(dataSize, 1, 1_000_000).toArray();
            //Performing bubble sort
            long startingTime = System.nanoTime();
            bubbleSort(data1);
            endBubbleSortTime = System.nanoTime() - startingTime;
        }
        int[] data2 = random.ints(dataSize, 1, 1_000_000).toArray();
        //Performing merge sort
        long startingTime = System.nanoTime();
        mergeSort(data2);
        long endMergeSortTime = System.nanoTime() - startingTime;

        int[] data3 = random.ints(dataSize, 1, 1_000_000).toArray();
        //Performing quick sort
        startingTime = System.nanoTime();
        quickSort(data3, 0, data3.length - 1);
        long endQuickSortTime = System.nanoTime() - startingTime;

        System.out.println("Data set: " + dataSize + (dataSize <= 10_000 ? " | Bubble Sort: " + endBubbleSortTime / 1_000_000.0 + "ms" : "") + " | Merge Sort: " + endMergeSortTime / 1_000_000.0 + "ms | Quick sort: " + endQuickSortTime / 1_000_000.0 + "ms");
    }


    public static void main(String[] args) {
        int [] array = {1000, 10_000, 1_000_000};
        for(int arr : array){
            measureSort(arr);
        }
    }
}
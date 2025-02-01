/*Heap Sort - Sort Job Applicants  by Salary
Problem Statement:
A company receives job applications with different expected salary demands.
Implement Heap Sort to sort these salary demands in ascending order.
Hint:
Build a Max Heap from the array.
Extract the largest element (root) and place it at the end.
Reheapify the remaining elements and repeat until sorted.
*/

import java.util.Arrays;
public class HeapSort {
    public static void sorting(int[] arr){
        int n = arr.length;
        //Building heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        //One by one extracting an element from heap
        for (int i = n - 1; i > 0; i--) {
            //Moving current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i){
        int largest = i;

        //left index = 2*i + 1
        int left = 2 * i + 1;

        //right index = 2*i + 2
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        //If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
    //Main Method
    public static void main(String[] args) {
        int[] salary = {85000, 900000, 50000000, 54220, 58000, 65000};
        sorting(salary);
        System.out.println(Arrays.toString(salary));
    }
}

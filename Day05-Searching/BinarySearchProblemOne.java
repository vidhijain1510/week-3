/*Binary Search Problem 1: Find the Rotation Point in a Rotated Sorted Array
Problem:
You are given a rotated sorted array. Write a program that performs Binary Search to find the index of the smallest element in
the array (the rotation point).
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[right], then the smallest element is in the right half, so update left = mid + 1.
If arr[mid] < arr[right], the smallest element is in the left half, so update right = mid.
Continue until left equals right, and then return arr[left] (the rotation point).
*/

public class BinarySearchProblemOne {

    //Method to find the rotation point in the given rotated array
    public static int binarySearch(int[] array, int low, int high){
        while(low<high){
            // Performing binary search
            int mid = low + high / 2;
            if(array[low]<array[high]){
                return array[low];
            }
            // The smallest element is in the right half so updating left = mid + 1.
            if(array[mid] > array[high]){
                low = mid + 1;
            }
            // The smallest element is in the left half so updating right = mid.
            if(array[mid] < array[high]){
                high = mid;
            }
        }
        return array[low];// The rotation point
    }
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 1, 2};//Rotated Array
        int low = 0;
        int high = array.length - 1;
        int results = binarySearch(array,low,high); //Calling method to find the rotation point in the array
        System.out.println(results);
    }
}

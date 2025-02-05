/*Binary Search Problem 2: Find the Peak Element in an Array
Problem:
A peak element is an element that is greater than its neighbors.
Write a program that performs Binary Search to find a peak element in an array.
If there are multiple peak elements, return any one of them.
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid] is a peak element.
If arr[mid] < arr[mid - 1], then search the left half, updating right = mid - 1.
If arr[mid] < arr[mid + 1], then search the right half, updating left = mid + 1.
Continue until a peak element is found.
*/
public class BinarySearchProblemTwo {

    //Method to find peak element in the integer array
    public static int binarySearch(int[] array){
        int left = 0;
        int right = array.length-1;
        while (left<=right) {
            int mid = (left+right)/2;

            //Checking if mid is a peak element
            if (mid > 0 && mid < array.length - 1) { //Ensuring mid is not at the boundaries
                if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                    return array[mid]; //Returning peak element
                } else if (array[mid] < array[mid - 1]) {
                    right = mid - 1; //Searching the left half
                } else {
                    left = mid + 1; //Searching the right half
                }
            }
            //Edge case handling for boundary elements
            else if (mid == 0 || mid == array.length - 1) {
                if (mid == 0 && array[mid] > array[mid + 1]) {
                    return array[mid]; // First element is a peak
                }
                if (mid == array.length - 1 && array[mid] > array[mid - 1]) {
                    return array[mid]; // Last element is a peak
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {2,5,7,8,10};
        int result = binarySearch(array);
        System.out.println(result);
    }
}

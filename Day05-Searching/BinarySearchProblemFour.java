/*Binary Search Problem 4: Find the First and Last Occurrence of an Element in a Sorted Array
Problem:
Given a sorted array and a target element, write a program that uses Binary Search to find the first and last occurrence of the target element in the array. If the element is not found, return -1.
Approach:
Use binary search to find the first occurrence:
Perform a regular binary search, but if the target is found, continue searching on the left side (right = mid - 1) to find the first occurrence.
Use binary search to find the last occurrence:
Similar to finding the first occurrence, but once the target is found, continue searching on the right side (left = mid + 1) to find the last occurrence.
Return the indices of the first and last occurrence. If not found, return -1.*/

public class BinarySearchProblemFour {

    //Function to find the first occurrence of the target element
    public static int findFirstOccurrence(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                result = mid;
                right = mid - 1;  //Searching to the left side
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    //Function to find the last occurrence of the target element
    public static int findLastOccurrence(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                result = mid;
                left = mid + 1;  //Searching to the right side
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    //Function to find both the first and last occurrence of the target element
    public static int[] findFirstAndLast(int[] array, int target) {
        int first = findFirstOccurrence(array, target);
        if (first == -1) {
            return new int[]{-1, -1};  //Target not found
        }
        int last = findLastOccurrence(array, target);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 3, 4, 5, 6};
        int target = 2;
        int[] result = findFirstAndLast(array, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}
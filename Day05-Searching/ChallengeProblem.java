/*Challenge Problem (for both Linear and Binary Search)
Problem:
You are given a list of integers. Write a program that uses Linear Search to find the first missing positive integer in the list and Binary Search to find the index of a given target number.
Approach:
Linear Search for the first missing positive integer:
Iterate through the list and mark each number in the list as visited (you can use negative marking or a separate array).
Traverse the array again to find the first positive integer that is not marked.
Binary Search for the target index:
After sorting the array, perform binary search to find the index of the given target number.
Return the index if found, otherwise return -1.*/


import java.util.Arrays;

public class ChallengeProblem {

    //Linear Search to find the first missing positive integer
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                //Swapping the elements to their correct positions
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        //Finding the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        //If all positions are filled correctly, the missing number is n + 1
        return n + 1;
    }

    //Binary Search to find the index of a target number
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;  //Target found returning its index
            }
            if (nums[mid] < target) {
                left = mid + 1;  //Searching in the right half
            } else {
                right = mid - 1;  //Searching in the left half
            }
        }

        return -1;  //Target not found
    }

    public static void main(String[] args) {
        int[] array1 = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + firstMissingPositive(array1));

        int[] array2 = {1, 3, 5, 7, 9};
        int target = 5;
        Arrays.sort(array2);  //Sorting is required for binary search
        System.out.println("Index of " + target + ": " + binarySearch(array2, target));

        target = 6;
        System.out.println("Index of " + target + ": " + binarySearch(array2, target));
    }
}


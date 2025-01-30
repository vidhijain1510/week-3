/*Sliding Window Maximum
Problem: Given an array and a window size k, find the maximum element in each sliding window of size k.
Hint: Use a deque (double-ended queue) to maintain indices of useful elements in each window.
*/
package day02stackqueuehash;

import java.util.*;
public class SlidingWindowMaximum {

    public int[] slidingWindowMaximum(int[] nums, int k) {
        //If the input array is empty or k is less than or equal to 0, return an empty array
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        //Result array to store the maximums of each window
        int[] result = new int[nums.length - k + 1];
        int r = 0;
        //Deque to store indices of elements in the current window
        Deque<Integer> deque = new LinkedList<>();
        //Processing each element in the array
        for (int i = 0; i < nums.length; i++) {
            //Removing indices that are out of the window's range (older than i - k)
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            //Removing all indices whose corresponding values are smaller than nums[i]
            // because they cannot be the maximum for any future window
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            //Adding current element's index to the deque
            deque.offerLast(i);

            //Once the first window is formed adding the max to the result
            if (i >= k - 1) {
                result[r++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1,2,5,8};
        int k = 2;
        int[] result = solution.slidingWindowMaximum(nums, k);
        System.out.println("Sliding window maximums: " + Arrays.toString(result));
    }
}
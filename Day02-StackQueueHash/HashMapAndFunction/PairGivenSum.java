/*Check for a Pair with Given Sum in an Array
Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
Hint: Store visited numbers in a hash map and check if target - current_number exists in the map.*/

package day02stackqueuehash;

import java.util.HashMap;
public class PairGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        //Using initial capacity to minimize resizing overhead
        HashMap<Integer, Integer> numMap = new HashMap<>((int) (nums.length / 0.75) + 1);
        for (int num : nums) {
            int complement = target - num;
            //Checking if the complement exists in the map
            if (numMap.containsKey(complement)) {
                return true;
            }
            //Storing the current number in the map
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        return false;
    }
    public static void main(String[] args) {
        int[] nums = {10, 15, 3, 7};
        int target = 17;
        System.out.println(hasPairWithSum(nums, target)); // Output: true
    }
}
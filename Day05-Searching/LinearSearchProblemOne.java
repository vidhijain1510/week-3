/*Linear Search Problem 1: Search for the First Negative Number
Problem:
You are given an integer array. Write a program that performs Linear Search to find the first negative number in the array.
If a negative number is found, return its index. If no negative number is found, return -1.
Approach:
Iterate through the array from the start.
Check if the current element is negative.
If a negative number is found, return its index.
If the loop completes without finding a negative number, return -1.
*/
public class LinearSearchProblemOne{

    //Method to Perform Linear Search
    public static int linearSearch(int[] array){
        for(int i=0; i< array.length;i++){//Iterating through the array from the start
            if(array[i]<0){//Checking if the current element is negative
                return i;//negative number is found, returning its index
            }
        }
        //Loop completes without finding a negative number, returns -1.
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {15, -1, 5, 4, -2};
        int index = linearSearch(array); //Calling method LinearSearch
        if(index == -1){
            System.out.println("Negative element is not present in array!");
        }else{
            System.out.println("First negative element is at: " + index);
        }
    }
}

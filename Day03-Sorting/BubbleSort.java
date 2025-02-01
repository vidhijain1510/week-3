/*Bubble Sort - Sort Student Mark
Problem Statement:
A school maintains student marks in an array. Implement Bubble Sort to sort the student marks in ascending order.
Hint:
Traverse through the array multiple times.
Compare adjacent elements and swap if needed.
Repeat the process until no swaps are required.
*/

import java.util.Arrays;
public class BubbleSort{
    //Method to sort the array through bubble sort
    public static int[] sorting(int [] array){
        //Traversing through the array multiple times.
        for(int i = 0; i< array.length-1; i++) {
            //Repeating the process until no swaps are required
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    //Comparing adjacent elements and swaping if needed.
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        //Returning the array
        return array;
    }

    //Main Method
    public static void main(String[] args) {
        //Array of marks of student
        int[] studentMarks = {90, 85 ,52, 68, 21, 15, 48};
        System.out.println("Original Array: " + Arrays.toString(studentMarks));//Printing original array
        sorting(studentMarks);//Calling method to sort
        System.out.println("Sorted Array: " + Arrays.toString(studentMarks));//Printing sorted array
    }
}

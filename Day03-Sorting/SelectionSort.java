/*Selection Sort - Sort Exam Scores
Problem Statement:
A university needs to sort students’ exam scores in ascending order. Implement Selection Sort to achieve this.
Hint:
Find the minimum element in the array.
Swap it with the first unsorted element.
Repeat the process for the remaining elements.
*/

import java.util.Arrays;
public class SelectionSort {
    //Method to sort the element
    public static int[] sorting(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;//Variable to store the index of minimum element in an array
            for (int j = i + 1; j < array.length; j++) {
                //To find minimum element in the array.
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            //Swapping element
            int temp = array[i];
            array[i] = array[minElementIndex];
            array[minElementIndex] = temp;
        }
        return array; //Returns sorted array
    }
    //Main Method
    public static void main(String[] args) {
        int[] examScores = {15, 85, 95 ,46, 72, 79, 25, 53};
        sorting(examScores); //Calling method to sort exam scores
        System.out.println(Arrays.toString(examScores));
    }
}

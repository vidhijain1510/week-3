

/*Insertion Sort - Sort Employee IDs
Problem Statement:
A company stores employee IDs in an unsorted array. Implement Insertion Sort to sort the employee IDs in ascending order.
Hint:
Divide the array into sorted and unsorted parts.
Pick an element from the unsorted part and insert it into its correct position in the sorted part.
Repeat for all elements.
*/
import java.util.Arrays;
public class InsertionSort {

    public static int[] sorting(int[] array){
        //Dividing the array into sorted and unsorted parts.
        for(int i = 1;  i<array.length; i++){
            int current = array[i];
            int j = i-1;
            while(j>=0 && current < array[j]){
                    array[j+1]=array[j];
                    j--;
            }
            //Picking an element from the unsorted part and insert it into its correct position in the sorted part.
            array[j+1]=current;
        }
        return array;
    }


    public static void main(String[] args) {
        int[] employeeID = {101, 150, 23, 78, 85, 91};
        System.out.println("Original Array: " + Arrays.toString(employeeID));
        sorting(employeeID);//Calling method to sort the array
        System.out.println("Sorted Array: " + Arrays.toString(employeeID));
    }
}

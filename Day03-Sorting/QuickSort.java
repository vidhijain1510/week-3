/*Quick Sort - Sort Product Prices
Problem Statement:
An e-commerce company wants to display product prices in ascending order. Implement Quick Sort to sort the product prices.
Hint:
Pick a pivot element (first, last, or random).
Partition the array such that elements smaller than the pivot are on the left and larger ones are on the right.
Recursively apply Quick Sort on left and right partitions.
*/

import java.util.Arrays;
public class QuickSort {

    //Method that return pivot value
    public static int partition(double[] array, int low, int high){
        double pivot = array[high];
        int i =low -1;
        for(int j = low; j<high; j++){
            if(array[j]<=pivot){
                i++;
                //Swapping if element is less than pivot
                double temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        i++;
        //Swapping if there is element greater than pivot
        double temp = array[i];
        array[i]=pivot;
        array[high]=temp;
        return i;//pivot index
    }

    //Method to sort the prices
    public static void sorting(double[] array, int low, int high){
        if(low<high){
            int pivotIndex = partition(array,low,high);
            sorting(array, low , pivotIndex-1);
            sorting(array,pivotIndex+1,high);
        }
    }

    //Main Method
    public static void main(String[] args) {
        double[] productPrices = {1,1.5,1524,4875,542,2112,54};
        sorting(productPrices,0, productPrices.length-1);
        System.out.println(Arrays.toString(productPrices));

    }
}
/*Merge Sort - Sort an Array of Book Prices
Problem Statement:
A bookstore maintains a list of book prices in an array. Implement Merge Sort to sort the prices in ascending order.
Hint:
Divide the array into two halves recursively.
Sort both halves individually.
Merge the sorted halves by comparing elements.
 */

import java.util.Arrays;
public class MergeSort {
    //Method to divide the array
    public static void divide(double[] array, int si, int ei){//si = Starting index, ei = Ending index
        if(si==ei){
            return;
        }
        int mid = si + (ei - si)/2;
        divide(array, si, mid);
        divide(array, mid+1, ei);
        conquer(array,si,mid,ei);
    }

    //Method to sort the array and merge it
    public static void conquer(double[] array, int si, int mid, int  ei){
        //Declaring a merged array to store sorted array
        double[] merged = new double[ei - si + 1];
        int index1 = si;
        int index2 = mid+1;
        int x = 0;
        while (index1 <= mid && index2 <=ei){
            if(array[index1]<=array[index2]){
                merged[x++]=array[index1++];
            }else {
                merged[x++]=array[index2++];
            }
        }

        //Looping through the element to add all the element
        while (index1<=mid){
            merged[x++] = array[index1++];
        }
        while (index2<=ei){
            merged[x++] = array[index2++];
        }
        for(int i =0,j=si;i<merged.length;i++,j++){
            array[j] = merged[i];
        }
    }

    //Main Method
    public static void main(String[] args) {
        double[] bookPrices = {250,150,285,465,500,110,325};
        divide(bookPrices,0, bookPrices.length-1);//Calling method to sort the array of book prices
        System.out.println(Arrays.toString(bookPrices));
    }
}

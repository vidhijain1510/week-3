/*Binary Search Problem 3: Search for a Target Value in a 2D Sorted Matrix
Problem:
You are given a 2D matrix where each row is sorted in ascending order,
and the first element of each row is greater than the last element of the previous row.
Write a program that performs Binary Search to find a target value in the matrix. If the value is found, return true.
Otherwise, return false.

Approach:
Treat the matrix as a 1D array (flattened version).
Initialize left as 0 and right as rows * columns - 1.
Perform binary search:
Find the middle element index mid = (left + right) / 2.
Convert mid to row and column indices using row = mid / numColumns and col = mid % numColumns.
Compare the middle element with the target:
If it matches, return true.
If the target is smaller, search the left half by updating right = mid - 1.
If the target is larger, search the right half by updating left = mid + 1.
If the element is not found, return false.*/

public class BinarySearchProblemThree{

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;  //If matrix is empty
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        //Initializing left and right pointers
        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            //Converting mid index to row and column
            int row = mid / columns;
            int col = mid % columns;

            //Comparing the element at the calculated row and column with the target
            if (matrix[row][col] == target) {
                return true;  // Target found
            }
            else if (matrix[row][col] < target) {
                left = mid + 1;  //Moving to the right half
            }
            else {
                right = mid - 1;  //Moving to the left half
            }
        }

        return false;  //Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target found: " + result);

        target = 13;
        result = searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}


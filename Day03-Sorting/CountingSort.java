/*Counting Sort - Sort Student Age
Problem Statement:
A school collects students’ ages (ranging from 10 to 18) and wants them sorted. Implement Counting Sort for this task.
Hint:
Create a count array to store the frequency of each age.
Compute cumulative frequencies to determine positions.
Place elements in their correct positions in the output array.
*/
import java.util.Arrays;
public class CountingSort {

    public static int[] countingSortAges(int[] studentsAges) {
        // The ages range from 10 to 18, so we need an array of size 9
        int[] count = new int[9]; // count[i] will store the frequency of age (i + 10)

        // Step 1: Store the frequency of each age in the count array
        for (int age : studentsAges) {
            count[age - 10]++; // Increment the count for the corresponding age
        }

        // Step 2: Compute cumulative frequencies in the count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in the output array in sorted order
        int[] output = new int[studentsAges.length];

        // Traverse the original array in reverse order for stable sorting
        for (int i = studentsAges.length - 1; i >= 0; i--) {
            int age = studentsAges[i];
            output[count[age - 10] - 1] = age;
            count[age - 10]--; // Decrease the count to place the next element correctly
        }

        return output;
    }

    public static void main(String[] args) {
        int[] studentsAges = {16, 12, 18, 14, 12, 16, 15, 18, 17};
        int[] sortedAges = countingSortAges(studentsAges);
        System.out.println("Sorted Ages: " + Arrays.toString(sortedAges));
    }
}

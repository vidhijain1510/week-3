/*StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation
Problem:
Write a program that compares the performance of StringBuffer and StringBuilder for concatenating strings.
For large datasets (e.g., concatenating 1 million strings), compare the execution time of both classes.
Approach:
Initialize two StringBuffer and StringBuilder objects.
Perform string concatenation in both objects, appending 1 million strings (e.g., "hello").
Measure the time taken to complete the concatenation using System.nanoTime() for both StringBuffer and StringBuilder.
Output the time taken by both classes for comparison.
 */
public class StringBufferProblemTwo{
    public static void main(String[] args) {
        //Number of iterations (1 million)
        int iterations = 1000000;

        //Measuring time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBufferObject = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBufferObject.append("hello");
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        //Measuring time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilderObject = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilderObject.append("hello");
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        //Results
        System.out.println("StringBuffer: " + durationBuffer + " nanoseconds.");
        System.out.println("StringBuilder: " + durationBuilder + " nanoseconds.");
    }
}


/*Problem Statement: String Concatenation Performance
Objective:
Compare the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating a million strings.
Approach:
Using String (Immutable, creates new object each time)
Using StringBuilder (Fast, mutable, thread-unsafe)
Using StringBuffer (Thread-safe, slightly slower than StringBuilder)

Comparative Analysis:
Operations Count (N)       String (O(N²))           StringBuilder (O(N))           StringBuffer (O(N))
1,000                          10ms                      1ms                           2ms
10,000                          1s                       10ms                          12ms
1,000,000                   30m (Unusable)               50ms                          60ms

Expected Result:
StringBuilder & StringBuffer are much more efficient than String.
Use StringBuilder for single-threaded operations and StringBuffer for multithreaded.
*/

public class StringConcatenationAnalysis {
    //Performing Concatenation using string
    public static double usingString(int size){
        String results = "";
        long startTime = System.nanoTime();
        for (int i=0; i<size; i++){
            results += "a"; //Creates a new String object every iteration (O(n^2) complexity)
        }
        long endTimeUsingString = System.nanoTime() - startTime;
        return endTimeUsingString/1_000_000.0;
    }

    //Performing Concatenation using String builder
    public static double usingStringBuilder(int size){
        StringBuilder results = new StringBuilder();
        long startTime = System.nanoTime();
        for(int i = 0; i<size; i++){
            results.append("a"); //Appends efficiently without creating new objects
        }
        long endTimeUsingStringBuilder = System.nanoTime() - startTime;
        return endTimeUsingStringBuilder/1_000_000.0;
    }

    //Performing Concatenation using String buffer
    public static double usingStringBuffer(int size){
        StringBuffer results = new StringBuffer();
        long startTime = System.nanoTime();
        for(int i = 0; i<size; i++){
            results.append("a"); //Thread-safe but has additional synchronization overhead
        }
        long endTimeUsingStringBuffer = System.nanoTime() - startTime;
        return endTimeUsingStringBuffer/1_000_000.0;
    }
    public static void main(String[] args) {
        int[] dataSetSizes = {1000, 10_000, 1_000_000}; //Different dataset sizes to measure performance
        for(int size : dataSetSizes){
            System.out.println("Data set: " + size + " | Concatenation using string: " + usingString(size) + "ms | Concatenation using StringBuilder: " + usingStringBuilder(size) + "ms | Concatenation using StringBuffer: " + usingStringBuffer(size) + "ms");
        }
    }
}

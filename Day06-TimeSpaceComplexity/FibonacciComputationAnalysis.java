/*Problem Statement: Recursive vs Iterative Fibonacci Computation
Objective:
Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
Approach:
Recursive:
public static int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

Iterative:
public static int fibonacciIterative(int n) {
    int a = 0, b = 1, sum;
    for (int i = 2; i <= n; i++) {
        sum = a + b;
        a = b;
        b = sum;
    }
    return b;
}
Comparative Analysis:
Fibonacci (N)    Recursive (O(2ⁿ))     Iterative (O(N))
10                  1ms                  0.01ms
30                  5s                   0.05ms
50              Unfeasible (>1hr)        0.1ms

Expected Result:
Recursive approach is infeasible for large values of N due to exponential growth.
The iterative approach is significantly faster and memory-efficient.
 */


public class FibonacciComputationAnalysis {
    //Recursive Approach (O(2ⁿ))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    //Iterative Approach (O(N))
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] iterations = {10, 30, 50};
        for(int i : iterations){
            long startTime, endTime;

            //Measuring recursive execution time
            if (i <= 30) { // Limiting due to inefficiency with 50
                startTime = System.nanoTime();
                int fibRecursive = fibonacciRecursive(i);
                endTime = System.nanoTime();
                System.out.print("Fibonacci(" + i + ") | Recursive Time: " + (endTime - startTime) / 1_000_000.0 + "ms");
            } else {
                System.out.print("Fibonacci(" + i + ") | Recursive: Unfeasible");
            }
            //Measuring iterative execution time
            startTime = System.nanoTime();
            int fibIterative = fibonacciIterative(i);
            endTime = System.nanoTime();
            System.out.println(" | Iterative Time: " + (endTime - startTime) / 1_000_000.0 + "ms");
        }
    }
}
/*Stock Span Problem
Problem: For each day in a stock price array, calculate the span
(number of consecutive days the price was less than or equal to the current day's price).
Hint: Use a stack to keep track of indices of prices in descending order.*/
package day02stackqueuehash;

import java.util.Stack;
public class StockSpan {
    public static int[] calculateSpan(int[] prices){
        int n = prices.length;
        //stack to keep track of indices of prices in descending order
        Stack<Integer> stackToKeepIndices = new Stack<>();
        //Array span to store the span value
        int[] span = new int[n];
        for(int i = 0; i < n ; i++) {
            while(!stackToKeepIndices.isEmpty() && prices[stackToKeepIndices.peek()] <= prices[i]) {
                stackToKeepIndices.pop();
            }
            //if array span is empty then the span value should be 1
            span[i] = stackToKeepIndices.isEmpty()? (i+1):(i-stackToKeepIndices.peek());
            //pushing the last index in the stack
            stackToKeepIndices.push(i);
        }
        return span;
    }
    public static void main(String[] args){
        int [] prices = {100,80,60,70,60,75,85};
        int[] span = calculateSpan(prices);
        for(int i = 0; i < span.length; i++){
            System.out.println("The span value at " + prices[i] + " : " + span[i]);
        }
    }
}
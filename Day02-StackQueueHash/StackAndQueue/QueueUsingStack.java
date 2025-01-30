/*Implement a Queue Using Stacks
Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed.*/

package day02stackqueuehash;
import java.util.Stack;
class QueueUsingStacks {
    private Stack<Integer> stackIn;  //Stack for enqueue
    private Stack<Integer> stackOut; //Stack for dequeue

    public QueueUsingStacks() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    //Enqueue operation Push to stackIn
    public void enqueue(int x) {
        stackIn.push(x);
    }

    //Dequeue operation Pop from stackOut, transferring from stackIn if necessary
    public int dequeue() {
        if (stackOut.isEmpty()) {
            //Transfer elements from stackIn to stackOut, reversing the order
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        //If stackOut is still empty, the queue is empty
        if (stackOut.isEmpty()) {
            System.err.println("Queue is empty!");
        }

        //Pop the front of the queue from stackOut
        return stackOut.pop();
    }

    //Peek operation: Look at the front of the queue
    public int peek() {
        if (stackOut.isEmpty()) {
            //Transfer elements from stackIn to stackOut if stackOut is empty
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        //If stackOut is empty, the queue is empty
        if (stackOut.isEmpty()) {
            System.err.println("Queue is empty!");
        }

        //Returning the front element without removing it
        return stackOut.peek();
    }

    //Checks if the queue is empty
    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    //Print the contents of the queue
    public void print() {
        //print elements from stackOut (the front part of the queue)
        for (int i = stackOut.size() - 1; i >= 0; i--) {
            System.out.print(stackOut.get(i) + " ");
        }

        //print elements from stackIn (the back part of the queue)
        for (int i = 0; i < stackIn.size(); i++) {
            System.out.print(stackIn.get(i) + " ");
        }

        System.out.println();
    }
}
public class QueueUsingStack {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.peek());
        queue.enqueue(4);
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println("Both is empty: " + queue.isEmpty());
    }
}
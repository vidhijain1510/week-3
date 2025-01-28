/*Doubly Linked List: Undo/Redo Functionality for Text Editor
Problem Statement: Design an undo/redo functionality for a text editor using a doubly linked list. Each node represents a state of the text content (e.g., after typing a word or performing a command). Implement the following:
Add a new text state at the end of the list every time the user types or performs an action.
Implement the undo functionality (revert to the previous state).
Implement the redo functionality (revert back to the next state after undo).
Display the current state of the text.
Limit the undo/redo history to a fixed size (e.g., last 10 states).
Hint:
Use a doubly linked list where each node represents a state of the text.
The next pointer will represent the forward history (redo), and the prev pointer will represent the backward history (undo).
Keep track of the current state and adjust the next and prev pointers for undo/redo operations.*/

class TextEditorUndoRedo {
    private static class Node {
        String text;
        Node prev, next;

        Node(String text) {
            this.text = text;
        }
    }

    private Node head, tail, current;
    private final int MAX_HISTORY; //Maximum number of stored states
    private int size;

    //Constructor to initialize history size
    public TextEditorUndoRedo(int maxHistory) {
        this.MAX_HISTORY = maxHistory;
        this.size = 0;
    }

    //Method to add a new text state to history
    public void addTextState(String text) {
        Node newNode = new Node(text);

        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        } else {
            head = newNode; //First state
        }

        current = newNode;
        tail = newNode; //Last state
        size++;

        //Maintain max history size by removing the oldest state if necessary
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    //Method to undo the last operation
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.text);
        } else {
            System.out.println("No more undo operations available.");
        }
    }

    //Method to redo an undone operation
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.text);
        } else {
            System.out.println("No more redo operations available.");
        }
    }

    //Method to display the current text state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No text history available.");
        }
    }
}

public class DoublyLinkedListUndoRedo {
    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo(10);

        //Adding text states to the editor
        editor.addTextState("Text Editor Initialized");
        editor.addTextState("Added First Line");
        editor.addTextState("Added Second Line");
        editor.addTextState("Corrected Typo in Second Line");
        editor.displayCurrentState();

        //Perform undo operations
        editor.undo(); // Undo last state
        editor.displayCurrentState();
        editor.undo(); //Undo again
        editor.displayCurrentState(); //Added First Line

        //Perform redo operation
        editor.redo(); //Redo last undone state
        editor.displayCurrentState(); //Added Second Line
    }
}

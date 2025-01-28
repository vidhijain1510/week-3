/*Circular Linked List: Task Scheduler
Problem Statement: Create a task scheduler using a circular linked list. Each node in the list represents a task with Task ID, Task Name, Priority, and Due Date. Implement the following functionalities:
Add a task at the beginning, end, or at a specific position in the circular list.
Remove a task by Task ID.
View the current task and move to the next task in the circular list.
Display all tasks in the list starting from the head node.
Search for a task by Priority.
Hint:
Use a circular linked list where the last node’s next pointer points back to the first node, creating a circular structure.
Ensure that the list loops when traversed from the head node, so tasks can be revisited in a circular manner.
When deleting or adding tasks, maintain the circular nature by updating the appropriate next pointers.*/


class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    //Constructor
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularLinkedList {
    private TaskNode head;

    public CircularLinkedList() {
        head = null;
    }

    //Adding a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Circular link
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head; // Circular link
            head = newTask;
        }
    }

    //Adding a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; //Circular link
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head; //Circular link
        }
    }

    //Adding a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode temp = head;
        int count = 0;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
            if (temp == head) break; //Preventing infinite loop in case of a circular list
        }

        if (temp != null) {
            newTask.next = temp.next;
            temp.next = newTask;
        } else {
            System.out.println("Invalid position.");
        }
    }

    //Removing a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) return;

        TaskNode temp = head;
        TaskNode prev = null;
        do {
            if (temp.taskId == taskId) {
                if (prev == null) { //Removing the head node
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head.next == head) { //Only one element in the list
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head; //Circular link
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task ID not found.");
    }

    //Viewing the current task (Head node) and move to the next task
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode temp = head;
        System.out.println("Current Task: " + temp.taskName + " (ID: " + temp.taskId + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate + ")");
    }

    //Displaying all tasks in the list
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available...");
            return;
        }
        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + " |  Name: " + temp.taskName + " |  Priority: " + temp.priority + " |  Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    //Searching tasks by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available...");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task found - ID: " + temp.taskId + " |  Name: " + temp.taskName + " |  Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        CircularLinkedList taskList = new CircularLinkedList();
        taskList.addTaskAtEnd(1, "Task 1", 2, "2025-01-31");
        taskList.addTaskAtEnd(2, "Task 2", 1, "2025-02-05");
        taskList.addTaskAtBeginning(3, "Task 3", 3, "2025-01-29");
        taskList.addTaskAtPosition(1, 4, "Task 4", 1, "2025-02-10");
        taskList.displayAllTasks();
        taskList.viewCurrentTask();
        taskList.searchTaskByPriority(1);
        taskList.removeTaskById(2);
        taskList.displayAllTasks();
    }
}

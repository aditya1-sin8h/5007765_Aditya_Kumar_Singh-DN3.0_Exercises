class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class TaskManagementSystem {
    private Node head;
    private int size;

    // Node class for singly linked list
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public TaskManagementSystem() {
        this.head = null;
        this.size = 0;
    }

    // Add a task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Search for a task by ID
    public Task searchTaskById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTaskById(int taskId) {
        Node current = head;
        Node previous = null;

        while (current != null && current.task.getTaskId() != taskId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task with ID " + taskId + " not found.");
            return;
        }

        if (previous == null) {
            head = current.next; // Removing the head
        } else {
            previous.next = current.next; // Bypassing the node to delete
        }
        size--;
    }
}

public class TaskManagement {
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        // Adding tasks
        tms.addTask(new Task(1, "Design Database", "In Progress"));
        tms.addTask(new Task(2, "Implement API", "Not Started"));
        tms.addTask(new Task(3, "Write Tests", "Completed"));

        // Traversing tasks
        System.out.println("All Tasks:");
        tms.traverseTasks();

        // Searching for a task
        Task task = tms.searchTaskById(2);
        System.out.println("Search Result: " + (task != null ? task : "Task not found"));

        // Deleting a task
        tms.deleteTaskById(2);

        // Traversing tasks after deletion
        System.out.println("All Tasks after deletion:");
        tms.traverseTasks();
    }
}

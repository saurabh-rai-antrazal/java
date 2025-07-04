import java.util.*;

public class TaskData {

    private final Set<Task> tasks = new TreeSet<>();

    public TaskData() {
        loadSampleData();
    }

    private void loadSampleData() {
        tasks.add(new Task("Manager", "InventoryApp", "Database schema design",
                Task.Status.ASSIGNED, Task.Priority.HIGH));
        tasks.add(new Task("Manager", "InventoryApp", "Login module",
                Task.Status.NOT_ASSIGNED, Task.Priority.MEDIUM));

        // Tasks by Ann
        tasks.add(new Task("Ann", "HRTool", "Employee dashboard",
                Task.Status.IN_PROGRESS, Task.Priority.HIGH));
        tasks.add(new Task("Ann", "HRTool", "Admin settings",
                Task.Status.ASSIGNED, Task.Priority.MEDIUM));

        // Tasks by Bob
        tasks.add(new Task("Bob", "FinanceApp", "Tax module",
                Task.Status.ASSIGNED, Task.Priority.HIGH));
        tasks.add(new Task("Bob", "FinanceApp", "Budget planner",
                Task.Status.ASSIGNED, Task.Priority.LOW));

        // Tasks by Carol
        tasks.add(new Task("Carol", "MarketingTool", "Campaign tracker",
                Task.Status.IN_PROGRESS, Task.Priority.MEDIUM));
        tasks.add(new Task("Carol", "MarketingTool", "Analytics dashboard",
                Task.Status.IN_PROGRESS, Task.Priority.HIGH));
    }

    public Set<Task> getTasks(String assigneeName) {
        if (assigneeName.equalsIgnoreCase("all")) {
            return new TreeSet<>(tasks);
        }

        Set<Task> filteredTasks = new TreeSet<>();
        for (Task task : tasks) {
            if (task.getAssignee().equalsIgnoreCase(assigneeName)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}

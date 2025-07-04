public class Main {
    public static void main(String[] args) {
        TaskData taskData = new TaskData();

        System.out.println("All Tasks:");
        taskData.getTasks("all").forEach(System.out::println);

        System.out.println("\nTasks by Ann:");
        taskData.getTasks("Ann").forEach(System.out::println);
    }
}

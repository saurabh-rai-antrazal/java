package day28.Lec209;

import java.util.Objects;

public class Task implements Comparable<Task> {

    public enum Status {
        NOT_ASSIGNED, ASSIGNED, IN_PROGRESS
    }

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    private String assignee;
    private String projectName;
    private String description;
    private Status status;
    private Priority priority;

    public Task(String assignee, String projectName, String description,
                Status status, Priority priority) {
        this.assignee = assignee;
        this.projectName = projectName;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "assignee='" + assignee + '\'' +
                ", project='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}

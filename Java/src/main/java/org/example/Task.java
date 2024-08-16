package org.example;

import java.util.Date;

public class Task {
    private String taskId;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private String taskDescription;
    private String taskTitle;
    private Date date;
    private String taskAssignerId;
    private User user;

    public Task(String taskId, TaskStatus taskStatus, TaskPriority taskPriority, String taskDescription, String taskTitle, Date date, String taskAssignerId, User user) {
        this.taskId = taskId;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
        this.taskDescription = taskDescription;
        this.taskTitle = taskTitle;
        this.date = date;
        this.taskAssignerId = taskAssignerId;
        this.user = user;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTaskAssignerId() {
        return taskAssignerId;
    }

    public void setTaskAssignerId(String taskAssignerId) {
        this.taskAssignerId = taskAssignerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskPriority=" + taskPriority +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskTitle='" + taskTitle + '\'' +
                ", date=" + date +
                ", taskAssignerId='" + taskAssignerId + '\'' +
                ", user=" + user +
                '}';
    }
}

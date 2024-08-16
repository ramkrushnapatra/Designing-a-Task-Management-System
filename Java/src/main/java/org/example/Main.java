package org.example;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user1 = new User("userId1","ram","ram@gmail.com");
        User user2 = new User("userId2","hari","hari@gmail.com");
        Task task1 = new Task("taskId1",TaskStatus.CREATED,TaskPriority.HIGH,"Engineering Excellence",
                "mutual fund",new Date(), user1.getUserId(), user1);
        Task task2  = new Task("taskId2",TaskStatus.CREATED,TaskPriority.MEDIUM,"Operational Excellence",
                "stockBroking",new Date(), user2.getUserId(), user2);
        Task task3  = new Task("taskId3",TaskStatus.COMPLETED,TaskPriority.MEDIUM,"Operational Excellence",
                "stockBroking",new Date(), user1.getUserId(), user1);

        TaskManager taskManager = TaskManager.getInstance();
        taskManager.createTask(task1, user1.getUserId());
        taskManager.createTask(task3, user1.getUserId());
        taskManager.createTask(task2, user2.getUserId());
        taskManager.checkTaskStatus(user1.getUserId(), task1.getTaskId());
        taskManager.checkTaskStatus(user2.getUserId(), task2.getTaskId());
        taskManager.updateTask(user1.getUserId(), task1.getTaskId(), TaskStatus.PROGRESS);
        taskManager.checkTaskStatus(user1.getUserId(), task1.getTaskId());
        taskManager.checkTaskStatus(user1.getUserId(), task3.getTaskId());
//        taskManager.checkAllTask(user1.getUserId());
        List<Task> Task =taskManager.filterAndSearch(new Date(0),new Date(),TaskPriority.MEDIUM, TaskStatus.CREATED);
       for(Task task: Task){
           System.out.println(task);
       }



    }
}
package org.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManager {
    private static TaskManager instance;
    private Map<String, List<Task>> taskAssignDetails;

    public TaskManager(){
        taskAssignDetails = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManager getInstance(){
        if(instance == null){
            instance = new TaskManager();
        }
        return instance;
    }

    public void createTask(Task task,String userId) {
        synchronized (this){
            List<Task>listOfTask = taskAssignDetails.get(userId);
            if(listOfTask == null)
            {
                listOfTask = new ArrayList<>();
            }
            listOfTask.add(task);
            taskAssignDetails.put(userId,listOfTask);
            System.out.println("Task Created SuccessFull");
        }
    }

    public void updateTask(String userId, String taskId, TaskStatus taskStatus) {
        synchronized (this){
            List<Task> listOfTask = taskAssignDetails.get(userId);
            if (listOfTask.size() == 0){
                System.out.println("Task is not Found{}"+taskId);
                return;
            }
            for(Task task :listOfTask){
                if(Objects.equals(taskId, task.getTaskId())){
                    task.setTaskStatus(taskStatus);
                    taskAssignDetails.put(userId, listOfTask);
                    break;
                }
            }
        }
        System.out.println("Task Status SuccessFully Updated");
    }

    public void checkTaskStatus(String userId, String taskId) {
        synchronized (this){
            List<Task> listOfTask = taskAssignDetails.get(userId);
            if (listOfTask.size() == 0){
                System.out.println("Task is not Found{}"+taskId);
                return;

            }
            for (Task task :listOfTask){
                if (task.getTaskId().equals(taskId)){
                    System.out.println("Your Task Status is {}"+task.getTaskStatus());
                }
            }
        }
    }

    public void checkAllTask(String userId) {
        synchronized (this){
            List<Task> listOfTask = taskAssignDetails.get(userId);
            for (Task task: listOfTask){
                System.out.println(task);
            }
        }
    }

    public List<Task> filterAndSearch(Date date , TaskPriority taskPriority, TaskStatus taskStatus) {
        synchronized (this){
            List<Task> allTasks = new ArrayList<>();
            for(Map.Entry<String, List<Task>> task:taskAssignDetails.entrySet())
            {
                String userId = task.getKey();
                List<Task> listOfTask = taskAssignDetails.get(userId);
                for(Task listTask : listOfTask) {
                    if(listTask.getTaskStatus().equals(taskStatus) &&
                            listTask.getTaskPriority().equals(taskPriority) &&
                            listTask.getDate().equals(date)){
                        allTasks.add(listTask);
                    }
                }
            }
            return allTasks;

        }
    }


}








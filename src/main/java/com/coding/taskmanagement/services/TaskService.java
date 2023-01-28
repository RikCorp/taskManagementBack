package com.coding.taskmanagement.services;

import com.coding.taskmanagement.entities.Task;

import java.util.List;

public interface TaskService {
    public Task getTask(Long id);
    public Task addTask(Task task);
    public Task setTaskToDone(Long id);
    public Task setTaskToNotDone(Long id);
    public void deleteTask(Long id);
    public Task updateTask(Long id, Task task);
    public List<Task>listOfTaskNotDone();
    public List<Task>listOfTaskDone();
}

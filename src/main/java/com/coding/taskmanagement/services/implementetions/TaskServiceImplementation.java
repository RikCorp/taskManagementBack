package com.coding.taskmanagement.services.implementetions;

import com.coding.taskmanagement.entities.Task;
import com.coding.taskmanagement.repositories.TaskRepository;
import com.coding.taskmanagement.services.TaskService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TaskServiceImplementation implements TaskService {
    private TaskRepository taskRepository;
    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task addTask(Task task) {
        task.setIsdone(false);
        return taskRepository.save(task);
    }

    @Override
    public Task setTaskToDone(Long id) {
        Task task = getTask(id);
        task.setIsdone(true);
        return taskRepository.save(task);
    }

    @Override
    public Task setTaskToNotDone(Long id) {
        Task task = getTask(id);
        task.setIsdone(false);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task oldTask = getTask(id);
        oldTask.setLibelle(task.getLibelle());
        oldTask.setIsdone(task.isIsdone());
        return taskRepository.save(oldTask);
    }

    @Override
    public List<Task> listOfTaskNotDone() {
        return taskRepository.getListOfTaskNotDone();
    }

    @Override
    public List<Task> listOfTaskDone() {
        return taskRepository.getListOfTaskDone();
    }
}

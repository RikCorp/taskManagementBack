package com.coding.taskmanagement.apis;

import com.coding.taskmanagement.entities.Task;
import com.coding.taskmanagement.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Task")
@AllArgsConstructor
@CrossOrigin("*")
public class TaskApi {
    private TaskService taskService;
    @GetMapping("/getTask/{id}")
    public Task getTask(@PathVariable("id") Long id){
        return taskService.getTask(id);
    }
    @GetMapping("/setTaskToDone/{id}")
    public Task setTaskToDone(@PathVariable("id")Long id){
        return taskService.setTaskToDone(id);
    }
    @GetMapping("/setTaskToNotDone/{id}")
    public Task setTaskToNotDone(@PathVariable("id")Long id){
        return taskService.setTaskToNotDone(id);
    }
    @GetMapping("/getListOfTaskDone")
    public List<Task> getListOfTaskDone(){
        return taskService.listOfTaskDone();
    }
    @GetMapping("/getListOfTaskNotDone")
    public List<Task> getListOfTaskNotDone(){
        return taskService.listOfTaskNotDone();
    }
    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task){
       return taskService.addTask(task);
    }
    @PutMapping("/updateTask/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task){
        return taskService.updateTask(id,task);
    }
    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);
    }
}

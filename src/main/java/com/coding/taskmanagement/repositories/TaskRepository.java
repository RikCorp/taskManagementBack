package com.coding.taskmanagement.repositories;

import com.coding.taskmanagement.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface TaskRepository extends JpaRepositoryImplementation<Task, Long> {
    @Query("SELECT t from Task t where t.isdone=false")
    public List<Task> getListOfTaskNotDone();
    @Query("SELECT t from Task t where t.isdone=true")
    public List<Task> getListOfTaskDone();
}

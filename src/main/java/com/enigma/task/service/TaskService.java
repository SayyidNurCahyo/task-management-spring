package com.enigma.task.service;

import com.enigma.task.entity.Task;
import com.enigma.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    public TaskService(){

    }
    public List<Task> getTask(){
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTaskByID(Integer id, Task task) {
        Optional<Task> taskID = taskRepository.findById(id);
        if(taskID.isPresent()){
            Task taskNew = taskID.get();
            taskNew.setTask(task.getTask());
            return taskRepository.save(taskNew);
        } else {
            return null;
        }
    }

    public Task deleteTaskByID(Integer id) {
        Optional<Task> taskID = taskRepository.findById(id);
        if (taskID.isPresent()){
            Task taskDelete = taskID.get();
            taskRepository.delete(taskDelete);
            return taskDelete;
        } else {
            return null;
        }
    }
    public List<Task> getTaskByName (List<String> task) {
        return taskRepository.findAllByTaskIn(task);
    }

    public List<Task> getTaskById(List<Integer> id) {
        return taskRepository.findAllById(id);
    }
    public List<Task> searchTask(List<Integer> id, List<String> task){
        return taskRepository.findAllByIdInAndTaskIn(id, task);
    }
}

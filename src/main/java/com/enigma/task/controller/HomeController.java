package com.enigma.task.controller;

import com.enigma.task.entity.Task;
import com.enigma.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class HomeController {
    @Autowired
    TaskService taskService;
    @GetMapping("tasks")
    public List<Task> getTask(){
        return taskService.getTask();
    }
    @GetMapping(value = "tasks", params = {"id"})
    public List<Task> getTaskById(@RequestParam List<Integer> id){
        return taskService.getTaskById(id);
    }
    @GetMapping(value = "tasks", params = {"task"})
    public List<Task> getTaskByName(@RequestParam List<String> task){
        return taskService.getTaskByName(task);
    }
    @GetMapping(value = "tasks", params = {"task","id"})
    public List<Task> searchTask(@RequestParam MultiValueMap<String, String> requestParam){
        List<Integer> id= requestParam.get("id").stream().map(Integer::parseInt).collect(Collectors.toList());
        List<String> task= requestParam.get("task");
        return taskService.searchTask(id,task);
    }
    @PostMapping("tasks")
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }
    @PutMapping("tasks/{id}")
    public Task updateTaskById(@RequestBody Task task, @PathVariable Integer id){
        return taskService.updateTaskByID(id, task);
    }
    @DeleteMapping("tasks/{id}")
    public Task deleteTask(@PathVariable Integer id){
        return taskService.deleteTaskByID(id);
    }
}

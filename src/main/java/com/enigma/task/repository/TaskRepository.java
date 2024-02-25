package com.enigma.task.repository;

import com.enigma.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

    List<Task> findAllByTaskIn(List<String> tasks);
    List<Task> findAllByIdInAndTaskIn(List<Integer> id, List<String> task);
}

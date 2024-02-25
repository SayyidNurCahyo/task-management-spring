package com.enigma.task.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "m_task")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "m_task_seq")
    @SequenceGenerator(name = "m_task_seq",sequenceName = "m_task_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "task")
    private String task;

    public Task(Integer id, String task) {
        this.id = id;
        this.task = task;
    }

    public Task(String task) {
        this.task = task;
    }

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}

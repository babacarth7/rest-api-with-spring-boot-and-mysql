package com.babacarthiam.taskmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.babacarthiam.taskmanager.entities.Task;
import com.babacarthiam.taskmanager.repositories.TaskRepository;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public Task create(Task task) {
    return taskRepository.save(task);
  }

  public List<Task> findAll() {
    List<Task> tasks = new ArrayList<>();
    taskRepository.findAll().forEach(tasks::add);
    return tasks;
  }

  public Optional<Task> findById(UUID id) {
    return taskRepository.findById(id);
  }

  public Task update(Task taskToUpdate) {
    return taskRepository.save(taskToUpdate);
  }

  public void delete(UUID id) {
    taskRepository.deleteById(id);
  }

}

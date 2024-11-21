package com.babacarthiam.taskmanager.controllers;

import com.babacarthiam.taskmanager.entities.Task;
import com.babacarthiam.taskmanager.requests.CreateTaskInput;
import com.babacarthiam.taskmanager.requests.UpdateTaskInput;
import com.babacarthiam.taskmanager.services.TaskService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  public TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/tasks")
  public ResponseEntity<Task> createTask(@RequestBody CreateTaskInput createTaskInput) {
    Task taskCreated = taskService.create(createTaskInput.toTask());

    return new ResponseEntity<>(taskCreated, HttpStatus.CREATED);
  }

  @GetMapping("/tasks")
  public ResponseEntity<List<Task>> allTasks() {
    List<Task> tasks = taskService.findAll();

    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }

  @GetMapping("/tasks/{id}")
  public ResponseEntity<Task> oneTask(@PathVariable UUID id) {
    Optional<Task> optionalTask = taskService.findById(id);

    if (optionalTask.isPresent()) {
      return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PatchMapping("/tasks/{id}")
  public ResponseEntity<Task> updateTask(
      @PathVariable UUID id, @RequestBody UpdateTaskInput updateTaskInput) {
    Optional<Task> optionalTask = taskService.findById(id);

    if (optionalTask.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Task taskToUpdate = optionalTask.get();

    taskToUpdate.setStatus(updateTaskInput.status());
    taskToUpdate.setDueDate(updateTaskInput.dueDate());

    Task taskUpdated = taskService.update(taskToUpdate);

    return new ResponseEntity<>(taskUpdated, HttpStatus.OK);
  }

  @DeleteMapping("/tasks/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
    taskService.delete(id);

    return ResponseEntity.noContent().build();
  }
}

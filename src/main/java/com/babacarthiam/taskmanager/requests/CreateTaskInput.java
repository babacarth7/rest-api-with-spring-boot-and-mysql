package com.babacarthiam.taskmanager.requests;

import com.babacarthiam.taskmanager.entities.Task;
import com.babacarthiam.taskmanager.entities.TaskStatusEnum;
import java.util.Date;

public record CreateTaskInput(
    String name, String description, TaskStatusEnum status, Date dueDate) {
  public Task toTask() {
    Task task = new Task();

    task.setName(name).setDescription(description).setStatus(status).setDueDate(dueDate);

    return task;
  }
}

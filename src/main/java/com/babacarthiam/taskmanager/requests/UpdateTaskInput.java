package com.babacarthiam.taskmanager.requests;

import com.babacarthiam.taskmanager.entities.TaskStatusEnum;
import java.util.Date;

public record UpdateTaskInput(TaskStatusEnum status, Date dueDate) {}

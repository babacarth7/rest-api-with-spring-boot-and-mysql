package com.babacarthiam.taskmanager.repositories;

import com.babacarthiam.taskmanager.entities.Task;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {}

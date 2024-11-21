package com.babacarthiam.taskmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "tasks")
@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private UUID id;

  @Column(unique = true, length = 200, nullable = false)
  private String name;

  @Lob private String description;

  @Column(nullable = false, columnDefinition = "varchar(200) not null default 'PENDING'")
  @Enumerated(EnumType.STRING)
  private TaskStatusEnum status;

  @Column(name = "due_date")
  private Date dueDate;

  @CreationTimestamp
  @Column(updatable = false, name = "created_at")
  private Date createdAt;

  @UpdateTimestamp
  @Column(name = "update_at")
  private Date updateAt;

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public TaskStatusEnum getStatus() {
    return status;
  }

  public Date getDuedate() {
    return dueDate;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdateAt() {
    return updateAt;
  }

  public Task setId(UUID id) {
    this.id = id;
    return this;
  }

  public Task setName(String name) {
    this.name = name;
    return this;
  }

  public Task setDescription(String description) {
    this.description = description;
    return this;
  }

  public Task setStatus(TaskStatusEnum status) {
    this.status = status;
    return this;
  }

  public Task setDueDate(Date dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  public Task setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Task setUpdatedAt(Date updateAt) {
    this.updateAt = updateAt;
    return this;
  }

  @Override
  public String toString() {
    return "Task{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", status="
        + status
        + ", dueDate="
        + dueDate
        + ", createdAt="
        + createdAt
        + ", updateAt="
        + updateAt
        + '}';
  }
}

package org.springframework.samples.petclinic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dashboard_entry")
public class DashboardEntry extends BaseEntity {

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "instructions")
    private String instructions;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="created")
    private LocalDateTime created;


    public String getTaskName() {
        return taskName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTaskName(String name) {
        this.taskName = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}


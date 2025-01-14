package org.springframework.samples.petclinic.domain;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "instructions")
    private String instructions;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;


    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
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

}


package org.springframework.samples.petclinic.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "task")
public class Task extends BaseEntity {


    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "due_date")
    @NotEmpty
    private LocalDate dueDate;

    @Column(name = "instructions")
    @NotEmpty
    private String instructions;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
//    private List<User> persons;

    @Column(name="status")
    @NotEmpty
    private Status status;


    public String getName() {
        return name;
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

//    public List<User> getPersons() {
//        return persons;
//    }
//
//    public void setPersons(List<User> persons) {
//        this.persons = persons;
//    }

}


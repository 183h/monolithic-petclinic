package org.springframework.samples.petclinic.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "task")
public class Task extends BaseEntity {

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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "due_date")
    @NotEmpty
    private LocalDate dueDate;

    @Column(name = "instructions")
    @NotEmpty
    private String instructions;
    // TODO: maybe create separate entity for instruction if needed

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "task_person", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> persons;
}

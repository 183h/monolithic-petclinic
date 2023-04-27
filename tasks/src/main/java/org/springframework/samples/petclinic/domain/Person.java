package org.springframework.samples.petclinic.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person extends BaseEntity {
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "task_person", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;
}

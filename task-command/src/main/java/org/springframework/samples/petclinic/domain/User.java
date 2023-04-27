package org.springframework.samples.petclinic.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Column(name = "name")
    private String name;


    @Column(name = "is_supervisor")
    private boolean isSuperVisor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuperVisor() {
        return isSuperVisor;
    }

    public void setSuperVisor(boolean superVisor) {
        isSuperVisor = superVisor;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

package org.springframework.samples.petclinic.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "teamId", referencedColumnName = "id")
    private User superVisor;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="teamId", referencedColumnName = "id")
    private List<User> users;

    public User getSuperVisor() {
        return superVisor;
    }

    public void setSuperVisor(User superVisor) {
        this.superVisor = superVisor;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

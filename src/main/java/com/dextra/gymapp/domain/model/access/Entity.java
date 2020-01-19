package com.dextra.gymapp.domain.model.access;

import com.dextra.gymapp.domain.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@javax.persistence.Entity
@Table(name="ENTITY")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ENTITY_ID")
    private Long id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "USERS")
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

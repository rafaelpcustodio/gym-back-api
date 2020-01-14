package com.dextra.gymapp.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@javax.persistence.Entity
@Table(name="ENTITIES")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="entityId")
    private Long id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "users")
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

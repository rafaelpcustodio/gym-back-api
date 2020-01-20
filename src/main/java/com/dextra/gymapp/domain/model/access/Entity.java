package com.dextra.gymapp.domain.model.access;

import com.dextra.gymapp.domain.enums.EntityName;
import com.dextra.gymapp.domain.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@javax.persistence.Entity
@Table(name="ENTITY")
public class Entity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ENTITY_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotBlank
    @Column(name = "NAME")
    private EntityName name;

    @ManyToMany(mappedBy = "entities")
    private Set<User> users = new HashSet<>();

    public EntityName getName() {
        return name;
    }

    public void setName(EntityName name) {
        this.name = name;
    }

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
